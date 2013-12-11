
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author user
 */
public class playgame extends JFrame{
    ///this is the main GUI
    private JFrame window = new JFrame("TicTacToe Game");
    JPanel main = new JPanel();
    //Constructor
    public playgame(){
        main.setBackground(Color.DARK_GRAY);
        window.setExtendedState(MAXIMIZED_BOTH);
        window.setContentPane(main);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ReplayButton button = new ReplayButton();
    }
}
