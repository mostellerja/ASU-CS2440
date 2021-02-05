package solution;


/**
 * FeralCat class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class FeralCat extends Feline
{   
    /**
     * FeralCat Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */ 
    public FeralCat(Zoo myZoo, String name)
    {
        super(myZoo, name);

    }
    /**
     * MakeNoise method.
     */ 
    public void makeNoise()
    {
        System.out.println("meow...");
    }
    /**
     * Eat Method.
     */ 
    public void eat()
    {
        System.out.println("pick...");
        setHungerLevel(getHungerLevel() - 3);
 
    }
}
