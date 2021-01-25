
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *  * @author Arushan Sinnaduurai SN:101039300
 */
public class ConnectfourTestClient {

    public static void main(String args[]) {
        Random random = new Random();
        boolean x = random.nextBoolean();
        ConnectFourEnum colour;

        if (x == true) {

            colour = ConnectFourEnum.BLACK;
        } else {
            colour = ConnectFourEnum.RED;
        }

        ConnectFourGame game = new ConnectFourGame(colour);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(game.toString());
            System.out.println(game.getTurn() + ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);

        } while (game.getGameState() == ConnectFourEnum.IN_PROGRESS);
        System.out.println(game.toString());
        System.out.println(game.getGameState());

    }
}
