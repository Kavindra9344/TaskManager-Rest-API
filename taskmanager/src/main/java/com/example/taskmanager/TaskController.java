package com.example.taskmanager;


import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping(path="/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.deleteTask(id);
    }


    @PutMapping
    public void updateTask(
            @PathVariable Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String Status
    ){
        taskService.updateTask(id,title,description,Status);
    }
}
