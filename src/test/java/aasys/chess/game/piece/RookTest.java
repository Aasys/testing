/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.piece;

import aasys.chess.game.base.ChessBoard;
import aasys.chess.game.base.PieceFactory;
import aasys.chess.game.base.Position;
import aasys.chess.game.catalog.ChessPiece;
import aasys.chess.game.catalog.Player;
import aasys.chess.game.error.InvalidChessPiece;
import aasys.chess.game.error.InvalidPosition;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * junit Testing: equivalence partitioning
 */
public class RookTest {
    @Test
    public void rookSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"f5", "d5", "c5", "b5", "a5", "e6", "e7", "e8", "e4", "e3", "e2", "e1"};
        rookAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void rookAtEdgeTest_a1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b1", "c1", "d1", "e1", "f1", "g1", "h1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"};
        rookAtPositionTest(0, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void rookAtEdgeTest_a8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "a6", "a5", "a4", "a3", "a2", "a1"};
        rookAtPositionTest(0, 7, Arrays.asList(knownMoves));
    }

    @Test
    public void rookAtEdgeTest_h1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g1", "f1", "e1", "d1", "c1", "b1", "a1", "h2", "h3", "h4", "h5", "h6", "h7", "h8"};
        rookAtPositionTest(7, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void rookAtEdgeTest_h8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g8", "f8", "e8", "d8", "c8", "b8", "a8", "h7", "h6", "h5", "h4", "h3", "h2", "h1"};
        rookAtPositionTest(7, 7, Arrays.asList(knownMoves));
    }

    public void rookAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        Rook rook = (Rook) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.ROOK, new Position(x, y));
        Rook rook2 = (Rook) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.ROOK, new Position(5, 4));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + rook.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                rook.getValidMoves()) {
            System.out.print("\""+p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);
    }
}
