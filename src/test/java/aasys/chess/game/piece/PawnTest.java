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
public class PawnTest {
    @Test
    public void pawnSimpleMovesTest() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"e4", "f4"};
        pawnAtPositionTest(4, 4, Arrays.asList(knownMoves));
    }

    @Test
    public void pawnAtEdgeTest_a2() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"a1"};
        pawnAtPositionTest(0, 1, Arrays.asList(knownMoves));
    }

    @Test
    public void pawnAtEdgeTest_a7() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"a6", "a5"};
        pawnAtPositionTest(0, 6, Arrays.asList(knownMoves));
    }

    @Test
    public void pawnAtEdgeTest_h2() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"h1"};
        pawnAtPositionTest(7, 1, Arrays.asList(knownMoves));
    }

    @Test
    public void pawnAtEdgeTest_h7() throws InvalidPosition, InvalidChessPiece {
        String[] knownMoves = new String[]{"h6", "h5"};
        pawnAtPositionTest(7, 6, Arrays.asList(knownMoves));
    }

    public void pawnAtPositionTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        pawnAtPositionFlipTest(x, y, knownMoves);
        ChessBoard chessBoard = new ChessBoard();
        Pawn pawn = (Pawn) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.PAWN, new Position(x, y));
        Pawn pawn2 = (Pawn) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.PAWN, new Position(5, 3));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + pawn.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                pawn.getValidMoves()) {
            System.out.print("\"" + p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
        assert determinedMoves.containsAll(knownMoves);

    }

    public void pawnAtPositionFlipTest(int x, int y, List<String> knownMoves) throws InvalidPosition, InvalidChessPiece {
        ChessBoard chessBoard = new ChessBoard();
        Pawn pawn = (Pawn) PieceFactory.createPiece(chessBoard, Player.WHITE, ChessPiece.PAWN, new Position(x, y));
        Pawn pawn2 = (Pawn) PieceFactory.createPiece(chessBoard, Player.BLACK, ChessPiece.PAWN, new Position(5, 3));
        System.out.println(chessBoard.toString());
        System.out.print("Valid moves for " + pawn.toString());

        Set<String> determinedMoves = new HashSet<String>();
        for (Position p :
                pawn.getValidMoves()) {
            System.out.print("\"" + p.toString() + "\", ");
            determinedMoves.add(p.toString());
        }
        System.out.println();
        System.out.println();
    }
}
