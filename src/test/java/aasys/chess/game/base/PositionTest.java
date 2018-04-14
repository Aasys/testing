/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * junit Testing: equivalence partitioning
 */
public class PositionTest {

    @Test
    public void validPositionTest() {
        assertEquals(new Position(0, 0).toString(), "a1");
        assertEquals(new Position(7, 7).toString(), "h8");

        assertEquals(new Position("a1").getX(), 0);
        assertEquals(new Position("h8").getX(), 7);
        assertEquals(new Position("a1").getY(), 0);
        assertEquals(new Position("h8").getY(), 7);

        assertTrue(new Position("e5").equals(new Position(4, 4)));
    }

    @Test
    public void invalidPositionTest() {
        int errorCount = 0;
        try {
            new Position(-1, -1);
        } catch (IllegalArgumentException e) {
            errorCount++;
        }

        try {
            new Position(2, 9);
        } catch (IllegalArgumentException e) {
            errorCount++;
        }


        try {
            new Position(null);
        } catch (NullPointerException e) {
            errorCount++;
        }

        try {
            new Position("a");
        } catch (IllegalArgumentException e) {
            errorCount++;
        }

        try {
            new Position("abcdef");
        } catch (IllegalArgumentException e) {
            errorCount++;
        }


        try {
            new Position("A!");
        } catch (IllegalArgumentException e) {
            errorCount++;
        }


        try {
            new Position("c!");
        } catch (IllegalArgumentException e) {
            errorCount++;
        }

        assertEquals(errorCount, 7);
    }
}
