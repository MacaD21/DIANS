package com.example.filijaliibankomati.bootstrap;

import com.example.filijaliibankomati.model.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        users.add(new User("marija.dimitrova","md","Marija","Dimitrova"));
        users.add(new User("katerina.zlateska","kz","Katerina","Zlateska"));
        users.add(new User("angela.ivanova","ai","Angela","Ivanova"));
    }
}
