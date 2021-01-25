/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.util.Scanner;

/**
 * Arushan Sinnadurai SN: 101039300 Flash card game
 */
public class MultiplicationFlashCardApplication {

    public static void main(String[] args) {
        Scanner scannerin = new Scanner(System.in); // take in a input from a user
        MultiplicationFlashCards flashCardsgame; //initialize the game
        System.out.println("Which time tables would like to test?(between 1 and 12"); // ask a number between 1 aND 12
        String temp = scannerin.nextLine(); // READ IN THE NEXT LINE
        String[] a = temp.split(" ");
        if (a.length == 1) {// for the 1-ARG contructors that use the no array
            int b = Integer.parseInt(a[0]); // convert integer to String
            flashCardsgame = new MultiplicationFlashCards(b);//initialize the game
        } else {// for array of interger
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i += 1) { // for the 1-ARG contructors that use the array
                b[i] = Integer.parseInt(a[i]);//convert array of integer to String
            }
            flashCardsgame = new MultiplicationFlashCards(b);//initialize the game
        }

        flashCardsgame.reset(); // reset the game
        String Y_N;

        while (flashCardsgame.hasNext()) {// play the game while it has cards in the arraylist
            flashCardsgame.nextCard();
            System.out.println("Next? (Y or N)");// check the player want to keep playing
            Y_N = scannerin.next();
            if (Y_N.equals("Y")) {// the player want to keep playing then countine 

            } else {
                System.out.println("You've got a score of " + flashCardsgame.getScore() + " so far");//// the player score
                break;
            }

        }

    }
}
