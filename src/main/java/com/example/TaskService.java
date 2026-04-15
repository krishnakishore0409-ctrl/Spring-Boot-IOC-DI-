package com.example;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public String doTask() {
        return "Task completed!";
    }

    public String name(String name){
        return "MY name is "+ name;
    }
}

 