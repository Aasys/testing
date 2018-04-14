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

public class DiagonalMover {

    /**
     * @param piece piece to move
     * @return list of possible position
     */
    public static Set<Position> getMoves(BasePiece piece) {
        Preconditions.checkNotNull(piece);

        Set<Position> positionList = new HashSet<Position>();

        // + x, + y
        int x = piece.getPosition().getX() + 1;
        int y = piece.getPosition().getY() + 1;
        while ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
            if (processPosition(x, y, positionList, piece))
                break;
            x++;
            y++;
        }

        // - x, - y
        x = piece.getPosition().getX() - 1;
        y = piece.getPosition().getY() - 1;
        while ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
            if (processPosition(x, y, positionList, piece))
                break;
            x--;
            y--;
        }


        // + x, -y
        x = piece.getPosition().getX() + 1;
        y = piece.getPosition().getY() - 1;
        while ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
            if (processPosition(x, y, positionList, piece))
                break;
            x++;
            y--;
        }

        // - x, +y
        x = piece.getPosition().getX() - 1;
        y = piece.getPosition().getY() + 1;
        while ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
            if (processPosition(x, y, positionList, piece))
                break;
            x--;
            y++;
        }

        return positionList;
    }

    /**
     * check if x, y is reachable and add reachable position to positionList
     *
     * @param x            x co-ordinate
     * @param y            y co-ordinate
     * @param positionList store for positions
     * @param piece        piece to be moved
     * @return true if path is obstructed
     */
    public static boolean processPosition(int x, int y, Set<Position> positionList, BasePiece piece) {
        Preconditions.checkNotNull(positionList);
        Preconditions.checkNotNull(piece);

        Position possiblePosition = testPosition(x, y, piece);
        if (possiblePosition != null) {
            positionList.add(possiblePosition);
        }
        if (x >= 0 && x <= 7 && y > 0 && y < 7) {
            BasePiece existingPiece = piece.getChessBoard().getPieceAt(new Position(x, y));
            return existingPiece != null;
        }
        return false;
    }

    /**
     * Check if the given co-ordinates are reachable
     *
     * @param x     x co-ordinate
     * @param y     y co-ordinate
     * @param piece piece to be moved
     * @return corresponding Position if co-ordinates are reachable
     */
    public static Position testPosition(int x, int y, BasePiece piece) {
        Preconditions.checkNotNull(piece);

        Position possiblePosition;
        try {
            //get absolute position
            possiblePosition = new Position(x, y);
        } catch (IllegalArgumentException e) {
            //resulting absolute position not valid
            possiblePosition = null;
        }
        if (possiblePosition != null) {
            //check if piece exist in location
            BasePiece existingPiece = piece.getChessBoard().getPieceAt(possiblePosition);
            if (existingPiece != null && existingPiece.getPlayer() == piece.getPlayer()) {
                //not valid position if other piece of the player exist
                return null;
            }
            return possiblePosition;
        }
        return null;
    }
}
