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
import aasys.chess.game.move.RelativeMover;

import java.util.Set;

public class Knight extends BasePiece {
    private static final int[][] POSSIBLE_MOVES = {
            //relative positions from 0, 0
            {-1, 2}, {1, 2},
            {-2, 1}, {2, 1},
            {-2, -1}, {2, -1},
            {-1, -2}, {1, -2}
    };

    public Knight(ChessBoard chessBoard, Player player, Position position) {
        super(ChessPiece.KNIGHT, chessBoard, player, position);
    }

    public Set<Position> getValidMoves() {
        return RelativeMover.getMoves(this, POSSIBLE_MOVES, 8);
    }
}
