/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *  * @author Arushan Sinnaduurai
 * SN:101039300
 */
public class ConnectMove {

    private int row;
    private int column;
    private ConnectFourEnum colour;

    /**
     * This class is used for the observer as it get rows and columns as well
     * the player colour
     *
     * @param row the rows of the button
     * @param column the columns of the button
     * @param colour The colour of the player
     */
    public ConnectMove(int row, int column, ConnectFourEnum colour) {
        this.row = row;
        this.column = column;
        this.colour = colour;
    }

    /**
     * this gets row of the button
     *
     * @return row of the button
     */
    public int getRow() {
        return this.row;
    }

    /**
     * this gets columns of the button
     *
     * @return columns of the button
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * this return the player's colour
     *
     * @return The player's colour
     */
    public ConnectFourEnum getColour() {
        return this.colour;
    }
}
