/**
 * Jacky Duong, Jamie Auza
 * jduong2, auza2
 * HW5
 * The GUI of the tetris program
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.io.*;
import java.awt.Font;
import java.util.Random;

public class  GUI extends JFrame implements ActionListener
{
  // Menu Items
  private JMenuBar menuBar;
  private JMenu menu;
  private JMenuItem reset;
  private JMenuItem help;
  private JMenuItem exit;
  private JMenuItem about;

  // Panels
  private JPanel grid, infoPanel, nextpiecegrid, rightPanel;
  private Container container;

  // Icons
  private Icon iconArray[];
  private JLabel tetrominoGrid[][];
  private JLabel nextPieces[][];
  private JLabel scoreLabel;
  private JLabel clearedLabel;

  // Info Items
  private int rowCleared=0;
  private JLabel levelLabel;

  private int level=( rowCleared /10) + 1;
  private JLabel timerLabel;

  private javax.swing.Timer clockTimer;
  private int timeCounter = 0;

  private int score= 0;
  
  private javax.swing.Timer gravity;

  // Tetromino & Grid
  private Tetromino livePiece;
  private Tetromino nextPiece;
  private Grid behindGrid;

  // Factory
  Factory factory;

  private String IconImage[] =
  {   "whitesquare.jpg" ,"bluesquare.jpg" , "blacksquare.jpg","clear.jpg" };
  
  public GUI()
  {
    super("Tetris");

    factory  = Factory.getInstance();
    nextPiece = factory.getNext();
    behindGrid = Grid.getInstance();

    
    iconArray = new Icon[4];
    for ( int count = 0; count < 4; count++ ) 
    {
     iconArray[ count ] = new ImageIcon ( IconImage[ count ] );

    }
    
    
    // Initializing all menuItems
    menuBar = new JMenuBar();
    menu = new JMenu("Menu");
    
    reset = new JMenuItem("Start");
    reset.addActionListener( this );
    reset.setMnemonic(KeyEvent.VK_R);
    
    help = new JMenuItem("Help");
    help.addActionListener( this );
    help.setMnemonic(KeyEvent.VK_H);
    
    exit = new JMenuItem("Quit");
    exit.addActionListener( this );
    exit.setMnemonic(KeyEvent.VK_Q);
    
    about = new JMenuItem("About");
    about.addActionListener( this );
    about.setMnemonic(KeyEvent.VK_A);
    
    menu.add(reset);
    menu.add(help);
    menu.add(about);
    menu.add(exit);
    menuBar.add(menu);
    this.setJMenuBar(menuBar);

    // Initializing Info Items
    timerLabel = new JLabel("Time:" + timeCounter);
    clearedLabel = new JLabel("Lines Cleared:"+rowCleared);
    levelLabel = new JLabel("Level:"+ level);
    scoreLabel = new JLabel("Score:"+score);
    clockTimer = new javax.swing.Timer(1000, new TimerHandler());
    int form = 1000 + (35 - (level*35));
    gravity = new javax.swing.Timer(form, new TimerHandler2());

    // Next Piece Grid -- Info
    nextPieces = new JLabel[4][4];
    rightPanel =  new JPanel( new GridLayout(3, 1, 5, 5));
    JPanel nextpieceArea = new JPanel( new BorderLayout());
    nextpiecegrid = new JPanel();
    nextpiecegrid.setLayout (new GridLayout (4, 4, 0 ,0));
    nextpiecegrid.setSize(50,50);

    for(int i =0; i < 4;i++)
    {
      for(int j = 0; j< 4;j++)
      {
        nextPieces[i][j] = new JLabel(new ImageIcon(IconImage[0]));
        nextpiecegrid.add((nextPieces[i][j]));
      }
    }

    nextpieceArea.add( new JLabel( new ImageIcon("Filler2.png")), BorderLayout.WEST);
    nextpieceArea.add( new JLabel( new ImageIcon("Filler2.png")), BorderLayout.EAST);
    nextpieceArea.add( new JLabel( new ImageIcon("Filler2.png")), BorderLayout.SOUTH);
    nextpieceArea.add(nextpiecegrid, BorderLayout.CENTER);
    nextpieceArea.add( new JLabel("NEXT PIECE"), BorderLayout.NORTH);

    //Setting up Stats -- Info
    infoPanel = new JPanel( new GridLayout(4, 1));
    infoPanel.add(scoreLabel);
    infoPanel.add(clearedLabel);
    infoPanel.add(levelLabel);
    infoPanel.add(timerLabel);

    //Adding all Info to Right Panel
    rightPanel.add(nextpieceArea);
    rightPanel.add( new JLabel(new ImageIcon("Filler.png")));
    rightPanel.add(infoPanel);

    // Initializing Grid
    grid = new JPanel( );
    grid.setLayout (new GridLayout (20, 10, 0 ,0));
    grid.setSize( 10 * 20 , 20 * 20 );
    infoPanel = new JPanel( new GridLayout(4,1));

    //Coloring the initial grid
    tetrominoGrid = new JLabel[20][10];
    this.addKeyListener(new KeyBoardHandler());

    //setting up the play grid should be a method on its own
    

    for(int y = 0; y < 20; y++)
    {
      for(int x = 0; x < 10; x++)
      {
        
        tetrominoGrid[y][x] = new JLabel("");
        tetrominoGrid[y][x].setIcon((iconArray[0]));
        grid.add(tetrominoGrid[y][x]);
      }
    }


    // Adding all different Panels to Containter
    container = getContentPane();
    container.setLayout( new BorderLayout() );

    JPanel center = new JPanel( new GridLayout(1, 2, 5, 5));
    center.add(grid);
    center.add(rightPanel);
    container.add(center,BorderLayout.CENTER);

    clockTimer.start();
    gravity.start();
    setSize(600,650);
    setVisible(true);
    
  }
  
  public static void main(String args[])
  {
    GUI tetris = new GUI();
    tetris.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  
  public void reset()
  {
    
   
    behindGrid.reset();
    level = 1;
    rowCleared =0;
    timeCounter = 0;
    livePiece = null;
    score = 0;
     for(int y = 0; y < 20; y++)
    {
      for(int x = 0; x < 10; x++)
      {
        
        tetrominoGrid[y][x].setIcon((iconArray[0]));
      
      }
    }
    
  }
  
  public void actionPerformed (ActionEvent e)
  {
    
    Object source = e.getSource();
    if( source == exit)
    {
            System.exit(0);
    }
    else if(source ==about)
    {
      JOptionPane.showMessageDialog( this,"The 5th project assignment for CS342");
    }

    else if(source == help)
    {
      JOptionPane.showMessageDialog( this,"Move the tetro with the left and right.\n Pressing" 
       +"down would make it soft drop.\n Pressing space would make a hard drop. \nPressing up would"
      + " cause the tetro to rotate.\n Press r to reset the game.\n Start from the menu is the same "
       +"starting/restarting.\n About tells who we are.\n Exit closes the game.  ");
    }
    else if (source == reset)
    {
      reset();
    }
    
  }
 public synchronized void repaintNext(){
    for(int i =0; i < 4;i++)
    {
      for(int j = 0; j< 4;j++)
      {
        nextPieces[i][j].setIcon(iconArray[3]);
      }
    }

    int[][] temp = nextPiece.getCoordinates(0);
    for(int i = 0; i < 4; i++)
    {
      nextPieces [ temp[i][1] + 1 ][ temp[i][0] - 4 ].setIcon(iconArray[1]);
    }
  }
  private class KeyBoardHandler extends KeyAdapter
  {
    public void keyPressed(KeyEvent e)
    {
      int source = e.getKeyCode();
      if(source == KeyEvent.VK_LEFT)
      {
        clockTimer.stop();
        if(livePiece != null && livePiece.isValidLeft()  ){
          behindGrid.remove(livePiece);
          livePiece.goLeft();
          behindGrid.add(livePiece);
          repaintGrid();
          //Repaint the GUI
        }
        clockTimer.start();
        //move left
      }
      else if(source == KeyEvent.VK_RIGHT)
      {
        clockTimer.stop();
        if(livePiece != null && livePiece.isValidRight() ) {
          behindGrid.remove(livePiece);
          livePiece.goRight();
          behindGrid.add(livePiece);
          repaintGrid();
        }
        clockTimer.start();
          //move right
      }
      else if(source == KeyEvent.VK_UP)
      {
        clockTimer.stop();
        if( livePiece != null &&livePiece.isValidRotation() ) {
          behindGrid.remove(livePiece);
          livePiece.goRotate();
          behindGrid.add(livePiece);
          repaintGrid();
        }
        clockTimer.start();
        //ROTATIONS
      }
      else if(source == KeyEvent.VK_DOWN)
      {
        //soft drop?
        if(livePiece != null && livePiece.isValidDown() ) {
          behindGrid.remove(livePiece);
          livePiece.goDown();
          behindGrid.add(livePiece);
          repaintGrid();
        }
        else{
          if(livePiece != null){
            behindGrid.addinactive(livePiece);
            livePiece = null;
            behindGrid.removeRows();
            repaint();
          }
        }
      }
      else if(source == KeyEvent.VK_SPACE)
      {
        if(livePiece != null){
          behindGrid.remove(livePiece);
          livePiece.hardDrop();
          behindGrid.addinactive(livePiece);
          repaintGrid();
        }
        //repaint the GUI
        //get a new live piece
        //hard drop
      }
      else if(source == KeyEvent.VK_R)
      {
        //reset
        reset();
      }
    }
  }

  public synchronized void repaintGrid(){
     int[][] temp = behindGrid.getGrid();
    for(int y = 0; y < 20; y++)
    {
      for(int x = 0; x < 10; x++)
      {
        tetrominoGrid[y][x].setIcon(iconArray[temp[x][y]]);
      }
    }
  }

  private class TimerHandler2 implements ActionListener {
    public void actionPerformed( ActionEvent event )
    {
      if (livePiece == null) {
          livePiece = nextPiece;
          nextPiece = factory.getNext();
          repaintNext();
          // initialize the next piecegrid to be the next piece
          if (livePiece.isValidAddition()) {
            behindGrid.add( livePiece);
            repaintGrid();
          }
          else{ // GAME OVER
            JOptionPane.showMessageDialog(null, "You lost, are you sorry?");
            reset();
          }
        }
        else{
          if (livePiece.isValidDown()) {
            behindGrid.remove( livePiece);
            livePiece.goDown();
            behindGrid.add( livePiece);
            repaintGrid();
          }
          else{
            behindGrid.addinactive(livePiece);
            livePiece = null;
            ArrayList<Integer> d =behindGrid.removeRows();
            rowCleared = rowCleared + d.size();
            if (d.size() ==1)
            {
              score = score + (40* level);
            }
            else if (d.size() ==2)
            {
              score = score + (100* level);
            }
            else if (d.size() ==3)
            {
              score = score + (300* level);
            }
            else if (d.size() ==4)
            {
              score = score + (1200* level);
            }
            scoreLabel.setText("Score:"+score);
            clearedLabel.setText("Lines Cleared:"+rowCleared);
            level =( rowCleared /10) + 1;
            if(level >= 25) 
              level = 24;
            levelLabel.setText("Level:"+level);
            int form = 1000 + (35 - (level*35));
            gravity = new javax.swing.Timer(form, new TimerHandler());
            repaintGrid();
          }
        }
    }
  }
  private class TimerHandler implements ActionListener {
    public void actionPerformed( ActionEvent event )
    {
      //This is where we go when we start the timer and change the icon for the timer
        timeCounter++;
        timerLabel.setText("Time:  " + timeCounter);

       


    }
  } // end private inner class TimerHandler

  }
