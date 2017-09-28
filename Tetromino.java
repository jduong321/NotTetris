
/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 *This is the parent class of all the Tetrominos.
 * It holds all the methods needed by all Tetrominos.
 * The only difference between Tetromino's are the rotation orientations.
 * */

public class Tetromino {
    protected int[] centerPiece;
    protected int[][] rotation0;
    protected int[][] rotation1;
    protected int[][] rotation2;
    protected int[][] rotation3;
    protected int orientation;
    protected Grid playGrid;

    /*
     * Constructor for a Tetrimino that will initialize every different
     * rotation differences.
     */
    public Tetromino(){
        // Never Used
        playGrid = Grid.getInstance();
    }

    /*
     * @return returns if this piece can be added to the grid
     */
    public boolean isValidAddition(){
        return isValidMove(0);
    }

    /*
    * @return returns if this piece can move left
    */
    public boolean isValidLeft(){
        return isValidMove(1);
    }

    /*
    * @return returns if this piece can move right
    */
    public boolean isValidRight(){
        return isValidMove(2);
    }

    /*
    * @return returns if this piece can move down
    */
    public boolean isValidDown(){
        return isValidMove(3);
    }

    /*
    * @return returns if this piece can be rotated
    */
    public boolean isValidRotation(){
        return isValidMove(4);
    }

    // These Methods below should only be used once we have checked if they are valid

    /*
     * Actually moves the piece to the left
     */
    public void goLeft(){
        if( centerPiece[0] - 1 < 0 ) {
            System.out.println("Trying to go Left, out of bounds");
            return;
        }

        centerPiece[0]--;
    }

    /*
     * Actually moves the piece to the right
     */
    public void goRight(){
        if( centerPiece[0] + 1 >= playGrid.getWidth() ) {
            System.out.println("Trying to go Right, out of bounds");
            return;
        }
        centerPiece[0]++;
    }

    /*
     * Actually moves the piece down
     */
    public void goDown(){
        if( centerPiece[1] + 1 >= playGrid.getLength() ) {
            System.out.println("Trying to go Down, out of bounds");
            return;
        }
        centerPiece[1]++;
    }

    /*
     * Actually rotates the piece
     */
    public void goRotate(){
        orientation =  (orientation + 1) % 4;
    }

    /*
     * This is the helper method for all the Valid moves
     *
     * @param the type of move:
     * 0 - adding the piece to the grid
     * 1 - going left
     * 2 - going right
     * 3 - going down
     * 4 - rotating
     *
     * @return returns if the Tetromino can move that way
     */
    private boolean isValidMove(int m){
        int[][] current = getCoordinates(0);
        boolean coordinateIsValid;

        if( m == 0 ){ // Checking to see if we can add the Tetromino to the Grid
            for( int i = 1; i < 4 ; i++ ){
                coordinateIsValid = playGrid.isValid(current[i][0],current[i][1]);
                if ( !coordinateIsValid ) // if the coordinate is not valid
                    return false;
            }
            return true;
        }

        // Checking to see if the Tetromino is able to do the move: Left, Right, Down, Rotate
        int[][] next = getCoordinates(m);
        boolean partOfSelf;
        for( int i = 0; i < 4 ; i++ ){
            // If the move will cause the Tetromino to go over itself, then that is fine
            // But we also have to check if it will over lap with anything else or go out of bounds
            partOfSelf = isPartOfSelf(current, next[i]);
            if ( !partOfSelf && !playGrid.isValid(next[i][0],next[i][1])) {
                return false;
            }
        }

        return true;
    }

    /*
     * Helper method for isValidMove
     * We use this method because we have to check if the piece we are going to overlap is ourself.
     * If the piece is going to go over itself then it is fine.
     *
     * @param current the int array that hold the coordinates of this piece's current coordinates
     * @param next    the int array that holds the x and y values of the piece we are trying to check
     *                is part of itself
     *
     * @return true, if we found that the next coordinate is part of our current coordinates
     *         false, if not
     */
    private boolean isPartOfSelf(int[][] current, int[] next){
        for( int i = 0 ; i < 4; i++){
            if( current[i][0] == next[0] && current[i][1] == next[1])
                return true;
        }
        return false;
    }

    /*
     * Returns the int[][] of the coordinates that the Tetronimo WILL be in based on the move.
     *
     * 0 - Add to the grid
     * 1 - Left
     * 2 - Right
     * 3 - Down
     * 4 - Rotate
     */
    public int[][] getCoordinates(int m){
        int[][] current = null;

        int currentorientation = orientation;
        int xoffset = 0;
        int yoffset = 0;

        if( m == 1) // going left
            xoffset = -1;
        if( m == 2) // going right
            xoffset = 1;
        if( m == 3) // going down
            yoffset = 1;
        if( m == 4) // rotation
            currentorientation = (currentorientation + 1) % 4;


        if( currentorientation == 0 ){
            current = new int[][]{
                    {centerPiece[0] + xoffset, centerPiece[1]+ yoffset},
                    {centerPiece[0] + rotation0[0][0] + xoffset, centerPiece[1] + rotation0[0][1] + yoffset},
                    {centerPiece[0] + rotation0[1][0] + xoffset, centerPiece[1] + rotation0[1][1] + yoffset},
                    {centerPiece[0] + rotation0[2][0] + xoffset, centerPiece[1] + rotation0[2][1] + yoffset}
            };
        }

        if( currentorientation == 1 ){
            current = new int[][]{
                    {centerPiece[0] + xoffset, centerPiece[1] + yoffset},
                    {centerPiece[0] + rotation1[0][0] + xoffset, centerPiece[1] + rotation1[0][1] + yoffset},
                    {centerPiece[0] + rotation1[1][0] + xoffset, centerPiece[1] + rotation1[1][1] + yoffset},
                    {centerPiece[0] + rotation1[2][0] + xoffset, centerPiece[1] + rotation1[2][1] + yoffset}
            };
        }

        if( currentorientation == 2 ){
            current = new int[][]{
                    {centerPiece[0] + xoffset, centerPiece[1] + yoffset},
                    {centerPiece[0] + rotation2[0][0] + xoffset, centerPiece[1] + rotation2[0][1] + yoffset},
                    {centerPiece[0] + rotation2[1][0] + xoffset, centerPiece[1] + rotation2[1][1] + yoffset},
                    {centerPiece[0] + rotation2[2][0] + xoffset, centerPiece[1] + rotation2[2][1] + yoffset}
            };
        }

        if( currentorientation == 3 ){
            current = new int[][]{
                    {centerPiece[0] + xoffset, centerPiece[1] + yoffset},
                    {centerPiece[0] + rotation3[0][0] + xoffset, centerPiece[1] + rotation3[0][1] + yoffset},
                    {centerPiece[0] + rotation3[1][0] + xoffset, centerPiece[1] + rotation3[1][1] + yoffset},
                    {centerPiece[0] + rotation3[2][0] + xoffset, centerPiece[1] + rotation3[2][1] + yoffset}
            };
        }

        return current;
    }

    /*
     * Moves the Tetromino down until it cannot go down anymore
     */
    public void hardDrop(){
        while(isValidDown()){
            goDown();
        }
    }

}
