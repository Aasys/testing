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
public class KnightTest {
    @Test
    public void knightSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"d7", "f7", "c6", "g6", "c4", "g4", "d3", "f3"};
        knightAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void knightAtEdgeTest_a1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b3", "c2"};
        knightAtPositionTest(0, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void knightAtEdgeTest_a8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"c7", "b6"};
        knightAtPositionTest(0, 7, Arrays.asList(knownMoves));
    }

    @Test
    public void knightAtEdgeTest_h1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g3", "f2"};
        knightAtPositionTest(7, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void knightAtEdgeTest_h8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"f7", "g6"};
        knightAtPositionTest(7, 7, Arrays.asList(knownMoves));
    }

    public void knightAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        Knight knight = (Knight) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.KNIGHT, new Position(x, y));
        Knight knight2 = (Knight) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.KNIGHT, new Position(5, 4));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + knight.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                knight.getValidMoves()) {
            System.out.print("\""+p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);
    }

}
