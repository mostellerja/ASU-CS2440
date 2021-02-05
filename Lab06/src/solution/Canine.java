package solution;


/**
 * Class Canine.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */

public abstract class Canine extends Animal
{
    /**
     *Canine Constructor.
     *@param myZoo **myZoo**
     *@param name **name**
     */
    public Canine(Zoo myZoo, String name)
    {
        super(myZoo, name);
        
    }   
    /**
     * Roam Method.
     */
    public void roam()
    {
        System.out.println("like canines roam in packs...");
        setHungerLevel(getHungerLevel() + 1);
    }

}


