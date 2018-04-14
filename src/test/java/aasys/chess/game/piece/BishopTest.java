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
public class BishopTest {
    @Test
    public void bishopSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"f6", "d4", "c3", "b2", "a1", "f4", "g3", "h2", "d6", "c7", "b8"};
        bishopAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void bishopAtEdgeTest_a1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b2", "c3", "d4", "e5", "f6"};
        bishopAtPositionTest(0, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void bishopAtEdgeTest_a8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b7", "c6", "d5", "e4", "f3", "g2", "h1"};
        bishopAtPositionTest(0, 7, Arrays.asList(knownMoves));
    }

    @Test
    public void bishopAtEdgeTest_h1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g2", "f3", "e4", "d5", "c6", "b7", "a8"};
        bishopAtPositionTest(7, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void bishopAtEdgeTest_h8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g7", "f6"};
        bishopAtPositionTest(7, 7, Arrays.asList(knownMoves));
    }

    public void bishopAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        Bishop bishop = (Bishop) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.BISHOP, new Position(x, y));
        Bishop bishop2 = (Bishop) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.BISHOP, new Position(5, 5));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + bishop.toString() + ": ");

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                bishop.getValidMoves()) {
            System.out.print("\""+p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);
    }
}
