package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.enums.PlayDirection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents the KING piece in chess game.
 */
public class King implements ChessPiece{

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getName() {
        return Constants.KING;
    }


    /**
     * This method calculates all possible positions for KING.
     * The KING can move in all directions by one position, within
     * the boundaries of board.
     * @param currentPosition current position of the chess piece
     * @return sorted list of possible positions
     */
    @Override
    public List<ChessBoardPosition> possibleMoves(ChessBoardPosition currentPosition) {
        List<ChessBoardPosition> possiblePositions = new ArrayList<>();

        for(PlayDirection playDirection : PlayDirection.values()) {
            ChessBoardPosition newPosition = new ChessBoardPosition(currentPosition.getRow() + playDirection.getRowStep(), currentPosition.getColumn() + playDirection.getColumnStep());
            if(newPosition.isValid()) {
                possiblePositions.add(newPosition);
            }
        }
        possiblePositions.sort(Comparator.comparing(ChessBoardPosition::toString));
        return possiblePositions;
    }
}
