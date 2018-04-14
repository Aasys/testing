/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import aasys.chess.game.catalog.ChessPiece;
import aasys.chess.game.catalog.Player;
import aasys.chess.game.error.InvalidPosition;
import aasys.chess.game.piece.Bishop;
import aasys.chess.game.piece.King;
import aasys.chess.game.piece.Knight;
import aasys.chess.game.piece.Pawn;
import aasys.chess.game.piece.Queen;
import aasys.chess.game.piece.Rook;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PieceFactoryTest {
    @Test
    public void validChessPieceTest() throws InvalidPosition {
        ChessBoard chessBoard = new ChessBoard();
        assertTrue(PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.BISHOP, new Position("a2")) instanceof Bishop);
        assertTrue(PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.KING, new Position("b3")) instanceof King);
        assertTrue(PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.ROOK, new Position("e4")) instanceof Rook);
        assertTrue(PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.KNIGHT, new Position("h2")) instanceof Knight);
        assertTrue(PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.PAWN, new Position("f3")) instanceof Pawn);
        assertTrue(PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.QUEEN, new Position("a3")) instanceof Queen);
    }
}
