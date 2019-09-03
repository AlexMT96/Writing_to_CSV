package com.company;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
	//This creates a directory and fills the info
        String PATH = "C:/Users/Zohar/Desktop/data/";

        //beer information
        String name;
        String brand;
        String location;
        int volume;
        int alcohol;
        int quantity;


        File dir = new File("C:/Users/Zohar/Desktop/data/");

        if(dir.exists())
        {
            System.out.println("Directory exist");
        }
        else
        {
            System.out.println("Directory does not exist, creating it...");
            
            new File("C:/Users/Zohar/Desktop/data/").mkdirs();
            File stockfile = new File("C:/Users/Zohar/Desktop/data/inventory.txt");
            
            try {
                stockfile.createNewFile();
            }
            
            catch (IOException e)
            {
                System.out.println("Error while Creating File in Java" + e);
            }
            
            System.out.println("Directory created successfully");
            System.out.println("stock file" + stockfile.getPath() + " created ");
        }

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        //input data and write
        if(option == 1){
            System.out.println("Insert the next data:");

            sc.nextLine(); //grabs the carriage return character from option so it can discard it
            
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

            String info = name + " " + brand + " " + location + " " + volume + " " + alcohol + " " + quantity;

            File inventory = new File("C:/Users/Zohar/Desktop/data/inventory.txt");
            FileWriter fileWriter = new FileWriter(inventory, true);
            fileWriter.write(info);
            fileWriter.write("\r\n");
            fileWriter.flush();
            fileWriter.close();
        }

        //read data from the file
        if(option == 2)
        {
            Scanner read = new Scanner(new File("C:/Users/Zohar/Desktop/data/inventory.txt"));
            //read.useDelimiter(",");
            try
            {
                while(read.hasNext())
                {
                    System.out.printf("Name: %s%nBrand: %s%nLocation: %s%nVolume: %d%nAlcohol: %d%nQuantity: %d%n",
                            read.next(), read.next(), read.next(), read.nextInt(), read.nextInt(), read.nextInt());
                    
                    System.out.println();
                }
            }
            
            catch (NoSuchElementException elementException)
            {
                System.out.println("File improperly formed.  Terminating.");
            }
        }
    }
}