package com.example.huffmangui.com.kacperfin.decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class Decode {
    public static int decode(String input_name, String output_name, ArrayList<String> codes) throws Exception
    {
        FileInputStream read = new FileInputStream(new File("files/"+input_name));
        FileWriter write = new FileWriter(new File("files/"+output_name));
        String current_code="";
        String temp_code;
        int b;
        int ascii;

        while(((b = read.read()) != -1) && (b != 0))
        {
            ;
        }

        current_code = "";
        while((b = read.read()) != -1)
        {
            temp_code = Dec2Bin.intToBinary(b);
            for(int i=0; i<8; i++)
            {
                current_code += temp_code.charAt(i);
                ascii = GetDecodedChar.getDecodedChar(current_code, codes);
                if(ascii==512)
                {
                    break;
                }
                else if(ascii!=-2)
                {
                    write.write((char) ascii);
                    current_code = "";
                }
                else //if ascii==-1, meaning it hasn't found a char
                {
                    ;
                }
            }

        }
        write.close();

        return 0;
    }
}
