/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import aasys.chess.game.catalog.Player;
import aasys.chess.game.error.InvalidPosition;
import aasys.chess.game.piece.BasePiece;
import com.google.common.base.Preconditions;

import java.util.Locale;

public class ChessBoard {
    private final BasePiece[][] boardGrid = new BasePiece[8][8];

    public BasePiece getPieceAt(Position position) {
        Preconditions.checkNotNull(position);

        return boardGrid[position.getX()][position.getY()];
    }

    protected void addPiece(BasePiece basePiece) throws InvalidPosition {
        Preconditions.checkNotNull(basePiece);

        BasePiece currentPiece = getPieceAt(basePiece.getPosition());
        if (currentPiece != null) {
            throw new InvalidPosition();
        }
        boardGrid[basePiece.getPosition().getX()][basePiece.getPosition().getY()] = basePiece;
    }

    @Override
    public String toString() {
        BasePiece piece;
        StringBuilder board = new StringBuilder();
        for (int y = 7; y >= 0; y--) {
            board.append(y + 1).append("| ");
            for (int x = 0; x <= 7; x++) {
                piece = boardGrid[x][y];
                if (piece != null) {
                    String pieceId = String.valueOf(piece.getChessPiece().getPieceId());
                    if (piece.getPlayer() == Player.WHITE)
                        pieceId = pieceId.toLowerCase(Locale.US);
                    board.append(pieceId).append(" ");
                } else {
                    board.append("- ");
                }
            }
            board.append("\n");
        }
        board.append("  ________________\n");
        board.append("   a b c d e f g h");
        return board.toString();
    }

}
