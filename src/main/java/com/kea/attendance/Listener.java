package com.kea.attendance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Listener {
    String jsonInString = null;

    @Autowired
    AggregatedStats_Service ASAService;

    @JmsListener(destination = "AttendanceRequest")
    public void receiveMessage(final Message jsonmessage){
        String message = Utility.readMessage(jsonmessage);
        AttendanceRequest object = Utility.makeObject(message);


        ReportData rd = new ReportData();
        rd.setToEmail(object.getEmail());

        List<AggregatedStats> list = null;

        if(object.getTypeOfRequest()==1) //Single student?
        {
           list = ASAService.findAllByStudentID(object.getSubject().get(0));

           /* FOR TESTING ONLY - Can be deleted!
            for (AggregatedStats ele: list) {
                System.out.println("----------------------------------");
                System.out.println(ele.getStudentID());
                System.out.println(ele.getCourseName());
                System.out.println(ele.getStudentName() + list.get(0).getStudentSurname());
                System.out.println(ele.getAttendancePercentage());
            }
            */

            
        }else if (object.getTypeOfRequest()==2) //Multiple students / All
        {
            list = new ArrayList<>();

            for (int id:object.getSubject()) {
                list.addAll( ASAService.findAllByCourseID(id));
            }

        }else if (object.getTypeOfRequest()==3) // Students in a class
        {
            list = new ArrayList<>();

            for (int id:object.getSubject()) {
                list.addAll( ASAService.findAllByStudentID(id));
            }
        }else{
            //NOTHING
        }

        //Loop through list of objects found
        for (AggregatedStats temp: list) {
            ReportContent rc = new ReportContent();
            rc.setCourseName(temp.getCourseName());
            rc.setStudentName(temp.getStudentName());
            rc.setStudentSurname(temp.getStudentSurname());
            rc.setAttendancePercentage(temp.getAttendancePercentage());

            /* FOR TESTING ONLY. - Can be deleted
            System.out.println(rc.getStudentName());
            System.out.println(rc.getStudentSurname());
            System.out.println(rc.getCourseName());
            System.out.println(rc.getAttendancePercentage());
            */

            rd.addToContent(rc);
        }


        JmsTemplate template = new JmsTemplate(Utility.connectionFactory());

        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(rd);
        }catch(Exception e){

        }

        Producer producer = new Producer(template);
        producer.sendMessage(jsonInString);
    }
}
