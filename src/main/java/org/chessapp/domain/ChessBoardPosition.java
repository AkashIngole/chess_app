package org.chessapp.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This class represents position on 8x8 chessboard.
 * Uses 0 based indexing:
 *      column: 0 = A, 7 = H
 *      row: 0 to 7
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ChessBoardPosition {

    private int row;
    private int column;

    private ChessBoardPosition(){}

    public static ChessBoardPosition getChessBoardPosition(String inputPosition) {
        if(inputPosition == null || inputPosition.length() != 2) {
            throw new IllegalArgumentException("Invalid position: " + inputPosition + ". Use format [A-H][1-8]");
        }

        char columnChar = inputPosition.charAt(0);
        char rowChar = inputPosition.charAt(1);

        if(columnChar < 'A' || columnChar > 'H') {
            throw new IllegalArgumentException("Invalid input column: " + columnChar + ". Column must be between A and H.");
        }

        if(rowChar < '1' || rowChar > '8') {
            throw new IllegalArgumentException("Invalid input row: " + rowChar + ". Row value must be between 1 and 8.");
        }

        return new ChessBoardPosition(rowChar - '1', columnChar - 'A');
    }

    @Override
    public String toString() {
        char columnChar = (char) (column + 'A');
        return "" + columnChar + (row + 1);
    }

    public boolean isValid(){
        return (row >= 0 && row < 8) && (column >= 0 && column < 8);
    }
}
