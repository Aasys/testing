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

import java.util.HashSet;
import java.util.Set;

public class Pawn extends BasePiece {

    public Pawn(ChessBoard chessBoard, Player player, Position position) {
        super(ChessPiece.PAWN, chessBoard, player, position);
    }

    public Position testPosition(int x, int y, boolean offensive) {
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
            BasePiece existingPiece = getChessBoard().getPieceAt(possiblePosition);
            if (!offensive && existingPiece != null) {
                // blocked by player's piece
                return null;
            } else if (!offensive && existingPiece == null) {
                // reachable position
                return possiblePosition;
            } else if (offensive && existingPiece != null && existingPiece.getPlayer() != getPlayer()) {
                // diagonal position is opponent piece
                return possiblePosition;
            }
        }
        return null;
    }

    public Set<Position> getValidMoves() {
        Set<Position> positionList = new HashSet<Position>();
        Position possiblePosition = null;
        if (getPlayer() == Player.WHITE) {
            possiblePosition = testPosition(getPosition().getX(), getPosition().getY() + 1, false);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }

            //at initial position try 2 steps
            if (getPosition().getY() == 1 && possiblePosition != null) {
                possiblePosition = testPosition(getPosition().getX(), getPosition().getY() + 2, false);
                if (possiblePosition != null) {
                    positionList.add(possiblePosition);
                }
            }

            //offensive left
            possiblePosition = testPosition(getPosition().getX() - 1, getPosition().getY() + 1, true);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }

            //offensive right
            possiblePosition = testPosition(getPosition().getX() + 1, getPosition().getY() + 1, true);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }
        } else {
            possiblePosition = testPosition(getPosition().getX(), getPosition().getY() - 1, false);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }

            //at initial position try 2 steps
            if (getPosition().getY() == 6 && possiblePosition != null) {
                possiblePosition = testPosition(getPosition().getX(), getPosition().getY() - 2, false);
                if (possiblePosition != null) {
                    positionList.add(possiblePosition);
                }
            }

            //offensive left
            possiblePosition = testPosition(getPosition().getX() - 1, getPosition().getY() - 1, true);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }

            //offensive right
            possiblePosition = testPosition(getPosition().getX() + 1, getPosition().getY() - 1, true);
            if (possiblePosition != null) {
                positionList.add(possiblePosition);
            }
        }
        return positionList;
    }
}
