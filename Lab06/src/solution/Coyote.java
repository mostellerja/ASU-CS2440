package solution;



/**
 * Coyote class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public class Coyote extends Canine
{
    /**
     * Coyote Constructor.
     * @param myZoo **myZoo**
     * @param name **name**
     */
    public Coyote(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    /**
     *
     * 
     * MakeNoise Method. 
     */
    public void makeNoise()
    {
        System.out.println("howl...");

    }
    /**
     *Eat Method.
     */
    public void eat()
    {
        System.out.println("gnaws...");
        setHungerLevel(getHungerLevel() - 2);
    }
}
