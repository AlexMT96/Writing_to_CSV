package com.company;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	//This creates a directory and fills the info
        String PATH = "C:/Users/alexm/Desktop/data/";

        File dir = new File("C:/Users/alexm/Desktop/data/");

        if(dir.exists())
        {
            System.out.println("Directory exist");
        }
        else
        {
            System.out.println("Directory does not exist, creating it...");
            new File("C:/Users/alexm/Desktop/data/").mkdirs();
            File stockfile = new File("C:/Users/alexm/Desktop/data/inventory.csv");
            try {
                stockfile.createNewFile();
            } catch (IOException e)
            {
                System.out.println("Error while Creating File in Java" + e);
            }
            System.out.println("Directory created successfully");
            System.out.println("stock file" + stockfile.getPath() + " created ");
        }

        System.out.println("Insert the next data:");
        Scanner sc = new Scanner(System.in);

        String name;
        String brand;
        String location;
        int volume;
        int alcohol;
        int quantity;
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("\nBrand: ");
        brand = sc.nextLine();
        System.out.print("\nLocation: ");
        location = sc.nextLine();;
        System.out.print("\nVolume: ");
        volume = sc.nextInt();
        System.out.print("\nAlcohol %: ");
        alcohol =sc.nextInt();
        System.out.print("\nHow many: ");
        quantity = sc.nextInt();

        try {
            PrintWriter writer = new PrintWriter("C:/Users/alexm/Desktop/data/inventory.csv");
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(',');
            sb.append(brand);
            sb.append(',');
            sb.append(location);
            sb.append(',');
            sb.append(volume);
            sb.append(',');
            sb.append(alcohol);
            sb.append(',');
            sb.append(quantity);
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());

        }




    }
}
