package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Chess App!");

        Scanner scanner = new Scanner(System.in);
        List<String> supportedChessPieces = List.of("PAWN", "KING", "QUEEN");

        System.out.println("Provide your input after >>> in following format: <chess_piece>,<board_position>. Example, \'King,A4\'");
        System.out.println("Type \'exit\' to terminate");

        while(true){
            System.out.print("\ninput >>> ");
            String input = scanner.nextLine();

            if("exit".equalsIgnoreCase(input)) {
                System.out.println("Chess App Terminated!");
                System.exit(0);
            }

            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("No input given.");
            }

            String[] inputParams = input.split(",");
            if (inputParams.length != 2) {
                throw new IllegalArgumentException("Invalid input");
            }

            String chessPiece = inputParams[0];
            String boardPosition = inputParams[1];

            if (chessPiece == null || chessPiece.isEmpty() || !supportedChessPieces.contains(chessPiece.trim().toUpperCase())) {
                throw new IllegalArgumentException("Unsupported chess piece: " + chessPiece);
            }

            if (boardPosition == null || boardPosition.isEmpty() || boardPosition.trim().length() != 2) {
                throw new IllegalArgumentException("Invalid board position");
            }
        }
    }
}