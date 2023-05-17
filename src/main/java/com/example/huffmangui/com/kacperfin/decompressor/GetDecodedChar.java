package com.example.huffmangui.com.kacperfin.decompressor;

import java.util.ArrayList;

public class GetDecodedChar {

    public static int getDecodedChar(String code, ArrayList<String> codes)
    {
        for(int i=0; i<513; i++)
        {
            if(code.equals(codes.get(i))) return i;
        }

        return -2;
    }
}
