import java.io.IOException;

/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * The T piece of tetromino
 * */
public class TetrominoT extends Tetromino {

    public TetrominoT(){
        centerPiece = new int[]{5,0};
        rotation0 = new int[][]{
                {-1, 0},
                { 1, 0},
                { 0, 1}
        };
        rotation1 = new int[][]{
                { 0,-1},
                {-1, 0},
                { 0, 1}
        };
        rotation2 = new int[][]{
                { 0,-1},
                {-1, 0},
                { 1, 0}
        };
        rotation3 = new int[][]{
                { 0,-1},
                { 1, 0},
                { 0, 1}
        };
        orientation = 0;
        playGrid = Grid.getInstance();
    }

    public static void main(String[] args) throws IOException {
        Grid g  = Grid.getInstance();

        System.out.println("_____Add_____");
        Tetromino testingI = new TetrominoT();
        if( testingI.isValidAddition() )
            g.add(testingI);
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


        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
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
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            testingI.goDown();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Down_____");
        if( testingI.isValidDown()){
            g.remove(testingI);
            testingI.goDown();
            g.add(testingI);
        }
        g.show();


        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Right_____");
        if( testingI.isValidRight()){
            g.remove(testingI);
            testingI.goRight();
            g.add(testingI);
        }
        g.show();

        System.out.println("_____Rotate_____");
        if( testingI.isValidRotation()){
            g.remove(testingI);
            testingI.goRotate();
            g.add(testingI);
        }
        g.show();
    }
}
