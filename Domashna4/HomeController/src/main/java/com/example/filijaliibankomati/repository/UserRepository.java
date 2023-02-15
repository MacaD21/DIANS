package com.example.filijaliibankomati.repository;

import com.example.filijaliibankomati.bootstrap.DataHolder;
import com.example.filijaliibankomati.model.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepository {
    public static List<User> usersList = new ArrayList<>();

    public UserRepository() throws IOException {
        BufferedReader barCsvReader = new BufferedReader(new FileReader("src/main/java/com/example/filijaliibankomati/repository/users.csv"));
        String row = "";
        int flag = 0;
        Random random = new Random();

        while((row = barCsvReader.readLine())!= null){
            String []barData = row.split("\\|");
            if ( flag > 0 ){
                usersList.add(new User(barData[0], barData[1], barData[2],barData[3]));
            }
            flag++;
        }
        flag = 0;
    }

    public Optional<User> findByUsername(String username){
        return usersList.stream().filter(r->r.getUsername().equals(username)).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password)
    {
        return usersList.stream().filter(r->r.getUsername().equals(username) && r.getPassword().equals(password)).findFirst();

    }

    public User saveOrUpdate(User user) throws IOException {
        usersList.removeIf(r->r.getUsername().equals(user.getUsername())) ;
        usersList.add(user);
        File file = new File("src/main/java/com/example/filijaliibankomati/repository/users.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fileWriter);

        pw.append("\n");
        pw.append(user.getUsername());
        pw.append("|");
        pw.append(user.getPassword());
        pw.append("|");
        pw.append(user.getName());
        pw.append("|");
        pw.append(user.getSurname());

        pw.close();

        return user;
    }

    public void delete(String username){
        DataHolder.users.removeIf(r->r.getUsername().equals(username));
    }
}
