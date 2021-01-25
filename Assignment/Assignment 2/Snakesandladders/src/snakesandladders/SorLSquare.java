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
public class SorLSquare extends SnLSquare {

    private int endSquare;
/**
 * 
 * @param number inherit from SnLSquare - the number of the square
 * @param endSquare where the player will end up at
 */
    public SorLSquare(int number, int endSquare) {
        super(number);
        if (endSquare == number) {
            throw new IllegalArgumentException("The value end square is equal to your current square");
        }
        this.endSquare = endSquare;
    }
/**
 * Where the player will end move to if it encounter a ladder or snakes 
 * @return endSquare - where the player will end up at
 */
    public int getEndSquare() {
        return this.endSquare;
    }
/**
 * Where the player will end move to if it encounter a ladder or snakes 
 * @return endSquare
 */
    @Override
    public int landOn() {
        return this.endSquare;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + this.endSquare;
    }
/**
 * compare two objects
 * @param o objects that use for comparing
 * @return true if the objects are equals
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
        SorLSquare r = (SorLSquare) o;
        return (super.equals(r)) && (this.endSquare == r.endSquare);
    }
}
