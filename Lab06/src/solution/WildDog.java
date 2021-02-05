package solution;

/**
 * WildDog Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class WildDog extends Canine
{
    /**
     * WildDog Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */ 
    public WildDog(Zoo myZoo, String name)
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
}
