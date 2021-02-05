package solution;


/**
 * Class Hippo.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class Hippo extends Animal
{
    /**
     * Hippo Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */
    public Hippo(Zoo myZoo, String name)
    {
        super(myZoo, name);
         
    }
    /**
     * MakeNoise method.
     */ 
    public void makeNoise()
    {
        System.out.println("blub...");
    }
    /**
     * Eat Method.
     */ 
    public void eat()
    {
        System.out.println("slurp...");
        setHungerLevel(getHungerLevel() - 1);
    }   


}
