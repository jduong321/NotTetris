The first design pattern we used was factory. The factory class does this by randomly generating a tetromino shape. This way we are able to create
tetromino objects without exposing the creation logic to the client.

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
	...
}

The next design pattern we used was the singleton pattern. The grid we had was a singleton object. We followed the implementation of having 
a static object of grid created. Then everytime we needed to access it we would have a getInstance function.

public static synchronized Grid getInstance(){
        if(instance == null)
            instance = new Grid(10,20);

        return instance;
    }