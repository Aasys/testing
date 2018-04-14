/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * junit QuickCheck Testing: Random Testing
 */
@RunWith(JUnitQuickcheck.class)
public class PositionQCTest {
    @Property
    public void allRangeTest(@InRange char xBoard, @InRange char yBoard) {
        String positionString = String.valueOf(xBoard) + String.valueOf(yBoard);

        Position position;
        try {
            position = new Position(positionString);
        } catch (IllegalArgumentException e) {
            position = null;
        }

        char xIndex = positionString.charAt(0);
        char yIndex = positionString.charAt(1);
        if ((xIndex >= 'a' && yIndex <= 'h') && (yIndex >= '1' && yIndex <= '8')) {
            assertEquals(position.getX(), xIndex - 'a');
            assertEquals(position.getY(), yIndex - '1');
        } else {
            assertTrue(position == null);
        }
    }


}
