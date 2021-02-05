package solution;





/**
 * Dog Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */
public class Dog extends Canine implements Pet
{
    /**
     * Dog Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     *
     */
    public Dog(Zoo myZoo, String name)
    {
        super(myZoo, name);
        
    }
    /**
     * MakeNoise method.
     */ 
    public void makeNoise()
    {
        System.out.println("bark...");
    }
    /**
     * Eat Method.
     */
    public void eat()
    {
        System.out.println("slop...");
        setHungerLevel(getHungerLevel() - 3);
    }
    /**
     * Play Method.
     */
    public void play()
    {
        System.out.println("run around...");
    }
    /**
     * BeFriendly Method.
     */
    public void beFriendly()
    {
        System.out.println("yap...");
    }

}
