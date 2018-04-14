/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.base;

import aasys.chess.game.catalog.ChessPiece;
import aasys.chess.game.catalog.Player;
import aasys.chess.game.error.InvalidPosition;
import aasys.chess.game.piece.BasePiece;
import aasys.chess.game.piece.Bishop;
import aasys.chess.game.piece.King;
import aasys.chess.game.piece.Knight;
import aasys.chess.game.piece.Pawn;
import aasys.chess.game.piece.Queen;
import aasys.chess.game.piece.Rook;
import com.google.common.base.Preconditions;

public class PieceFactory {

    public static BasePiece createPiece(ChessBoard board, Player player, ChessPiece chessPiece, Position position) throws InvalidPosition {
        Preconditions.checkNotNull(board);
        Preconditions.checkNotNull(player);
        Preconditions.checkNotNull(chessPiece);
        Preconditions.checkNotNull(position);

        BasePiece piece;
        switch (chessPiece) {
            case KING:
                piece = new King(board, player, position);
                break;
            case QUEEN:
                piece = new Queen(board, player, position);
                break;
            case ROOK:
                piece = new Rook(board, player, position);
                break;
            case BISHOP:
                piece = new Bishop(board, player, position);
                break;
            case KNIGHT:
                piece = new Knight(board, player, position);
                break;
            case PAWN:
            default:
                piece = new Pawn(board, player, position);
                break;
        }
        board.addPiece(piece);
        return piece;
    }


}
