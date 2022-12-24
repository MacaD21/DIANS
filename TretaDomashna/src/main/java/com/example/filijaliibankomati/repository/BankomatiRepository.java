package com.example.filijaliibankomati.repository;

import com.example.filijaliibankomati.model.Bankomati;
import com.example.filijaliibankomati.model.PalceDoesNotExist;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BankomatiRepository {
    public static List<Bankomati> bankomatiList = new ArrayList<>();

    public BankomatiRepository() throws IOException {
        BufferedReader barCsvReader = new BufferedReader(new FileReader("src/main/java/com/example/filijaliibankomati/repository/bankomati.csv"));
        String row = "";
        int flag = 0;
        Random random = new Random();

        while((row = barCsvReader.readLine())!= null){
            String []barData = row.split("\\|");
            if ( flag > 0 ){
                bankomatiList.add(new Bankomati(barData[0], barData[2], barData[4],barData[5], barData[7], barData[11]));
            }
            flag++;
        }
        flag = 0;
    }

    public Optional<Bankomati> findById(Long id){
        return bankomatiList.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    public List<Bankomati> listAll(){
        return bankomatiList;
    }

    public Bankomati findByName(String name){
        return bankomatiList.stream().filter(x->x.getName().equals(name) )
                .findFirst().orElseThrow(PalceDoesNotExist::new);
    }

    public List<Bankomati> findByCity(String city){
        return bankomatiList.stream().filter(x->x.getCity().equals(city)).collect(Collectors.toList());
    }
    public Set<String> listCities(){
        return bankomatiList.stream().map(bankomati -> bankomati.getCity()).collect(Collectors.toSet());
    }
}
