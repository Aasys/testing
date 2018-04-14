/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.piece;

import aasys.chess.game.base.ChessBoard;
import aasys.chess.game.base.Position;
import aasys.chess.game.catalog.ChessPiece;
import aasys.chess.game.catalog.Player;
import aasys.chess.game.move.DiagonalMover;
import aasys.chess.game.move.StraightMover;

import java.util.Set;

public class Queen extends BasePiece {

    public Queen(ChessBoard chessBoard, Player player, Position position) {
        super(ChessPiece.QUEEN, chessBoard, player, position);
    }

    public Set<Position> getValidMoves() {
        Set<Position> validPostions = DiagonalMover.getMoves(this);
        validPostions.addAll(StraightMover.getMoves(this));
        return validPostions;
    }
}
