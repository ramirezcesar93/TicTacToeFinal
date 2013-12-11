/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class gameCreator1p implements Runnable{
    @Override
    public void run(){
        //Executor will execute these in multiple threads depending on the number of games
        GameBoard1p game = new GameBoard1p();
    }
    
}
