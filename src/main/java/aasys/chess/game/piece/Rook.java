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
import aasys.chess.game.move.StraightMover;

import java.util.Set;

public class Rook extends BasePiece {

    public Rook(ChessBoard chessBoard, Player player, Position position) {
        super(ChessPiece.ROOK, chessBoard, player, position);
    }

    public Set<Position> getValidMoves() {
        return StraightMover.getMoves(this);
    }
}
