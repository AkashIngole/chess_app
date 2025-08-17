package org.chessapp.service;

import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.domain.MoveRequest;

import java.awt.datatransfer.MimeTypeParseException;
import java.util.List;

public class InputValidationService {

    private static final List<String> SUPPORTED_PIECES = List.of("PAWN", "KING", "QUEEN");

    public static MoveRequest validate(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("No input given.");
        }

        String[] inputParams = input.split(",");
        if (inputParams.length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        String chessPiece = inputParams[0];
        String boardPosition = inputParams[1];

        if (chessPiece == null || chessPiece.isEmpty() || !SUPPORTED_PIECES.contains(chessPiece.trim().toUpperCase())) {
            throw new IllegalArgumentException("Unsupported chess piece: " + chessPiece);
        }

        if (boardPosition == null || boardPosition.isEmpty() || boardPosition.trim().length() != 2) {
            throw new IllegalArgumentException("Invalid board position");
        }

        ChessBoardPosition chessBoardPosition = ChessBoardPosition.getChessBoardPosition(boardPosition);

        return new MoveRequest(chessPiece.toUpperCase(), chessBoardPosition);
    }
}
