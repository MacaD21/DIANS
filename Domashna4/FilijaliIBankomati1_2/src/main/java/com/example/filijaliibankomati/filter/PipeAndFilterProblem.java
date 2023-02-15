package com.example.filijaliibankomati.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PipeAndFilterProblem{
    public static void main(String[] args) throws IOException {
        Pipe<String> pipe = new Pipe<>();
        CapitalizeBankomatFilter capitalizeBankomatFilter = new CapitalizeBankomatFilter();
        pipe.addFilter(capitalizeBankomatFilter);


        Scanner scanner = new Scanner(new File("C:\\Users\\Marija Dimitrova\\OneDrive\\Desktop\\FilijaliIBankomati1\\src\\main\\java\\com\\example\\filijaliibankomati\\repository\\bankomati.csv"));
        scanner.useDelimiter(",");
        FileWriter writer = new FileWriter("C:\\Users\\Marija Dimitrova\\OneDrive\\Desktop\\FilijaliIBankomati1\\src\\main\\java\\com\\example\\filijaliibankomati\\repository\\bankomatiNova.csv");
        //List<String> lists = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = pipe.runFilter(scanner.nextLine());
            if(s!=null) {
                //lists.add(s);
                writer.write(s);
                writer.write("\n");
                writer.flush();
            }
        }
        writer.close();

        Pipe<String> pipe1 = new Pipe<>();
        CapitalizeFilijalaFilter capitalizeFilijalaFilter = new CapitalizeFilijalaFilter();
        pipe1.addFilter(capitalizeFilijalaFilter);
        Scanner scanner1 = new Scanner(new File("C:\\Users\\Marija Dimitrova\\OneDrive\\Desktop\\FilijaliIBankomati1\\src\\main\\java\\com\\example\\filijaliibankomati\\repository\\filijali.csv"));
        scanner.useDelimiter(",");
        FileWriter writer1 = new FileWriter("C:\\Users\\Marija Dimitrova\\OneDrive\\Desktop\\FilijaliIBankomati1\\src\\main\\java\\com\\example\\filijaliibankomati\\repository\\filijaliNova.csv");
        //List<String> lists = new ArrayList<>();

        while (scanner1.hasNextLine()) {
            String s = pipe1.runFilter(scanner1.nextLine());
            if(s!=null) {
                //lists.add(s);
                writer1.write(s);
                writer1.write("\n");
                writer1.flush();
            }
        }
        writer1.close();
    }
}
