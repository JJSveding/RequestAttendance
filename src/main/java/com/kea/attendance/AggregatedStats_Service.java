package com.kea.attendance;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregatedStats_Service {
    AggregatedStats_Repository aggregatedStats_repository;

    public AggregatedStats_Service(AggregatedStats_Repository attendance_statistics_aggregated_repository)
    {
        this.aggregatedStats_repository = attendance_statistics_aggregated_repository;
    }

    public void save(AggregatedStats ASA) {

        aggregatedStats_repository.save(ASA);
    }

    public List<AggregatedStats> findAllByCourseID(int courseID){
        return aggregatedStats_repository.findAllByCourseID(courseID);
    }


    public List<AggregatedStats> findAllByStudentID(int studentID){
        return aggregatedStats_repository.findAllByStudentID(studentID);
    }
}
