package com.example.filijaliibankomati.filter;

public class CapitalizeBankomatFilter implements Filter<String>{
    @Override
    public String execute(String input) {
        String[] parts = input.split("\\|");
        String ime = parts[7].substring(0, 1).toUpperCase();
        String nameCapitalized = ime + parts[7].substring(1).toLowerCase();
        String finalna= "";
        for(int i=0; i< parts.length;i++){
            if(i==7)
                finalna+=nameCapitalized;
            else
                finalna+=parts[i];
            finalna+="|";
        }
        return finalna.substring(0,finalna.length()-1);
}
}
