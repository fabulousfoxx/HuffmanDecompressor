package com.example.huffmangui.com.kacperfin.compressor;

import java.io.File;

public class Compressor {

    public static int compress(String input_name) throws Exception {
        //System.out.println(new File("compress-script.sh").getAbsoluteFile());
        //String[] command = {"./compress-script.sh", input_name};
        String[] command = {"bash", "compress-script.sh", input_name};
        //[] command = {"bash", "src\\main\\java\\com\\example\\huffmangui\\com\\kacperfin\\compressor\\compress-script.sh", input_name};
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        return process.waitFor(); //0 = no errors, script has been executed correctly
    }
}
