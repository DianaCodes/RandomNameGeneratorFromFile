import java.util.Random;


/**
 *
 * @author Diana Arita
 */

public class HashTable {
    public static void main(String[] args) {
        System.out.println("Diana Arita - aritad@csp.edu");
        
        System.out.println("I certify that this is my own work.");
        
        //Arrays that contain options for the getRandom function.
        String[] make = {"Honda",
                        "Toyota",
                        "Lexus",
                        "BMW",
                        "Nexus",
                        "Dodge",
                        "Range Rover",
                        "Chevy"};
        
        String[] type = {"SUV",
                        "Sedan",
                        "SUV",
                        "Coupe",
                        "Sedan",
                        "Pickup Truck",
                        "SUV",
                        "Hatchback"};
                        
        String[] ownerFirstName = {"James",
                          "Danielle",
                          "Roger",
                          "Jenny",
                          "Stella",
                          "Tyler",
                          "Gina",
                          "Simon"};
        
        String[] ownerLastName = {"Clark",
                          "Bartwrite",
                          "Wallace",
                          "Lee",
                          "Rogers",
                          "Lanes",
                          "Woods",
                          "Carl"};
        
        String[] licenseState = {"FL", "MN", "TN", "TX", "MI", "NY", "KY", "GA"};
        
        String[] licensePlate = {"YGTJIR", 
                                "GZVLYC",
                                "0VR3TC",
                                "UAPWHK",
                                "CUQVDI",
                                "LPH3K8",
                                "C5MI9G",
                                "J5RF9N"};

        //Instantiate hashtable
        MyMap<Integer, CarInfo> table = new MyHashMap<>();

        //Generate 100 random CarInfo objects & add to hashtable.
        for(int i=0;i<100;i++) {
            CarInfo car = new CarInfo(getRandom(make),
                                        getRandom(type),
                                        getRandom(ownerFirstName),
                                        getRandom(ownerLastName),
                                        getRandom(licenseState),
                                        getRandom(licensePlate));
            
            table.put(i,car);
            
        }
        
        int index = 0;
        
        //Display hashtable
        for(int x = table.size() - 1;x >= 0;x--) {
            System.out.println("Index is: " + index);
            
            //Compare every table value to each other.
            for(int y = table.size() - 1; y > x;y--){
                //Compare x and y hashcode's
                if(table.get(x).hashCode() == table.get(y).hashCode()){
                    //Display the table value if the hashcode's are the same.
                    System.out.println(table.get(y) + "   " + table.get(y).hashCode());
                }
            }
            index++;
        }
    }
    
    //Method returns a random index's value from an array.
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
