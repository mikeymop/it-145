import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Dog extends RescueAnimal {

    // Instance variable
    public String breed;

    // Constructor
    /**
     * Dog
     * @param name
     * @param sex
     * @param age
     * @param weight
     * @param date
     * @param ASource
     */
    public Dog() {
    	super();
    	Scanner scnr = new Scanner(System.in);
    	System.out.print("What is the Dogs name? ");
    	super.setName(scnr.next());
    	System.out.print("\nIs the dog male or female? ");
    	super.setGender(scnr.next());
    	System.out.print("\nHow old is the dog? ");
    	super.setAge(scnr.nextInt());
    	System.out.print("\nHow heavy is the dog (in lbs)? ");
    	super.setWeight(scnr.nextFloat());
    	System.out.print("\nAt what date was the dog obtained (yyyy-mm-dd)? ");
    	String date = scnr.next();
    	super.setAcquisitionDate(new SimpleDateFormat(date));
    	System.out.print("\nFrom where was the dog obtained? ");
    	super.setAcquisitionSource(scnr.next());
    	
    	scnr.close();
    }
    
    /**
     * Dog
     * @param name
     * @param sex
     * @param age
     * @param weight
     * @param date
     * @param ASource
     */
    public Dog(String name, String sex, int age, float weight, String date, String ASource) {
    	super.setName(name); // overloaded Constructor enabling the consumer
    	super.setGender(sex); // to quickly create a Dog
    	super.setAge(age);
    	super.setWeight(weight);
    	super.setAcquisitionDate(new SimpleDateFormat(date));
    	super.setAcquisitionSource(ASource);
    	super.setType("Dog");
    }
    
    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    /**
     * If an accepted breed, sets the breed of the dog.
     * @param dogBreed
     */
    public void setBreed(String dogBreed) {
    	if(!dogBreed.isEmpty()) {	
    		
    		// this ugly code exists because of string switches in openjdk 1.8
    		if(dogBreed.equalsIgnoreCase("American Pit Bull Terrier")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("Beagle")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("belgian malinois")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("border collie")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("bloodhound")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("coonhound")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("english springer spaniel")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("german shepherd")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("german shorthaired pointer")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("golden retriever")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("labrador retriever")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("nova scotia duck tolling retriever")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("rough collie")) {
    			this.breed = dogBreed;
    		} else if(dogBreed.equalsIgnoreCase("smooth collie")) {
    			this.breed = dogBreed;
    		} else {
    			throw new Error("Sorry, breed is not in the list of approved breeds.");
    		}
    	}
    }

}
