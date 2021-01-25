/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *@author Arushan Sinnadurai
 * Sn:101039300
 */
public class SnLSquare {

    private int number;
/**
 * Default Constructor: create a signal square 
 * @param number the position on the board
 */
    public SnLSquare(int number) {
        this.number = number;
    }

    /**
     * 
     * @return the number of the board
     */
    public int getNumber() {
        return this.number;
    }
    /**
     * 
     *@return the number of which the player land on
     */
    public int landOn() {
        return this.number;
    }
/**
 * 
 * @return a string of a single square 
 */
    public String toString() {
        return "" + this.number;
    }
/**
 * compare two objects
 * @param o object that is being used to compare
 * @return true if both objects are the same
 */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        SnLSquare r = (SnLSquare) o;

        return this.number == r.number;
    }
}
