import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

/**
 *
 * @author user
 */
public class ReplayButton extends JFrame implements ActionListener{
    JFrame window = new JFrame("Play");
    JButton array[] = new JButton[1];
    
    public ReplayButton(){
        window.setLayout(new GridLayout(1,1));
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(200, 150);
        window.setLocation(580, 30);
        array[0]= new JButton();
        array[0].setText("Start Game");
        array[0].addActionListener(this);
        window.add(array[0]);
        window.setVisible(true);
    }
    private int count=1;
    @Override
    public void actionPerformed(ActionEvent e){
        if(count>0){
            array[0].setText("Replay");
        }
        array[0].setBackground(Color.CYAN);
        this.playGame();
        count++;
    }
    public void playGame(){
        int option;//game mode option chosen
        int gamesNum;
        int flip;
        String guess;
        int guessNum=0;//heads or tails
        ArrayList<Gamecreator2p> games = new ArrayList<Gamecreator2p>();
        ArrayList<gameCreator1p> games1p = new ArrayList<gameCreator1p>();
        ExecutorService threadExecutor = Executors.newCachedThreadPool();//initialize thread executor
        Object options[] = {"2 Player", "1 Player vs COM"};//game mode menu
       
        //Start of game
        JOptionPane.showMessageDialog(null, "   Welcome to TicTacToe! \nConnect three in a row to win!");
        JOptionPane.showMessageDialog(null,"Press the red X on the play button or the main window to exit the game \n WARNING: DONT PRESS REPLAY TILL YOU FINISH ALL GAMES");
        option = JOptionPane.showOptionDialog(null, "Which game mode are you gonna play?", "Choose Game Mode", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        gamesNum = Integer.parseInt(JOptionPane.showInputDialog("How many games do you want to play?"));
        if (option == 0) {
            guess = JOptionPane.showInputDialog("Lets flip a coin to see who goes first, have one player choose heads or tails?");
            guess.toLowerCase();
            
            if(guess.startsWith("h")){
                guessNum=1;
            }
            else if (guess.equals("t")){
                guessNum=2;
            }
            flip = 1 + (int)(Math.random()*2);
            if (guessNum==flip){
                JOptionPane.showMessageDialog(null, "You guessed it right! You will be X and you will go first");
            }
            else{
                JOptionPane.showMessageDialog(null, "Nope you guessed wrong! You will be O and you will go second");
            }
            //Instantiate object and store in array
            for (int i = 0; i < gamesNum; i++) {
                games.add(new Gamecreator2p());
            }
            //execute objects from array in different threads
            for (int i = 0; i < gamesNum; i++) {
                threadExecutor.execute(games.get(i));
            }
        }
        
        //execute threads for single player game
        if (option==1){
            JOptionPane.showMessageDialog(null, "You will be X and you will go first");
            for (int i = 0; i < gamesNum; i++) {
                games1p.add(new gameCreator1p());//add objects to array
            }
            for (int i = 0; i < gamesNum; i++) {
                threadExecutor.execute(games1p.get(i));//execute objects
            }
        }
    }
}

