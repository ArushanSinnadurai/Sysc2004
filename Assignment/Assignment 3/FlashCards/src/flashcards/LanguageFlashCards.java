/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Arushan Sinnadurai SN: 101039300 Flash card game
 */
public class LanguageFlashCards extends AbstractFlashCards {

    private static String COMMA_DELIMITER = ",";
    private String filename;

    /**
     * The purpose of this class is to read a file and sent the answer and the
     * question to the hashmap
     *
     * @param filename input a file from the users
     * @throws IOException throw a exception whenever an input or output fails
     */
    public LanguageFlashCards(String filename) throws IOException {
        FileReader istream = null; // initialize a filereader
        BufferedReader reader = null; // initialize a bufferedreader
        this.filename = filename; // the file name
        String line, key, value; // keys and values are used for the hashmaps

        try {
            istream = new FileReader(filename); // opens the file and read that file
            reader = new BufferedReader(istream);//eads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, lines and arrays
            line = reader.readLine(); // read the next line which include English and French
            //line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String columnHeadings[] = line.split(COMMA_DELIMITER); // split the file input with a comma
                key = columnHeadings[0];// first element is the keys
                value = columnHeadings[1];// the second is the values
                addCard(key, value); // add to the hashmap

            }
        } catch (FileNotFoundException e1) { // throw exception if file is not found
            System.out.print("File not found");
        } finally { // close the file
            reader.close();
        }
    }
}
