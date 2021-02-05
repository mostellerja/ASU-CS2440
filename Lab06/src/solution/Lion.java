package solution;


/**
 * Lion Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class Lion extends Feline
{
    /**
     * Lion Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */ 
    public Lion(Zoo myZoo, String name)
    {
        super(myZoo, name);


    }   
    /**
     * MakeNoise method.
     */ 
    public void makeNoise()
    {
        System.out.println("roar");
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
