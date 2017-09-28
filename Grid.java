/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * Grid File. Used to keep track of the tetromino.
 * */

import java.io.IOException;
import java.util.ArrayList;

/**
 * This Singleton class holds the instance of the play grid which is a 2D array of integers.
 * The blocks are as follows:
 *
 * - 0  empty
 * - 1 live piece
 * - 2  non-live piece
 *
 * The live piece is the one that can move.
 */
public class Grid { // make singleton
    private static Grid instance = null;
    private int width;
    private int length;
    private int[][] playGrid;

    /*
     * Constructs the 2D array of ints with zeros
     *
     * @param xlength the width of the grid
     * @param ylength the length of the grid
     */
    public Grid(int xlength, int ylength){
        width = xlength;
        length = ylength;
        playGrid = new int[width][length];
    }

    /*
     * Returns the instance of the Grid
     */
    public static synchronized Grid getInstance(){
        if(instance == null)
            instance = new Grid(10,20);

        return instance;
    }

    /*
     * Returns the 2D array.
     *
     * @return the 2D int array
     */
    public int[][] getGrid(){
        return playGrid;
    }

    /*
     * Returns the width of the 2D array.
     *
     * @return the width of the grid
     */
    public int getWidth(){
        return width;
    }

    /*
     * Returns the length of the 2D array.
     *
     * @return the length of the grid
     */
    public int getLength(){
        return length;
    }

    /*
     * Method that returns if the coordinates in the array hold
     * grid spots that are empty and in the bounds.
     *
     *
     * @param xcoord the x coordinate that we are checking
     * @param ycoord the y coordinate that we are checking
     *
     * @return true, if the the coordinate in the 2D array is valid
     *         false, if not
     */
    public boolean isValid(int xcoord , int ycoord){
        boolean outOfBounds = ycoord < 0 || ycoord >= length ||
                              xcoord < 0 || xcoord >= width;
        boolean overlap = false;
        if( !outOfBounds )
            overlap = playGrid[xcoord][ycoord] != 0;

        // For debugging
        if( outOfBounds )
            System.out.println("Invalid move attempted, outOfBounds");
        if( overlap )
            System.out.println("Invalid move attempted, overlap");

        return !outOfBounds && !overlap;
    }

    /*
     * Method that will add a live Tetromino to the grid.
     *
     * @param t The Tetromino to be added to the grid
     */
    public void add(Tetromino t){
        int[][] coordinates = t.getCoordinates(0);

        for( int i = 0 ; i < 4 ; i++){
            //System.out.println(" Adding tetromino to  coordinates" + coordinates[i][0] + " , " + coordinates[i][1]);
            playGrid[ coordinates[i][0] ][ coordinates[i][1] ] = 1;
        }
    }

    /*
     * Method that will remove a live Tetromino from the grid. Effectively making the locations of that tetromino empty.
     * This method is used when a Tetromino is moved because it has to be removed before being moved down.
     *
     * @param t The Tetromino to be removed.
     */
    public void remove(Tetromino t){
        int[][] coordinates = t.getCoordinates(0);

        for( int i = 0 ; i < 4 ; i++){
            playGrid[ coordinates[i][0] ][ coordinates[i][1] ] = 0;
        }
    }

    /*
     * Method that sets all of the pieces in the Tetromino to inactive.
     *
     * @param t The Tetromino to be made inactive
     */
    public void addinactive(Tetromino t){
        int[][] coordinates = t.getCoordinates(0);

        for( int i = 0 ; i < 4 ; i++){
            playGrid[ coordinates[i][0] ][ coordinates[i][1] ] = 2;
        }
    }

    /*
     * Method that is called after a live piece is turned inactive and
     * the Grid needs to remove the rows that have a full row of inactive pieces
     * ( Naive Gravity )
     *
     * @return an arraylist of integers that are the rows we removed.
     */
    public ArrayList<Integer> removeRows(){
        ArrayList<Integer> removedRows = new  ArrayList<Integer>();

        for( int i = 0; i < length ; i++){
            int sum = 0;

            for( int j = 0 ; j < width ; j++) {
                sum += playGrid[j][i];
            }
            if( sum == 20) {
                removedRows.add(i);
            }
        }

        if( !removedRows.isEmpty() ){
            int[][] newGrid = new int[width][length];
            for( int w = 0 ; w < width ; w++){
                int newGridRow = removedRows.size();
                for( int l = 0 ; l < length ; l++){
                    if( !removedRows.contains(l) ) { // copy to new grid if the row was not in the removed rows
                        newGrid[w][newGridRow] = playGrid[w][l];
                        newGridRow++;
                    }
                }
            }
            playGrid = newGrid;
        }

        return removedRows;
    }

    /*
     * Method to make a certain places a certain piece for debugging
     */
    public void setLocations(int[][] coordinates, int type){
        for( int i = 0 ; i < coordinates.length ; i++){
            playGrid[ coordinates[i][0] ][ coordinates[i][1] ] = type ;
        }
    }

    /*
     * Resets the grid to all non live pieces
     */
    public synchronized void reset()
    {
        playGrid = new int[10][20];
    }

    /*
     * Method that shows what each piece is. (Mostly for Debugging)
     */
    public void show(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width ; j++){
                System.out.print(playGrid[j][i]);
            }
            System.out.println();
        }
    }

    // Testing the Piece
    public static void main(String[] args) throws IOException {
        Grid g  = new Grid(10,20);
        g.show();

        System.out.println("---- Added non live pieces ----");
        int[][] nonlivepieces = new int[][]{
                {  0 ,18},
                {  1 ,18},
                {  2 ,18},
                {  3 ,18},
                {  4 ,18},
                {  5 ,18},
                {  6 ,18},
                {  7 ,18},
                {  8 ,18},
                {  9 ,18},
                {  0 ,16},
                {  1 ,16},
                {  2 ,16},
                {  3 ,16},
                {  4 ,16},
                {  5 ,16},
                {  6 ,16},
                {  7 ,16},
                {  8 ,16},
                {  9 ,16},
                {  0 ,19},
                {  1 ,19},
                {  2 ,19},
                {  3 ,19},
                {  9 ,19},
                {  1 ,17},
                {  2 ,17},
                {  3 ,17},
                {  9 ,17},
                {  4 ,15},
                {  5 ,15},
                {  6 ,15},
                {  7 ,15},
                {  8 ,14},
                {  4 ,14},
                {  5 ,14},
        };
        g.setLocations(nonlivepieces,2);
        g.show();

        System.out.println("---- removing rows ----");
        g.removeRows();
        g.show();
    }

}
