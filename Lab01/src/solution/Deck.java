package solution;
/**
 * PlayingCard.java
 * 
 * @author Mitch Parry
 * @version May 6, 2013
 */
import java.util.Random;
import java.util.ArrayList;
/**
 * The Deck represents a 52 PlayingCards in a deck.
 * @version August 13, 2013
 * @author Mitch Parry
 */
public class Deck 
{

    /**
     * Number of cards.
     */
    public static final int NUM_CARDS = 52;
    private ArrayList<PlayingCard> deck;
    private Random generator;
   
    /**
     * Constructor creates 52 cards and adds them to ArrayList deck.
     */
    public Deck() 
    {
        // Creates a random number generator to be used in shuffleDeck()
        generator = new Random();
        initialize();
    }
    /**
     * Constructor uses a parameter to set the random seed.
     * 
     * @param seed  Seed for the random number generator.
     */
    public Deck(int seed)
    {
        generator = new Random(seed);
        initialize();
    }
    /**
     * Initializes a sorted deck.
     */
    public void initialize() 
    {
        // TODO: Create the ArrayList that will hold the 52 cards
        deck = new ArrayList<>(NUM_CARDS);
        // TODO: Add code here to create and add all cards to the deck.
        // The resulting order should be from TWO CLUBS, TWO DIAMONDS, 
        // TWO HEARTS, TWO SPADES, THREE CLUBS, ..., ACE SPADES
        for (int i = 0; i < SuitsAndRanks.NUMRANKS; i++)
        {
            for (int j = 0; j < SuitsAndRanks.NUMSUITS; j++)
            {
                deck.add(new PlayingCard(SuitsAndRanks.fetchRank(i),
                    SuitsAndRanks.fetchSuit(j)));
            }
        }
    }

    /**
     * Randomly shuffles the PlayingCard order in the ArrayList deck.
     */
    public void shuffleDeck() 
    {    
        // TODO: Implement the shuffling algorithm: "...that picks a 
        // random card to go last, then a random card among the 
        // remaining cards to go second to last, then a random card 
        // among the remaining cards to go third to last, ... 
        for (int index = NUM_CARDS - 1; index > 0; index--) 
        {
			// TODO: pick a random card to go last among the remaining 
            // (unshuffled) cards.  Hint: 
            
            PlayingCard card1 = deck.get(index);
            // TODO: swap 
            int num = generator.nextInt(index + 1);
            
            PlayingCard card2 = deck.get(num);
            
            deck.set(num, card1);
            deck.set(index, card2);
            
            
        }
    }
    /**
     * Returns the PlayingCard at the 'index' in the deck.
     * 
     * @param index Index into the deck
     * @return  The PlayingCard at that 'index'.
     */
    public PlayingCard getCard(int index) 
    {
        // TODO return the playing card the 'index' in the deck.
        
        return deck.get(index);
    }
    
    /**
     * Returns a String representation of the Deck.
     * 
     * @return The string.
     */
    @Override
    public String toString() 
    {
        // TODO: Return a String with all the cards in the deck 
        // separated by an end line '\n' character.
        String str = "";
        /*for (int i = 0; i < SuitsAndRanks.NUMRANKS; i++)
        {
            for (int j = 0; j < SuitsAndRanks.NUMSUITS; j++)
            {
                str += SuitsAndRanks.fetchRank(i) + " "
                    + SuitsAndRanks.fetchSuit(j) + '\n';
            }
        }*/
        for (PlayingCard card : deck)
        {
            str += card.toString() + " ";
        }

        return str;
    }
}
