package solution;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sample program to show how to read the comma delimited text file pets.txt and
 * break the lines up into a name, age, and weight.
 * 
 * @author Aaron Mosteller
 * @version 3/21/2019
 * 
 */
public class FileReading
{
    public static final int TESTNUM = 300;
    SortedLinkedList<Book> bookList;
    private Scanner fileIn = null;
    
    /**
     * Constructor reads from filename.
     * 
     * @param filename
     *            The name of the file.
     */
    public FileReading(String filename)
    {
        // open the input file
        try
        {
            setFileIn(new Scanner(new FileReader(filename)));
        }
        catch (IOException ioe)
        {
            System.out.println("Could not open the input file." + filename);
            System.exit(0);
        }
        
        bookList = new SortedLinkedList<Book>();

        // read the data
        readLines();

        // close the input file
        fileIn.close();
    }

    /**
     * Sets the input scanner.
     * 
     * @param input
     *            The input scanner.
     */
    public void setFileIn(Scanner input)
    {
        fileIn = input;
    }

    /**
     * Read lines of the file.
     */
    public void readLines()
    {
        // String[] line;
        //String petName;
        //int petAge;
        //double petWeight;
        Book book;
        String[] line;
        String title;
        int numberOfPages;
        String author;

        // as long as there are lines to read
        while (fileIn.hasNextLine())
        {
            // read a line from the file and split it
            // into an array of Strings around the commas
            line = fileIn.nextLine().split(",");
            // put the data before the first comma in petName
            author = line[0];
            //petName = line[0];
            // put the data before the second comma in petAge
            // after converting the String to an integer
            title = (line[1]);
            //petAge = Integer.parseInt(line[1]);
            // put the data before the third comma in petWeight
            // after converting the String to a Double
            //petWeight = Double.parseDouble(line[2]);
            // print out the data for testing to make sure it worked
            numberOfPages = Integer.parseInt(line[2]);
            book = new Book(author, title, numberOfPages);
            bookList.add(book);
            //System.out.print("Name: " + petName + " ");
            //System.out.print("Age: " + petAge + " ");
            //System.out.println("Weight: " + petWeight);
        }
    }

    /**
     * Prints more than 300 pages.
     */
    public void printMoreThan300()
    {
        //FileReading fr = new FileReading("bookdata.txt");

        for (Book b : getBooks())
        {
            if (b.getNumberOfPages() > TESTNUM)
            {
                System.out.println(b.toString());
            }
        }

    }

    /**
     * @return double value for average pages.
     */
    public double averagePages()
    {
        //FileReading fr = new FileReading("bookdata.txt");
        
        int totalPages = 0;
        for (Book b : getBooks())
        
        {
            int pages  = b.getNumberOfPages();
            totalPages += pages;
        }
        
        return totalPages / (double) getBooks().getLength();

    }
    
    /**
     * GetBooks.
     * @return bookList.
     *
     */
    public SortedLinkedList<Book> getBooks()
    {
        return bookList;
    }
    /**
     * RemoveLessThan200.
     * @return
     */ 
    public void removeLessThan200() 
    {
        return;
    }

    /**
     * The main program to read from pets.txt.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args)
    {
        
        FileReading fr = new FileReading("bookdata.txt");

        for (Book b : fr.getBooks())
        {
            System.out.println(b.toString());
        }
    }

}
