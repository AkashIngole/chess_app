package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.enums.PlayDirection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents the QUEEN piece in chess game.
 */
public class Queen implements ChessPiece{

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getName() {
        return Constants.QUEEN;
    }

    /**
     * This method calculates all possible positions for QUEEN.
     * The QUEEN can move in all directions, within
     * the boundaries of board.
     * @param currentPosition current position of the chess piece
     * @return sorted list of possible positions
     */
    @Override
    public List<ChessBoardPosition> possibleMoves(ChessBoardPosition currentPosition) {
        List<ChessBoardPosition> possiblePositions = new ArrayList<>();

        for(PlayDirection playDirection : PlayDirection.values()) {
            int rowIndex = currentPosition.getRow();
            int columnIndex = currentPosition.getColumn();

            while(true) {
                rowIndex += playDirection.getRowStep();
                columnIndex += playDirection.getColumnStep();
                ChessBoardPosition newPosition = new ChessBoardPosition(rowIndex, columnIndex);
                if (newPosition.isValid()) {
                    possiblePositions.add(newPosition);
                } else {
                    break;
                }
            }
        }
        possiblePositions.sort(Comparator.comparing(ChessBoardPosition::toString));
        return possiblePositions;
    }
}
