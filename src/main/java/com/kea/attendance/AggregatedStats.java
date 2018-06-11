package com.kea.attendance;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="attendance_statistics_aggregated")
@IdClass(AggregatedStats.class)
public class AggregatedStats implements Serializable{
    @Id
    @Column(name="CourseID")
    private int courseID;

    @Column(name="CourseName")
    private String courseName;

    @Id
    @Column(name="StudentID")
    private int studentID;

    @Column(name="StudentName")
    private String StudentName;

    @Column(name="StudentSurname")
    private String StudentSurname;

    @Column(name="TotalCourseMinutes")
    private int TotalCourseMinutes;

    @Column(name="AttendedTime")
    private int attendedMinutes;

    @Column(name="AttendancePercentage")
    private double attendancePercentage;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentSurname() {
        return StudentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        StudentSurname = studentSurname;
    }

    public int getTotalCourseMinutes() {
        return TotalCourseMinutes;
    }

    public void setTotalCourseMinutes(int totalCourseMinutes) {
        TotalCourseMinutes = totalCourseMinutes;
    }

    public int getAttendedMinutes() {
        return attendedMinutes;
    }

    public void setAttendedMinutes(int attendedMinutes) {
        this.attendedMinutes = attendedMinutes;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}
