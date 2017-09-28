/**
 * Created by Jamie on 4/19/16.
 */
public class TetrisGUI { // extends ActionListener

    //private Timer;
    //private int keyPressed;
    //private int delay;
    //private Tetronimo livePiece;

    /*
        Constructor
        delay = 1000 // The first level will have the pieces moving down at a rate of 1 per second
        Timer = new Timer( delay, this )
        keyPressed = 0;
        addKeyListener(new TAdapter());
     */


    /*
     * The class that handles the Key Presses
       private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keyPressed = e.getKeyCode(); // get the key pressed

        }
    }
     */

    /*
     * This is the main action listener since it will be the one updating
     * Action Listener for the Timer Object
     * Every Time the timer object is called we will have the tetromino's middle location go down 1 coordinate
     * unless a key was pressed
     */
    /*
        void actionPerformed(ActionEvent evt){
            // Check what to do with the live piece
            if( keyPressed = KeyEvent.VK_LEFT )
                livePiece.goLeft();

            if( keyPressed = KeyEvent.VK_RIGHT )
                livePiece.goRight();

        }
     */


    /*
     * Method for when the game ends.
     * Pop up will show the persons score.
     */
    /*
        public void gameOver(){
            this.showMessageDialogBox(..."you lost"....);
        }
     */

}
