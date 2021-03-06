import java.io.IOException;

/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * The Z piece of tetromino
 * */
public class TetrominoZ extends Tetromino {
    public TetrominoZ(){
        centerPiece = new int[]{5,1};
        rotation0 = new int[][]{
                {-1,-1},
                { 0,-1},
                { 1, 0}
        };
        rotation1 = new int[][]{
                { 1,-1},
                { 1, 0},
                { 0, 1}
        };
        rotation2 = rotation0;
        rotation3 = rotation1;
        orientation = 0;
        playGrid = Grid.getInstance();
    }

    public static void main(String[] args) throws IOException {
        Grid g  = Grid.getInstance();

        System.out.println("_____Add_____");
        TetrominoZ testingI = new TetrominoZ();
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
