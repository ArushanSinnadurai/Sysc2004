/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.io.IOException;
import java.util.Scanner;

/**
 * Arushan Sinnadurai SN: 101039300 Flash card game
 */
public class LanguageFlashCardApplication {

    public static void main(String[] args) throws IOException {
        Scanner scannerin = new Scanner(System.in);// take in a input from a user
        System.out.println("What is the filename contaning your flashcards? Exact letters!"); //ask for the file name
        LanguageFlashCards flashCardsgame = new LanguageFlashCards(scannerin.next()); //initialize the game
        flashCardsgame.reset(); // reset the game
        String Y_N;

        while (flashCardsgame.hasNext()) { // play the game while it has cards in the arraylist
            flashCardsgame.nextCard();
            System.out.println("Next? (Y or N)"); // check the player want to keep playing
            Y_N = scannerin.next(); //read in the value
            if (Y_N.equals("Y")) { // the player want to keep playing then countine 

            } else { // if not output the player total score and break out of the while loop
                System.out.println("You've got a score of " + flashCardsgame.getScore() + " so far"); // the player score
                break;
            }

        }

    }
}
