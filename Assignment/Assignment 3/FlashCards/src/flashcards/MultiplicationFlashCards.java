/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

/**
 * Arushan Sinnadurai SN: 101039300 Flash card game
 */
public class MultiplicationFlashCards extends AbstractFlashCards {

    /**
     * The purpose of this constructor to take in a input which is the
     * multiplier and multiply from 1-12
     *
     * @param multiplier a value you want to multiply buy
     */
    public MultiplicationFlashCards(int multiplier) {
        String keys;
        String values;
        int temp = 0;
        for (int i = 1; i <= 12; i++) { // goes from 1 - 12 and multiply by multiplier
            temp = (multiplier * i);
            keys = multiplier + " * " + i;
            values = "" + temp;
            addCard(keys, values);
        }
    }

    /**
     *
     * The purpose of this constructor is to take in a array of integer which is
     * used multiply each element by 1 to 12
     *
     * @param multiplier a array you want to multiply buy
     */
    public MultiplicationFlashCards(int multipliers[]) {
        String keys;
        String values;
        int temp = 0;

        for (int i = 0; i < multipliers.length; i++) {// goes the element of the array
            for (int j = 1; j <= 12; j++) {// multiple the element by 1 to 12
                temp = multipliers[i] * j;
                keys = multipliers[i] + " * " + j;
                values = "" + temp;
                addCard(keys, values);
            }
        }

    }
}
