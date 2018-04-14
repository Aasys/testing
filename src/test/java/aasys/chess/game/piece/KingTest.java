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
public class KingTest {
    @Test
    public void kingSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"d6", "e6", "f6", "d5", "f5", "d4", "e4", "f4"};
        kingAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void kingAtEdgeTest_a1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"a2", "b2", "b1"};
        kingAtPositionTest(0, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void kingAtEdgeTest_a8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b8", "a7", "b7"};
        kingAtPositionTest(0, 7, Arrays.asList(knownMoves));
    }

    @Test
    public void kingAtEdgeTest_h1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g2", "h2", "g1"};
        kingAtPositionTest(7, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void kingAtEdgeTest_h8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g8", "g7", "h7"};
        kingAtPositionTest(7, 7, Arrays.asList(knownMoves));
    }

    public void kingAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        King king = (King) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.KING, new Position(x, y));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + king.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                king.getValidMoves()) {
            System.out.print(p.toString() + " ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);
    }


}
