/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Arushan Sinnadurai SN: 101039300 Flash card game
 */
public abstract class AbstractFlashCards {

    private HashMap<String, String> flashCards;
    private ArrayList<String> unansweredCards;
    private int score;
    private Random random;
    private Scanner scanner;

    /**
     * Default Constructor used to initialize the HashMap, ArrayList, score,
     * random, scanner; the HashMap and ArrayList are used to store the question
     * score increase when you answer the question right
     */
    public AbstractFlashCards() {
        flashCards = new HashMap();
        unansweredCards = new ArrayList();
        score = 0;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    /**
     *
     * @param question The question come from the LanguageFlashCards or
     * MultiplicationFlashCards
     * @param answer The answer come from the LanguageFlashCards or
     * MultiplicationFlashCards
     */
    protected void addCard(String question, String answer) 
    {
        flashCards.put(question, answer); // get the question and answers from LanguageFlashCards or MultiplicationFlashCards
    }

    /**
     * remove everything in the unansweredCards then randomize order add back to
     * unansweredCards reset score back to zero
     */
    public void reset() {
        unansweredCards.clear(); // remove everything in the unansweredCards
        String temp[] = new String[flashCards.size()];// temporary storage 
        temp = flashCards.keySet().toArray(new String[flashCards.keySet().size()]); // get all the keys from the hashmap and put in this array

        for (int i = 0; i < flashCards.size(); i++) {
            int index = random.nextInt(flashCards.size()); // random a number between 0 to max limit which is the flashcards size
            if (unansweredCards.contains(temp[index]) == false) { // check if the unansweredCards has that value go back and rerandomize
                unansweredCards.add(temp[index]); // add that question in an randomize order
            } else {
                i--;
            }

        }
        //unansweredCards = new ArrayList<>(Arrays.asList(temp)); // cant used
        //Collections.shuffle(unansweredCards); // cant use
        score = 0;//resetting score
    }

    /**
     * Check if there any card are in the your array
     *
     * @return false if there is any cards in the arraylist
     * @return true if no cards in the arraylist
     */
    public boolean hasNext() 
    {
        if (unansweredCards.isEmpty() == true) { // check if there is any cards in the arraylist
            return false;
        }
        return true;
    }

    /**
     * Outputs the question Check if the user is correct or incorrect modify the
     * ArrayList depending the the answer output the score
     *
     * @return
     */
    public boolean nextCard() {
        System.out.println(Arrays.toString(unansweredCards.toArray())); // output the arraylist with the question
        System.out.println(unansweredCards.get(0));// output the question
        String answers = scanner.next(); // read in the user input 
        //String key = random.next(unansweredCards.size());
        if (unansweredCards.isEmpty() == false) { //check if the arraylist empty - no point of checking if empty

            if (flashCards.get(unansweredCards.get(0)).equals(answers)) {// check if the user answer is correct 
                unansweredCards.remove(0); // removes the question
                score = score + 1; // increase your score
                System.out.println("Correct"); // output if that user is correct
                System.out.println("Score = " + score);// output the score
                return hasNext(); // check if there is more cards
            } else {
                String position = unansweredCards.remove(0); // if the answer is wrong - put back the question in a random spot
                int indexofkey = random.nextInt(unansweredCards.size()) + 1; //between max to 1
                unansweredCards.add(indexofkey, position); //put back the question
                System.out.println("Sorry, please try again");//output if that user is incorrect
                System.out.println("Score = " + score);// output the score
                return hasNext();//check if there is more cards
            }
        }

        return false;
    }

    /**
     * @return score - the amount of question you got right
     */
    public int getScore() {
        return this.score;
    }

}
