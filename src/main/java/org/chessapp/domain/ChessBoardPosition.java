package org.chessapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
        char columnChar = (char) (column - 1 + 'A');
        return "" + columnChar + row;
    }

    public boolean isValid(){
        return (row >= 1 && row < 8) && (column >= 1 && column < 8);
    }
}
