package com.example;
import org.springframework.stereotype.Service;
;

@Service
public class DummyService {
      public String demo(int id){
        return "I Am Dummy bro! "+ id;
    }

    public String sum(int a, int b){
        return "Add : "+ (a+b) ;
    }
}
