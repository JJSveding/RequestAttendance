package com.kea.attendance;

import java.util.ArrayList;
import java.util.List;

public class AttendanceRequest {
    private int typeOfRequest; //Used to determine if request is for Single student, Course or all students
    private String email;
    private List<Integer> subject;


    public AttendanceRequest(){
        this.subject = new ArrayList<>();
    }


    public int getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(int typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addToList(int subject){
        this.subject.add(subject);
    }

    public void removeFromList(int subject)
    {
        this.subject.remove(subject);
    }

    public List<Integer> getSubject() {
        return subject;
    }
}
