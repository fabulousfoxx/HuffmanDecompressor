package com.example.huffmangui.com.kacperfin.decompressor;

public class Dec2Bin {
    public static String intToBinary(int number)
    {
        String a = "";
        for(int i=1; i<=8; i++)
        {
            if(number%2==1) a = "1" + a;
            else a = "0" + a;
            number/=2;
        }

        return a;
    }
}
