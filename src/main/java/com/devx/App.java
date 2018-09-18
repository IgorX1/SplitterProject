package com.devx;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args) {
        try {
            Parser parser = new Parser("123.log");
            System.out.println("Konobas Igor TTP-31\n");
            ArrayList<String> res = parser.getResult();
            for (String s : res) {
                System.out.println(s);
            }
        }
        catch (Exception e){
            System.out.println("Program terminated after an error.");
        }
        System.out.println("Finished");
    }
}
