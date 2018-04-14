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
import aasys.chess.game.error.InvalidPosition;
import aasys.chess.game.move.StraightMover;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

/**
 * junit QuickCheck Testing: Random Testing
 */
@RunWith(JUnitQuickcheck.class)
public class RookQCTest {
    @Property
    public void allRangeTest(@InRange(minChar = 'a', maxChar = 'h') char xBoard,
                             @InRange(minChar = '1', maxChar = '8') char yBoard,
                             @InRange int isWhitePlayer) throws InvalidPosition {
        String positionString = String.valueOf(xBoard) + String.valueOf(yBoard);
        ChessBoard chessBoard = new ChessBoard();

        Player player = isWhitePlayer % 2 == 0 ? Player.WHITE : Player.BLACK;

        BasePiece piece = PieceFactory.createPiece(chessBoard, player, ChessPiece.ROOK, new Position(positionString));

        assert StraightMover.getMoves(piece).containsAll(piece.getValidMoves());
    }


}

