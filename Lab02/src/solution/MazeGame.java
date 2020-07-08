package solution;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * A maze game.
 * 
 * @author AaronMosteller
 * @version 0.1
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;
    
    /**
     * The current location of the player vertically.
     */
    // TODO: add field here.
    private int userCol;
    /**
     * The current location of the player horizontally.
     */
    // TODO: add field here.
    private int userRow;
    /**
     * The scanner from which each move is read.
     */
    // TODO: add field here.
    private Scanner moveScanner;
    /**
     * The row and column of the goal.
     */
    // TODO: add fields here.
    private int goalRow;
    private int goalColumn;
    /**
     * The row and column of the start.
     */
    // TODO: add fields here.
    private int startRow;
    private int startColumn;
    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     * @throws FileNotFoundException 
     *  
     */
    public MazeGame(String mazeFile)
    {
        // TODO
        
        try
        {
            loadMaze(mazeFile);
            moveScanner = new Scanner(System.in);
        }
        catch (Exception e)
        {
            System.out.println("File doesn't exist" + e);
            
        }
    }
    
    

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     * @throws FileNotFoundException
     * 
     * 
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
        
    {
    	// TODO
        
        loadMaze(mazeFile);
        this.moveScanner = moveScanner;
        
        
    }
    /**
     * Getter for blocked. 
     * @return blocked **returns blocked**
     */
    public boolean[][]getBlocked()
    
    {
        return blocked;
        
    }
    /**
     * Getter for User Column.
     * @return userCol **userCol**
     */
    public int getUserCol()
    {
        return userCol;
        
    }
    /**
     * Getter for User Row.
     * @return userRow **userRow**
     */
    public int getUserRow()
    {
        return userRow;
    }
    /**
     * Getter for Scanner getMoveScanner.
     * @return moveScanner **moveScanner**
     */
    public Scanner getMoveScanner()
    {
        return moveScanner;
    }
    /**
     * Setter for blocked.
     * @param blocked **blocked**
     */
    public void setBlocked(boolean[][] blocked)
    {
        this.blocked = blocked;
        
    }
    /**
     * Setter for user Column.
     * @param userCol **userCol**
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
        
    }
    
    /**
     * Setter for user Row.
     * @param userRow **userRow**
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
        
    }
    /**
     * Setter for moveScanner.
     * @param moveScanner **moveScanner**
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
        
    }
    
    
    
    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }
    
    /**
     * Function loads the data from the maze file and creates the 'blocked' 
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     * @throws FileNotFoundException 
     */
    // TODO: private void loadMaze(String mazeFile)
    private void loadMaze(String mazeFile)       
    {
        blocked = new boolean[HEIGHT][WIDTH];              
        try
        {            
            File file = new File(mazeFile);
            Scanner mazeReader = new Scanner(file);            
            for (int i = 0; i < HEIGHT; i++)
            {                
                for (int j = 0; j < WIDTH; j++)
                {
                    String str = mazeReader.next();
                    switch (str)
                    {
                        case "1":
                            blocked[i][j] = true; 
                            break;
                        case "S":
                            startRow = i;
                            startColumn = j;
                            userRow = i;
                            userCol = j;
                            break;
                        case "G":
                            goalRow = i;
                            goalColumn = j;
                            break;
                        default:                              
                    }                    
                }
            }           
            mazeReader.close();           
        }
        catch (Exception e)
        {
            System.out.println("File doesn't exist" + e);           
        }
    }
    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        printMaze();
        System.out.println("Enter a move: ");
        
       
    }

    /**
     * Checks to see if the player has won the game.
     * @return true if the player has won.
     */
    // TODO: public boolean playerAtGoal()
    public boolean playerAtGoal()
    {
        if (userRow == goalRow)
        {
            if (userCol == goalColumn)
            {
                return true;
            }
        
        }
        return false;
    }
    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {
        // TODO
        
        
        return false;
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        // TODO
        //Top border
        System.out.print('*');
        for (int b = 0; b < WIDTH; b++)
        {
            System.out.print("-");
        }
        System.out.println('*');
        for (int row = 0; row < HEIGHT; row++)
        {
            System.out.print('|');
            for (int col = 0; col < WIDTH; col++)
            {
                
                if (row == userRow && col == userCol)
                {
                    System.out.print('@');
                }
                else if (row == startRow && col == startColumn)
                {
                    System.out.print('S');
                }
                else if (row == goalRow && col == goalColumn)
                {
                    System.out.print('G');
                }
                else if (blocked[row][col])
                {
                    System.out.print('X');
                }
                else if (!blocked[row][col])
                {
                    System.out.print(' ');
                }
                
            }
            System.out.println('|');
        }
        //Bottom Border
        System.out.print('*');
        for (int b = 0; b < WIDTH; b++)
        {
            System.out.print("-");
        }
        System.out.println('*');
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     * @throws IOException 
     */

    public static void main(String[] args) throws IOException
    {
        String mapFile = "data/easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
    }
}
