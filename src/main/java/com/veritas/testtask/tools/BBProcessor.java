package com.veritas.testtask.tools;

import java.io.*;
import java.util.HashMap;

public class BBProcessor {

    private HashMap<String, String> replacaments;

    public BBProcessor(String configuration) {
        replacaments = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(configuration)));
            String line;
            String[] vars;
            while ((line = br.readLine()) != null) {
                vars = line.split(" ");
                replacaments.put(vars[0],vars[1]); //check line correctness!
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: configuration file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: failed reading configuration file.");
            e.printStackTrace();
        }
    }

    String process(String text) {
        for (HashMap.Entry<String, String> entry : replacaments.entrySet()) {
            //System.out.println("--> Replacing " + entry.getKey() + " with " + entry.getValue());
            text = text.replace(entry.getKey(), entry.getValue());
            //System.out.println("Result so far: " + text);
        }
        return text;
    }

}
