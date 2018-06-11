package com.kea.attendance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;

import javax.jms.ConnectionFactory;
import javax.jms.TextMessage;

public class Utility {

    private static final String JMS_BROKER_URL = "tcp://localhost:61616";


    public static ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(JMS_BROKER_URL);
    }

    public static String readMessage(Message jsonmessage){
        if(jsonmessage instanceof TextMessage){
            TextMessage textMessage = (TextMessage) jsonmessage;

            try{
                System.out.println(textMessage.getText());
                return textMessage.getText();
            }catch (Exception e)
            {
                //NOTHING
            }
        }
        return "ERROR";
    }


    public static AttendanceRequest makeObject(String objectMessage){

        ObjectMapper mapper = new ObjectMapper();
        AttendanceRequest object = null;

        try{
            object = mapper.readValue(objectMessage,new TypeReference<AttendanceRequest>(){});
        }catch (Exception e)
        {
            //NOTHING
        }

        return object;
    }
}
