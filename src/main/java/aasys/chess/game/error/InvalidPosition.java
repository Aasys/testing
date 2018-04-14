/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.error;

public class InvalidPosition extends Exception {
    public InvalidPosition() {
        super("Invalid Position: Specified position out of valid range!");
    }
}
