package com.example.huffmangui;

import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        String input;
        int exitCode;
        String input_name, output_name;
        Scanner scanner = new Scanner(System.in);
        //File f  = new File("file.txt");
        //System.out.println("Path: " + f.getAbsolutePath());
        System.out.println("Hey!");

        while(true)
        {
            System.out.println("Write \"1\" if you want to compress.");
            System.out.println("Write \"2\" if you want to decompress.");
            System.out.println("Write EXIT to quit the program.");

            input = scanner.nextLine();

            if(input.equals("1"))
            {
                System.out.println("Give me the name of the input file with the message to encode.");
                System.out.println("File must be located in the \"files\" folder.");
                input_name = scanner.nextLine();

                exitCode = Facade.compress(input_name);

                if(exitCode == 0)
                {
                    System.out.println("Your file has been saved in the \"files\" folder."); //0 means there are no errors
                }
                else
                {
                    System.out.println("Something went wrong.");
                }
            }
            else if(input.equals("2"))
            {
                System.out.println("Give me the name of the input file with the message to decode.");
                System.out.println("File must be located in the \"files\" folder.");
                input_name = scanner.nextLine();
                System.out.println("Give me the name of the output file to save the decoded message.");
                System.out.println("File must be located in the \"files\" folder.");
                output_name = scanner.nextLine();

                exitCode = Facade.decompress(input_name, output_name);
                System.out.println(exitCode);
            }
            else if(input.equals("EXIT"))
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Incorrect input.");
            }
        }
    }
}