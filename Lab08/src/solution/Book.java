package solution;

/**
 * Book.
 * 
 *
 * @author Aaron Mosteller
 * @version 4/1/19
 */ 
public class Book implements Comparable<Book>
{
    private String author;
    private String title;
    private int numberOfPages;
    

    /**
     * Constructor for Book class.
     * @param author **author**
     * @param title **title**
     * @param numberOfPages **numberOfPages**
     */ 
    public Book(String author, String title, int numberOfPages)
    {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;    
    
    }
    /**
     * @return author
     */  
    public String getAuthor()
    {
        return author;
    }
    /**
     * @return title
     */  
    public String getTitle()
    {
        return title;
    }
    /**
     * @return numberOfPages
     */  
    public int getNumberOfPages()
    {
        return numberOfPages;
    
    }
    /**
     * CompareTo Method.
     * @return title
     * @param other **other Book object**
     */ 
    public int compareTo(Book other)
    {
        int compare = this.author.compareTo(other.author);
        if (compare != 0)
        {
            return compare;
        }
        return this.title.compareTo(other.title);

    }
    /**
     * Equals method.
     * @return equals
     * @param other **other Book object**
     */ 
    public boolean equals(Book other)
    {
        return author.equals(other.author) && title.equals(other.title);
    
    }
    /**
     * toString Method.
     * @return str String output.
     */ 
    public String toString()
    {
        String str = (author + ", " + title + ", " + numberOfPages);
        return str;
    }
}









