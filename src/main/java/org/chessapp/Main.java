package org.chessapp;

import lombok.extern.slf4j.Slf4j;
import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.domain.MoveRequest;
import org.chessapp.domain.pieces.ChessPiece;
import org.chessapp.factory.ChessPieceFactory;
import org.chessapp.service.InputValidationService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.chessapp.common.Constants.EXIT;

/**
 * Entry point for Chess App.
 * This class provides a console-based interface for user to input chess piece
 * and board position.
 * Based on the input, this app will calculate all possible valid chess board positions
 * and displays them.
 */
@Slf4j
public class Main {
    public static void main(String[] args) {

        log.info("Welcome to Chess App!");
        log.info("Provide your input after >>> in the following format: <chess_piece>,<board_position>. Example: 'King,A4'");
        log.info("Type 'exit' to terminate");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                log.info("\ninput >>> ");
                String input = scanner.nextLine();

                if (EXIT.equalsIgnoreCase(input)) {
                    log.info("Chess App Terminated!");
                    break; // graceful exit
                }

//                Validate input
                MoveRequest moveRequest = InputValidationService.validate(input);

//                Create ChessPiece and calculate possible positions
                ChessPiece chessPiece = ChessPieceFactory.createChessPiece(moveRequest.getPiece());
                List<ChessBoardPosition> possiblePositions = chessPiece.possibleMoves(moveRequest.getChessBoardPosition());

//                Construct output
                String output = possiblePositions.stream()
                        .map(ChessBoardPosition::toString)
                        .collect(Collectors.joining(", "));

                log.info("Output - {}", output);
            }
        } catch (IllegalArgumentException e) {
            log.warn("Invalid argument provided: {}", e.getMessage());
            log.info("Hint: Use format <chess_piece>,<board_position>. Example: King,A4");
        } catch (Exception e) {
            log.error("Unexpected error occurred: {}", e.getMessage());
        }
    }

}