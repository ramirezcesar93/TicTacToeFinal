
/**
 *
 * @author user
 */
public class TictactoeLogic {
    String [] moves = new String[9];
    public TictactoeLogic(){
        for (int i=0;i<9;i++){
            moves[i]="";
        }
    }
    private final int[][] winCombinations = new int[][]{
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
        {0, 4, 8}, {2, 4, 6} //diagonal wins
    };
    private boolean xwin = false;
    private boolean owin =false;
    private boolean tie=false;

    public void xMove(int pos) {
        moves[pos] = "X";//add to array
    }

    public void oMove(int pos) {
        moves[pos] = "O";//add to array
    }
    /*If 0 index is equal to 1 index
    and 1 index is equal to 2 index then 
    all are equal
    */
    public boolean xWin() {
        for (int i = 0; i <= 7; i++) {
            if ( moves[winCombinations[i][0]].equals(moves[winCombinations[i][1]]) && 
                 moves[winCombinations[i][1]].equals(moves[winCombinations[i][2]])
                 && moves[winCombinations[i][0]].equals("X") &&
                 !"".equals(moves[winCombinations[i][0]])) {
                xwin = true;
                break;
            }
        }
        return xwin;
    }

    public boolean oWin() {
         for (int i = 0; i <= 7; i++) {
            if (moves[winCombinations[i][0]].equals(moves[winCombinations[i][1]]) && 
                 moves[winCombinations[i][1]].equals(moves[winCombinations[i][2]])
                 && moves[winCombinations[i][0]].equals("O") &&
                 !"".equals(moves[winCombinations[i][0]])) {
                owin=true;
                break;
            }
        }
        return owin;  
    }

    public boolean Tie(int turns) {
        if (turns >= 9 && xwin == false && owin==false) {
            tie=true;
        }
        return tie;
    }
}
