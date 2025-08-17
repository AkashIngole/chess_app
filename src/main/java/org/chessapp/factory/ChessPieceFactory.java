package org.chessapp.factory;

import lombok.extern.slf4j.Slf4j;
import org.chessapp.domain.pieces.ChessPiece;
import org.chessapp.domain.pieces.King;
import org.chessapp.domain.pieces.Pawn;
import org.chessapp.domain.pieces.Queen;

import static org.chessapp.common.Constants.*;

/**
 * This class is responsible for creating instances of ChessPiece.
 */

@Slf4j
public class ChessPieceFactory {

    private ChessPieceFactory() {}

    /**
     * This method creates new instance of ChessPiece based on input piece type.
     * @param pieceType chess piece type
     * @return implementation of ChessPiece
     */
    public static ChessPiece createChessPiece(String pieceType) {
        if(pieceType == null) {
            log.error("Piece type is null");
            throw new IllegalArgumentException("Piece type cannot be null");
        }

        return switch (pieceType.trim().toUpperCase()) {
            case KING -> new King();
            case QUEEN -> new Queen();
            case PAWN -> new Pawn();
            default -> throw new IllegalArgumentException("Piece type not supported");
        };
    }
}
