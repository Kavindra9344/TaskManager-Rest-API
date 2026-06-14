package com.example.taskmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TaskErrorResponse> handleException(TaskException e){
        TaskErrorResponse error=new TaskErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<TaskErrorResponse> handleException(Exception e){
        TaskErrorResponse errorResponse=new TaskErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
