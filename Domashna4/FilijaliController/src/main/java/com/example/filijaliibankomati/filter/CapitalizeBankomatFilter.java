package com.example.filijaliibankomati.filter;

public class CapitalizeBankomatFilter implements Filter<String>{
    @Override
    public String execute(String input) {
        String[] parts = input.split("\\|");
        StringBuilder ime = new StringBuilder();
        String[] pom = parts[7].split(" ");
        for(int i=0; i< pom.length; i++)
        {
            String imePart = pom[i].substring(0, 1).toUpperCase()+pom[i].substring(1).toLowerCase();
            ime.append(imePart).append(" ");
        }
        String finalna= "";
        for(int i=0; i< parts.length;i++){
            if(i==7)
                finalna+=ime.substring(0,ime.length()-1);
            else
                finalna+=parts[i];
            finalna+="|";
        }
        return finalna.substring(0,finalna.length()-1);
}
}
