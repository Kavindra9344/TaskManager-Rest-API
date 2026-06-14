package com.example.taskmanager;

public class TaskErrorResponse {
    private int status;
    private String messge;
    private Long timestamp;

    public TaskErrorResponse(int status, String messge, Long timestamp){
        this.status = status;
        this.messge = messge;
        this.timestamp = timestamp;
    }

    public int getStatus(){
        return status;
    }

    public String getMessge(){
        return messge;
    }

    public Long getTimestamp(){
        return timestamp;
    }
}
