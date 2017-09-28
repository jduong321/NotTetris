import java.io.IOException;

/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * The straight line piece of tetromino
 * */
public class TetrominoI extends Tetromino {
    /*
    private int[] centerPiece;
    private int[][] rotation0;
    private int[][] rotation1;
    private int[][] rotation2;
    private int[][] rotation3;
    private int orientation;
    private Grid playGrid;
     */

    // Constructor
    public TetrominoI(){
        centerPiece = new int[]{5,0};
        rotation0 = new int[][]{
                {-1, 0},
                { 1, 0},
                { 2, 0}
        };
        rotation1 = new int[][]{
                {0,-1},
                {0, 1},
                {0, 2}
        };
        rotation2 = rotation0;
        rotation3 = rotation1;
        orientation = 0;
        playGrid = Grid.getInstance();
    }

    public static void main(String[] args) throws IOException {
        Grid g  = Grid.getInstance();

        System.out.println("_____Add_____");
        TetrominoI testingI = new TetrominoI();
        if( testingI.isValidAddition() )
            g.add(testingI);
        g.show();

        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Down_____");
        if( testingI.isValidDown()){
            g.remove(testingI);
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Hard Drop_____");
        g.remove(testingI);
        testingI.hardDrop();
        g.addinactive(testingI);
        g.show();

    }
}
