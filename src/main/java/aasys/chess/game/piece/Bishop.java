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

import java.util.Set;

public class Bishop extends BasePiece {

    public Bishop(ChessBoard chessBoard, Player player, Position position) {
        super(ChessPiece.BISHOP, chessBoard, player, position);
    }

    public Set<Position> getValidMoves() {
        return DiagonalMover.getMoves(this);
    }
}
