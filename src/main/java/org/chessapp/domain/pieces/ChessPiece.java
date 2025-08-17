package org.chessapp.domain.pieces;

import org.chessapp.domain.ChessBoardPosition;

import java.util.List;

/**
 * This interface represents generic chess piece.
 * The implementing class should provide piece movement strategy.
 */
public interface ChessPiece {

    /**
     * Returns the name of chess piece.
     * @return the name of chess piece (KING, QUEEN, PAWN)
     */
    String getName();

    /**
     * Calculates all possible positions based on current position.
     * @param currentPosition current position of the chess piece
     * @return list of all possible positions.
     */
    List<ChessBoardPosition> possibleMoves(ChessBoardPosition currentPosition);
}
