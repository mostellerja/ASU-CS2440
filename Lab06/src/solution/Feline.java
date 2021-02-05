package solution;


/**
 * Feline Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public abstract class Feline extends Animal
{
    /**
     * Feline Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */ 
    public Feline(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * Roam Method.
     */ 
    public void roam()
    {
        System.out.println("felines like to roam alone...");
        setHungerLevel(getHungerLevel() + 1);
    }




}
