package org.chessapp;

import org.chessapp.domain.ChessBoardPosition;
import org.chessapp.domain.MoveRequest;
import org.chessapp.service.InputValidationService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Chess App!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide your input after >>> in following format: <chess_piece>,<board_position>. Example, \'King,A4\'");
        System.out.println("Type \'exit\' to terminate");

        while(true){
            System.out.print("\ninput >>> ");
            String input = scanner.nextLine();

            if("exit".equalsIgnoreCase(input)) {
                System.out.println("Chess App Terminated!");
                System.exit(0);
            }

            MoveRequest moveRequest = InputValidationService.validate(input);

        }
    }
}