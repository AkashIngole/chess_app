package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.enums.PlayDirection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents the PAWN piece in chess game.
 */
public class Pawn implements ChessPiece{

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getName() {
        return Constants.PAWN;
    }

    /**
     * This method calculates all possible positions for PAWN.
     * The PAWN can move forward by one position only, within
     * the boundaries of board.
     * @param currentPosition current position of the chess piece
     * @return sorted list of possible positions
     */
    @Override
    public List<ChessBoardPosition> possibleMoves(ChessBoardPosition currentPosition) {
        List<ChessBoardPosition> possiblePositions = new ArrayList<>();

        int rowIndex = currentPosition.getRow() + PlayDirection.UP.getRowStep();
        int columnIndex = currentPosition.getColumn() + PlayDirection.UP.getColumnStep();

        ChessBoardPosition newPosition = new ChessBoardPosition(rowIndex, columnIndex);
        if (newPosition.isValid()) {
            possiblePositions.add(newPosition);
        }

        possiblePositions.sort(Comparator.comparing(ChessBoardPosition::toString));
        return possiblePositions;
    }
}
