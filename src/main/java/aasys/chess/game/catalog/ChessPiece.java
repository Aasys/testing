/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.catalog;

import aasys.chess.game.error.InvalidChessPiece;

import java.util.EnumSet;

public enum ChessPiece {
    KING('K'),
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KNIGHT('N'),
    PAWN('P');

    private char pieceId;

    ChessPiece(char pieceId) {
        this.pieceId = pieceId;
    }

    public char getPieceId() {
        return pieceId;
    }

    public static ChessPiece getPieceFromId(char pieceId) throws InvalidChessPiece {
        for (ChessPiece p : EnumSet.allOf(ChessPiece.class)) {
            if (pieceId == p.pieceId)
                return p;
        }
        throw new InvalidChessPiece();
    }
}
