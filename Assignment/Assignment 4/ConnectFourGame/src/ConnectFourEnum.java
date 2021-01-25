
/**
 *
 * @author Arushan Sinnaduurai
 * SN:101039300
 */
public enum ConnectFourEnum {
    IN_PROGRESS("Game in Progress"), RED("Red"), BLACK("Black"), DRAW("It's a draw!"), EMPTY(" ");

    static ConnectButton valueOf(ConnectFourEnum colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String value;

    ConnectFourEnum(String value) {
        this.value = value;
    }
}
