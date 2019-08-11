package com.challenge364;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner console = new Scanner(System.in);
        System.out.println("This program rolls dice. Type your roll as #d# and press enter. Enter 'exit' to quit.");
        while(true) {
            String rawInput = console.nextLine();
            if ((rawInput.toLowerCase().contains("exit")) || (rawInput.toLowerCase().contains("quit"))) {
                break;
            }
            if (rawInput.toLowerCase().contains("help")) {
                System.out.println("This program rolls dice. Type your roll as #d# and press enter. Enter 'exit' to quit.");
                continue;
            }
            try {
                System.out.println(diceRoller(rawInput));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again");
            }

        }
    }
    public static int diceRoller(String diceInput) {
        final Pattern pattern = Pattern.compile("[0-9]+d[0-9]+");
        if (!pattern.matcher(diceInput).matches()) {
            throw new IllegalArgumentException("Invalid input");
        }

        String[] input = diceInput.split("d");
        int numDice = Integer.parseInt(input[0]);
        int diceSides = Integer.parseInt(input[1]);
        int result = 0;
        for (int i = 0; i < numDice; i++) {
            result += Math.random() * diceSides + 1;
        }
        return result;
    }
}
