package solution;


/**
 * Animal Class.
 * @author Aaron Mosteller
 * @version 2019-02-26
 */ 
public abstract class Animal
{

    private String name;
    private Zoo zoo;
    private int hungerLevel;


    /**
     * Animal Constructor.
     * @param myZoo **myZoo**
     * @param animalName **animalName**
     */ 
    public Animal(Zoo myZoo, String animalName)
    {
        
        setName(animalName);
        setHungerLevel(0);
    }
    /**
     * GetHungerLevel.
     * @return hungerLevel **hungerLevel**
     */ 
    public int getHungerLevel()
    {
        return hungerLevel;
    }
    /**
     * SetHungerLevel.
     * @param hunger **hunger**
     */ 
    public void setHungerLevel(int hunger)
    {
        hungerLevel = hunger;
        if (hungerLevel < 0)
        {
            hungerLevel = 0;
        }
        if (hungerLevel > 10)
        {
            hungerLevel = 10;
        }
    } 
    /**
     * GetName.
     * @return name **name**
     */ 
    public String getName()
    {
        return name;
    }
    /**
     * SetName.
     * @param animalName **animalName**
     */ 
    public void setName(String animalName)
    {
        name = animalName;


    }
    /**
     * Sleep Method.
     */ 
    public void sleep()
    {

        System.out.println("sleeping...");
        setHungerLevel(10);
    }
    /**
     * Roam Method.
     */ 
    public void roam()
    {
        System.out.println("moving around...");
        setHungerLevel(getHungerLevel() + 1);
    }
    /**
     * MakeNoise Method.
     */ 
    public abstract void makeNoise();
    

    
    /**
     * Eat Method.
     */ 
    public abstract void eat();
    

    

    

}
