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
public class QueenTest {
    @Test
    public void queenSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"f5", "g5", "h5", "d5", "c5", "b5", "a5", "e6", "e7", "e8", "e4", "e3", "e2", "e1", "f6", "d4", "c3", "b2", "a1", "f4", "g3", "h2", "d6", "c7", "b8"};
        queenAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void queenAtEdgeTest_a1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b1", "c1", "d1", "e1", "f1", "g1", "h1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "b2", "c3", "d4", "e5", "f6"};
        queenAtPositionTest(0, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void queenAtEdgeTest_a8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "a6", "a5", "a4", "a3", "a2", "a1", "b7", "c6", "d5", "e4", "f3", "g2", "h1"};
        queenAtPositionTest(0, 7, Arrays.asList(knownMoves));
    }

    @Test
    public void queenAtEdgeTest_h1() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g1", "f1", "e1", "d1", "c1", "b1", "a1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "g2", "f3", "e4", "d5", "c6", "b7", "a8"};
        queenAtPositionTest(7, 0, Arrays.asList(knownMoves));
    }

    @Test
    public void queenAtEdgeTest_h8() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"g8", "f8", "e8", "d8", "c8", "b8", "a8", "h7", "h6", "h5", "h4", "h3", "h2", "h1", "g7", "f6"};
        queenAtPositionTest(7, 7, Arrays.asList(knownMoves));
    }

    public void queenAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        Queen queen = (Queen) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.QUEEN, new Position(x, y));
        Queen queen2 = (Queen) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.QUEEN, new Position(5, 5));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + queen.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                queen.getValidMoves()) {
            System.out.print("\"" + p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);
    }
}
