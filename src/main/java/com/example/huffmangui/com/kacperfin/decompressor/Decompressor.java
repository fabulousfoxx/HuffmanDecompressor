package com.example.huffmangui.com.kacperfin.decompressor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Decompressor {
    public static int decompress(String input_name, String output_name) throws Exception {

        Util.hufDictionaryToTxt(input_name, "_dictionary.txt");
        ArrayList<String> codes = new ArrayList<String>(513);
        Util.hufDictionaryTxtToArrayList("_dictionary.txt", codes);
        //Util.printCodes(codes);
        Decode.decode(input_name, output_name, codes);

        return Decode.decode(input_name, output_name, codes); //0 = no errors, decompressed correctly
    }
}
