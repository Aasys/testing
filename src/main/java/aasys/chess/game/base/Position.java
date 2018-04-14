/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import com.google.common.base.Preconditions;

public class Position {
    private int x;
    private int y;

    /**
     * Precondition check for range "a1" to "h8"
     *
     * @param positionString 2 character position eg "a1"
     */
    public Position(String positionString) {
        Preconditions.checkNotNull(positionString);
        Preconditions.checkArgument(positionString.length() == 2, "positionString should be 2 characters long");

        char xChar = positionString.charAt(0);
        char yChar = positionString.charAt(1);

        Preconditions.checkArgument(xChar >= 'a' && xChar <= 'h', "first character is only valid for a - h");
        Preconditions.checkArgument(yChar >= '1' && yChar <= '8', "second character is only valid for 1 - 8");
        this.x = xChar - 'a';
        this.y = yChar - '1';
    }

    /**
     * Precondition check for 0 <= {x,y} <=7
     *
     * @param x x co-ordinate
     * @param y y co-ordinate
     */
    public Position(int x, int y) {
        Preconditions.checkArgument(x >= 0 && x <= 7, "x is only valid for 0 <= x<=7");
        Preconditions.checkArgument(y >= 0 && y <= 7, "y is only valid for 0 <= x<=7");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Position &&
                x == ((Position) obj).x &&
                y == ((Position) obj).y;
    }

    @Override
    public String toString() {
        return String.valueOf((char) ('a' + x)) + String.valueOf(y + 1);
    }

    @Override
    public int hashCode() {
        return x * 10 + y;
    }
}
