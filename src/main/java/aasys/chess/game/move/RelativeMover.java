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

public class RelativeMover {

    /**
     * return possible moves for a piece given possible relative positions
     * @param piece
     * @param relativePositions
     * @param size size of relative positions
     * @return set of possible position
     */
    public static Set<Position> getMoves(BasePiece piece, int[][] relativePositions, int size) {
        Preconditions.checkNotNull(piece);

        Set<Position> positionList = new HashSet<Position>();


        for (int i = 0; i < size; i++) {
            Position possiblePosition = null;

            //get absolute position
            int possibleX = piece.getPosition().getX() + relativePositions[i][0];
            int possibleY = piece.getPosition().getY() + relativePositions[i][1];

            if ((possibleX >= 0 && possibleX <= 7) && (possibleY >= 0 && possibleY <= 7)) {
                possiblePosition = new Position(possibleX, possibleY);
            }

            if (possiblePosition != null) {
                //check if piece exist in location
                BasePiece existingPiece = piece.getChessBoard().getPieceAt(possiblePosition);
                if (existingPiece != null) {
                    if (existingPiece.getPlayer() == piece.getPlayer()) {
                        //not valid position if other piece of the player exist
                        continue;
                    }
                }
                positionList.add(possiblePosition);
            }
        }
        return positionList;

    }
}
