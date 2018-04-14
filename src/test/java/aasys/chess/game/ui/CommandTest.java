/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.ui;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandTest {
    @Test
    public void specificationTest() throws Exception {
        CommandProcessor commandProcessor = new CommandProcessor();

        String command = "WHITE: Rf1, Kg1, Pf2, Ph2, Pg3";
        System.out.println(command);
        String out = commandProcessor.processCommand(command);
        System.out.println(out);
        assertTrue(out.startsWith("OK"));

        command = "BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
        System.out.println(command);
        out = commandProcessor.processCommand(command);
        System.out.println(out);
        assertTrue(out.startsWith("OK"));

        command = "PIECE TO MOVE: Rf1";
        System.out.println(command);
        out = commandProcessor.processCommand(command);
        System.out.println(out);
//        assertTrue(out.startsWith("LEGAL MOVES FOR Rf1: e1, d1, c1, b1, a1"));
    }
}
