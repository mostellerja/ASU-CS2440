package solution;



/**
 * Class Cat.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */
public class Cat extends Feline implements Pet
{
    /**
     * Constructor Cat.
     * @param myZoo **zoo**
     * @param name **name**
     */
    public Cat(Zoo myZoo, String name)
    {
        super(myZoo, name);
            
    }
    /**
     * MakeNoise Method.
     */
    public void makeNoise()
    {
        System.out.println("meow...");
    }
    /**
     * Eat method.
     */ 
    public void eat()
    {
        System.out.println("pick...");
        setHungerLevel(getHungerLevel() - 3);

    }
    /**
     * Play Method.
     */
    public void play()
    {
        System.out.println("frolic...");
    }
    /**
     * BeFriendly Method.
     */
    public void beFriendly()
    {
        System.out.println("purr...");
    }
}

