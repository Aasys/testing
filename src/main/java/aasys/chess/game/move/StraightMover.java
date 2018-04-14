/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.move;

import aasys.chess.game.base.Position;
import aasys.chess.game.piece.BasePiece;
import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

import static aasys.chess.game.move.DiagonalMover.processPosition;

public class StraightMover {

    /**
     * @param piece piece to move
     * @return list of possible position
     */
    public static Set<Position> getMoves(BasePiece piece) {
        Preconditions.checkNotNull(piece);

        Set<Position> positionList = new HashSet<Position>();


        //positive x
        for (int x = piece.getPosition().getX() + 1; x <= 7; x++) {
            if (processPosition(x, piece.getPosition().getY(), positionList, piece))
                break;
        }

        //negative x
        for (int x = piece.getPosition().getX() - 1; x >= 0; x--) {
            if (processPosition(x, piece.getPosition().getY(), positionList, piece))
                break;
        }

        //positive y
        for (int y = piece.getPosition().getY() + 1; y <= 7; y++) {
            if (processPosition(piece.getPosition().getX(), y, positionList, piece))
                break;
        }

        //negative y
        for (int y = piece.getPosition().getY() - 1; y >= 0; y--) {
            if (processPosition(piece.getPosition().getX(), y, positionList, piece))
                break;
        }

        return positionList;
    }
}