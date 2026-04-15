package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TaskController{
    
    @Autowired
    private TaskService taskService;

   
    private DummyService dummyService;
  
    @Autowired
    public TaskController(DummyService dummyService){
        this.dummyService = dummyService;
    }


    @GetMapping("/task")
    public String getTast() {
        return taskService.doTask();
    }

    @GetMapping("/myname")
    public String getname(@RequestParam String name){
        return taskService.name(name);
    
    }

    @GetMapping("/demo/{id}")
    public String getdemo(@PathVariable int id){
        return dummyService.demo(id);
    }

    @GetMapping("/add")
    public String  add(@RequestParam int a, int b){
      return dummyService.sum(a,b);
    }
    }
    
    

