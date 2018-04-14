/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.catalog;

import aasys.chess.game.error.InvalidChessPiece;
import aasys.chess.game.generator.CharGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * junit QuickCheck Testing: Random Testing
 */
@RunWith(JUnitQuickcheck.class)
public class ChessPieceQCTest {

    /**
     * QuickCheck verify that valid id give corresponding ChessPiece
     * While invalid character throw exception
     *
     * @param pieceId character id for ChessPiece
     */
    @Property
    public void obtainChessPieceFromIdTest_generator(@From(CharGenerator.class) Character pieceId) {
        ChessPiece expectedPiece = ChessPieceTest.CHAR_CHESS_PIECE_MAP.get(pieceId);

        ChessPiece actualPiece;

        try {
            actualPiece = ChessPiece.getPieceFromId(pieceId);
        } catch (InvalidChessPiece invalidChessPiece) {
            actualPiece = null;
        }

        assertEquals(actualPiece, expectedPiece);
    }
}
