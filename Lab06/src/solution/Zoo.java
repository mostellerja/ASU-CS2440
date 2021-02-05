package solution;

import java.util.ArrayList;
/**
 *Class Zoo.
 *@author Aaron Mosteller
 *@version 2019-02-25
 */
public class Zoo implements AnimalLocation

{
    
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> zooAnimals;

    /**
     * Constructor Zoo.
     * @param name **name**
     * @param lat **lat**
     * @param lon **lon**
     */
    public Zoo(String name, double lat, double lon)
    {
        this.name = name;
        latitude = lat;
        longitude = lon;
         
        zooAnimals = new ArrayList<Animal>();        
    }
    /**
     *GetLatitude.
     *@return latitude **latitude**
     * 
     *
     */
    public double getLatitude()
    { 
        return latitude;
    }
    /**
     * GetLongitude.
     * @return longitude **longitude**
     */
    public double getLongitude()
    {
        return longitude;
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
     *
     * SetName.
     * @param name **String name**
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * GetNumOfAnimals.
     * @return zoo.Animals.size **size of zoo**
     */
    public int getNumOfAnimals()
    {
        return zooAnimals.size();
    }  
    /**
     * AddAnimal.
     * @param animal **Animal animal**
     */
    public void addAnimal(Animal animal)
    {
        zooAnimals.add(animal);
    }
    /**
     * Test Animals Method.
     */
    public void testAnimals()
    {
        System.out.println(getName() + "\n" + getLatitude() 
            + "\n" + getLongitude() + "\n" + getNumOfAnimals() 
            + "\n");
        for (Animal a : zooAnimals)
        {
            System.out.println(a.getName());
            a.sleep();
            System.out.println(a.getName() + "is hungry");
            a.makeNoise();
            a.eat();
            a.roam();

            if (a instanceof Pet)
            {
               
              
                ((Pet) a).play();
                ((Pet) a).beFriendly();

            }
        }
    }
    /**
     * Main method.
     *
     * @param args **args**
     */
    public static void main(String[] args)
    {
       /** Zoo myZoo = new Zoo("NC Zoo, 74, 45);
        myZoo.addAnimal(new Hippo(myZoo, "Gloria"));
        myZoo.addAnimal(new Lion(myZoo, "Alex"));
        myZoo.addAnimal(new FeralCat(myZoo, "Steve"));
        myZoo.addAnimal(new Cat(myZoo, "Scratchy"));
        myZoo.addAnimal(new Dog(myZoo, "Fido"));
        myZoo.addAnimal(new Coyote(myZoo, "Wiley"));
        myZoo.addAnimal(new Wolf(myZoo, "Lloyd"));
        myZoo.addAnimal(new WildDog(myZoo, "Gerald"));
        */
    }
    
}

