package com.example.taskmanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus("TODO");
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        if(!taskRepository.existsById(id)){
            throw new TaskException("Task with id "+id+" not found");
        }
        taskRepository.deleteById(id);
    }

    public void updateTask(Long id,String title,String description,String status){

        Task task=taskRepository.findById(id)
                .orElseThrow(()->new TaskException("Task with id "+id+" not found!"));

        if(title!=null&&title.length()>0){
            task.setTitle(title);
        }

        if(description!=null&&description.length()>0){
            task.setDescription(description);
    }
        if(status!=null&&status.length()>0){
            task.setStatus(status);
        }
        taskRepository.save(task);

    }

}
