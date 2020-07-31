
/**
 *
 * @author Diana Arita
 */

public class CarInfo {
    private String make, type, ownerFirstName,
            ownerLastName, licenseState, licensePlate;
    
    public CarInfo() {
    }
    
    public CarInfo(String make, String type, String ownerFirstName, 
            String ownerLastName, String licenseState, String licensePlate) {
        this.make = make;
        this.type = type;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.licenseState = licenseState;
        this.licensePlate = licensePlate;
    }
    
    
    /*
    *Native method that returns the integer hash code value of an object.
    */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 7;
        
        result = prime * result + licenseState.hashCode();
        result = prime * result + licensePlate.hashCode();
        
        return result;
    }
    
    @Override
    public String toString() {
        return "Car is: " + ownerFirstName +
                " " + ownerLastName + 
                " - " + licensePlate + 
                " " + licenseState + 
                " " + make + 
                " " + type;
    }
    
}
