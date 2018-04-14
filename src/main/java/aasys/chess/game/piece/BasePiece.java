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
import com.google.common.base.Preconditions;

import java.util.Locale;
import java.util.Set;

public abstract class BasePiece {
    private final Player player;
    private final Position position;
    private final ChessBoard chessBoard;
    private final ChessPiece chessPiece;

    public BasePiece(ChessPiece chessPiece, ChessBoard chessBoard, Player player, Position position) {
        Preconditions.checkNotNull(chessPiece);
        Preconditions.checkNotNull(chessBoard);
        Preconditions.checkNotNull(player);
        Preconditions.checkNotNull(position);

        this.chessPiece = chessPiece;
        this.player = player;
        this.position = position;
        this.chessBoard = chessBoard;
    }

    public Player getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

    @Override
    public String toString() {
        return player == Player.BLACK ?
                String.valueOf(chessPiece.getPieceId()) + position.toString() :
                String.valueOf(chessPiece.getPieceId()).toLowerCase(Locale.US) + position.toString();
    }

    public abstract Set<Position> getValidMoves();

}
