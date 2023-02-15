package com.example.filijaliibankomati.repository;

import com.example.filijaliibankomati.model.Filijali;
import com.example.filijaliibankomati.model.PalceDoesNotExist;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FilijaliRepository {
    public static List<Filijali> filijaliList = new ArrayList<>();

    public FilijaliRepository() throws IOException {
        BufferedReader barCsvReader = new BufferedReader(new FileReader("src/main/java/com/example/filijaliibankomati/repository/filijali.csv"));
        String row = "";
        int flag = 0;
        Random random = new Random();

        while((row = barCsvReader.readLine())!= null){
            String []barData = row.split("\\|");
            if ( flag > 0 ){
                filijaliList.add(new Filijali(barData[0], barData[3], Double.parseDouble(barData[5]), Double.parseDouble(barData[6]), barData[8], barData[12]));
            }
            flag++;
        }
        flag = 0;
    }

    public Optional<Filijali> findById(Long id){
        return filijaliList.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    public List<Filijali> listAll(){
        return filijaliList;
    }

    public Filijali findByName(String name){
        return filijaliList.stream().filter(x->x.getName().equals(name) )
                .findFirst().orElseThrow(PalceDoesNotExist::new);
    }
    public List<Filijali> findByCity(String city){
        return filijaliList.stream().filter(x->x.getCity().equals(city)).collect(Collectors.toList());
    }
    public Set<String> listCities(){
        return filijaliList.stream().map(bankomati -> bankomati.getCity()).collect(Collectors.toSet());
    }
}
