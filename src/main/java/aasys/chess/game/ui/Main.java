/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.ui;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CommandProcessor commandProcessor = new CommandProcessor();
        System.out.println("Enter commands line by line");
        System.out.print(">");
        while(sc.hasNextLine()) {
            try {
                System.out.println(commandProcessor.processCommand(sc.nextLine()));
            } catch (Exception ex) {
                System.out.println("ERROR processing command: " + ex.getMessage());
                System.out.println("Restart from beginning");
                System.out.println();
                System.out.println();
                System.out.println("Enter commands line by line");
                commandProcessor =  new CommandProcessor();
            }
            System.out.print(">");
        }
    }
}
