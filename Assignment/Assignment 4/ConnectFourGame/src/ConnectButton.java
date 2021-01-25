
import javafx.scene.control.Button;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arushan Sinnaduurai SN:101039300
 */
public class ConnectButton extends Button {

    private int row;
    private int column;

    /**
     * This class get the rows,columns and the labels from the grid
     *
     * @param label the labels of the button
     * @param row of the grid
     * @param column of the grid
     */
    public ConnectButton(String label, int row, int column) {
        super(label);
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the rows of the button from the grid
     *
     * @return The rows
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the columns of the button from the grid
     *
     * @return The rows
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * This methods prints the rows and columns of the button
     *
     * @return The string that inform you about the location of the button
     */
    @Override
    public String toString() {
        //super.toString()
        return "(" + row + "," + column + ")";
    }
}
