/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.catalog;

import aasys.chess.game.error.InvalidChessPiece;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * junit Testing: equivalence partitioning
 */
public class ChessPieceTest {
    public static final Map<Character, ChessPiece> CHAR_CHESS_PIECE_MAP = new HashMap<Character, ChessPiece>();

    static {
        // map of known relations for char to chess piece
        CHAR_CHESS_PIECE_MAP.put('K', ChessPiece.KING);
        CHAR_CHESS_PIECE_MAP.put('Q', ChessPiece.QUEEN);
        CHAR_CHESS_PIECE_MAP.put('B', ChessPiece.BISHOP);
        CHAR_CHESS_PIECE_MAP.put('N', ChessPiece.KNIGHT);
        CHAR_CHESS_PIECE_MAP.put('R', ChessPiece.ROOK);
        CHAR_CHESS_PIECE_MAP.put('P', ChessPiece.PAWN);
    }

    /**
     * verify valid piece ids match corresponding chess piece
     *
     * @throws InvalidChessPiece when invalid input provided
     */
    @Test
    public void validPieceIdToChessPieceTest() throws InvalidChessPiece {
        for (Map.Entry<Character, ChessPiece> pair : CHAR_CHESS_PIECE_MAP.entrySet()) {
            assertEquals(pair.getValue().getPieceId(), (char) pair.getKey());
        }
    }


    /**
     * verify obtaining correct ChessPiece from id
     *
     * @throws InvalidChessPiece when invalid input provided
     */
    @Test
    public void validChessPiecePieceIdTest() throws InvalidChessPiece {
        for (Map.Entry<Character, ChessPiece> pair : CHAR_CHESS_PIECE_MAP.entrySet()) {
            assertEquals(ChessPiece.getPieceFromId(pair.getKey()), pair.getValue());
        }
    }

    /**
     * verify invalid chess piece throws exception
     */
    @Test
    public void invalidPieceIdToChessPieceTest() {
        boolean exception = false;

        try {
            ChessPiece.getPieceFromId('x');
        } catch (InvalidChessPiece invalidChessPiece) {
            exception = true;
        }

        assertTrue(exception);
    }


}
