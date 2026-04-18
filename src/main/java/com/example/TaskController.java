package com.example;

import java.util.ArrayList;
import java.util.List;
import com.example.Task;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TaskController{

    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public String getTask(){
        return taskService.doTask();
    }

    @GetMapping("/check")
    public String getMethodName(@RequestParam String name) {
        return taskService.name(name);
    }
    
    
    
    private List<Task> tasks = new ArrayList<>();
    

    @PostMapping("/task")
    public String addTask(@RequestBody Task task) {
        tasks.add(task);
        return "Task Added Successfully";
    }

       @PutMapping("/task/{id}")
    public String updateTask(@PathVariable int id, @RequestBody Task updatedTask) {

        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setName(updatedTask.getName());
                t.setStatus(updatedTask.getStatus());
                return "Task Updated Successfully";
            }
        }
        return "Task Not Found";
    }

     @GetMapping("/getTask")
    public List<Task> getTasks() {
        return tasks;
    }

    @DeleteMapping("/deleteTask/{id}")
     public String deleteTask(@PathVariable  int id){
                
            for(Task t : tasks){
                if(t.getId() == id){
                    tasks.remove(t);
                    return "Task delete Successfully";
                }
            }
            return "Not delete Task Id: "+id;
     }

}

