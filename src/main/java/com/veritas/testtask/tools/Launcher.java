package com.veritas.testtask.tools;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        BBProcessor bbp = new BBProcessor("replacements.txt");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text = bbp.process(text);
        System.out.println("End result: " + text);
    }

}
