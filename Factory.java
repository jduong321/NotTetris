/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * Using a factory design system to create the tetromino. Factory File
 * */
import java.util.Random;
public class Factory {
    private Random generator;
    private static Factory instance = null;

    public Factory(){
        generator = new Random();
    }

    public static synchronized Factory getInstance(){
        if(instance == null)
            instance = new Factory();

        return instance;
    }

    public Tetromino getNext(){
        int random = generator.nextInt(7);

        if( random == 0 )
            return new TetrominoI();
        if( random == 1 )
            return new TetrominoJ();
        if( random == 2 )
            return new TetrominoL();
        if( random == 3 )
            return new TetrominoO();
        if( random == 4 )
            return new TetrominoS();
        if( random == 5 )
            return new TetrominoT();
        if( random == 6 )
            return new TetrominoZ();

        System.out.println("New Live Piece" + random);

        return null;
    }
}
