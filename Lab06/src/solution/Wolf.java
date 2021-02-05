package solution;

/**
 * Wolf Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class Wolf extends Canine
{
    /**
     * Wolf Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */ 
    public Wolf(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     * MakeNoise method.
     */ 
    public void makeNoise()
    {
        System.out.println("growl...");

    }
    /**
     * Eat Method.
     */ 
    public void eat()
    {
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel() - 2); 
    }
   
    
}
