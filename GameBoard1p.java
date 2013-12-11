
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GameBoard1p extends JFrame implements ActionListener {

    TictactoeLogic logic = new TictactoeLogic();//instantiate logic to use methods
    private JFrame window = new JFrame("1 Player Mode");
    private JButton[] buttons = new JButton[9];
    private int turns = 0;//to determine which letter to put on board
    private String letter = "X";

    // Constructor
    public GameBoard1p() {
        //Add buttons to window
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand("PRESSED_BUTTON_" + i);
            window.add(buttons[i]);
        }
        window.setDefaultCloseOperation(HIDE_ON_CLOSE);
        window.setSize(300, 300);
        window.setLayout(new GridLayout(3, 3));
        window.setLocation(550, 300);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        turns+=2;
        JButton pressedButton = (JButton) a.getSource();//clone button
        pressedButton.setText(letter);//shows letter on board
        pressedButton.setEnabled(false);//disables button
        pressedButton.setBackground(Color.DARK_GRAY);
        //Get array index for button
        String action = a.getActionCommand();
        String prefix = "PRESSED_BUTTON_";
        int buttonIndex;
        if (action.startsWith(prefix)) {
            String buttonNumberAsString = action.substring(prefix.length());//Cut string to get index
            buttonIndex = new Integer(buttonNumberAsString).intValue();
            logic.xMove(buttonIndex);
        }
        int check = 0;
        int comp;
        //Computer move
        while (check == 0) {
            if(turns>8){
                break;
            }
            comp = (int) (Math.random() * (8 - 1)) + 1;//creates number from 1 to 8
            if (buttons[comp].isEnabled() == true) {
                buttons[comp].setText("O");
                buttons[comp].setEnabled(false);
                buttons[comp].setBackground(Color.BLUE);
                check = 1;
            }
            
        }
        if (logic.xWin()) {
            JOptionPane.showMessageDialog(null, "X won the game");
            window.setVisible(false);
        }
        if (logic.oWin()) {
            JOptionPane.showMessageDialog(null, "O won the game");
            window.setVisible(false);
        }
        if (logic.Tie(turns)) {
            JOptionPane.showMessageDialog(null, "The game was a Tie");
            window.setVisible(false);
        }

    }
}
