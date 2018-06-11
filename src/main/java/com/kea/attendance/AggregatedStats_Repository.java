package com.kea.attendance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AggregatedStats_Repository extends CrudRepository<AggregatedStats, Long> {
    List<AggregatedStats> findAllByCourseID(int courseID);
    List<AggregatedStats> findAllByStudentID(int studentID);
}

