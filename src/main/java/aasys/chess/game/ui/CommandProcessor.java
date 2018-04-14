/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.ui;

import aasys.chess.game.base.ChessBoard;
import aasys.chess.game.base.PieceFactory;
import aasys.chess.game.base.Position;
import aasys.chess.game.catalog.ChessPiece;
import aasys.chess.game.catalog.Player;
import aasys.chess.game.error.InvalidChessPiece;
import aasys.chess.game.error.InvalidPosition;
import com.google.common.base.Preconditions;

import java.util.Set;

public class CommandProcessor {
    private final ChessBoard chessBoard = new ChessBoard();

    public String processCommand(String commandStr) throws Exception {
        if (commandStr.trim().startsWith("WHITE:")) {
            commandStr = commandStr.replace("WHITE:", "").trim();
            addPieces(Player.WHITE, commandStr.split(". "));
            System.out.println(chessBoard.toString());
        } else if (commandStr.trim().startsWith("BLACK:")) {
            commandStr = commandStr.replace("BLACK:", "").trim();
            addPieces(Player.BLACK, commandStr.split(". "));
            System.out.println(chessBoard.toString());
        } else if (commandStr.trim().startsWith("PIECE TO MOVE:")) {
            commandStr = commandStr.replace("PIECE TO MOVE:", "").trim();
            return seeMovesForPiece(commandStr);
        } else {
            throw new Exception("Can't process command");
        }
        return "OK";
    }

    private void addPieces(Player player, String[] pieceInfos) throws InvalidChessPiece, InvalidPosition {
        for (String pieceInfo : pieceInfos) {
            Preconditions.checkNotNull(pieceInfo);
            Preconditions.checkArgument(pieceInfo.length()==3);
            ChessPiece chessPiece = ChessPiece.getPieceFromId(pieceInfo.charAt(0));
            Position position = new Position(pieceInfo.substring(1));
            PieceFactory.createPiece(chessBoard, player, chessPiece, position);
        }
    }

    private String seeMovesForPiece(String pieceAddress) throws InvalidPosition, InvalidChessPiece {
        ChessPiece chessPiece = ChessPiece.getPieceFromId(pieceAddress.charAt(0));
        Position position = new Position(pieceAddress.substring(1));

        StringBuilder legalMoves = new StringBuilder("LEGAL MOVES FOR " + pieceAddress + ": ");

        Set<Position> moves = chessBoard.getPieceAt(position).getValidMoves();
        for (Position p : moves) {
            legalMoves.append(p.toString()).append(", ");
        }
        return legalMoves.toString();
    }

}
