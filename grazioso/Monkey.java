import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Monkey extends RescueAnimal {
	
	private String breed;
	private float tailLength;
	private float height;
	private float bodyLength;
	private String species;
	private float torsoSize;
	private float skullSize;
	private float neckLength;
	
	public Monkey() {
		super();
    	Scanner scnr = new Scanner(System.in);
    	System.out.print("What is the Monkey's name? ");
    	super.setName(scnr.next());
    	System.out.print("\nIs the monkey male or female? ");
    	super.setGender(scnr.next());
    	System.out.print("\nHow old is the monkey? ");
    	super.setAge(scnr.nextInt());
    	System.out.print("\nHow heavy is the monkey (in lbs)? ");
    	super.setWeight(scnr.nextFloat());
    	System.out.print("\nAt what date was the monkey obtained (yyyy-mm-dd)? ");
    	String date = scnr.next();
    	super.setAcquisitionDate(new SimpleDateFormat(date));
    	System.out.print("\nFrom where was the monkey obtained? ");
    	super.setAcquisitionSource(scnr.next());
    	
    	scnr.close();
	}

	public Monkey(String name, String sex, int age, float weight, String date, String Asource) {
		super.setName(name); // overloaded constructor enabling the api consumer to quickly
		super.setGender(sex); // create a Monkey
		super.setAge(age);
		super.setWeight(weight);
		super.setAcquisitionDate(new SimpleDateFormat(date));
		super.setAcquisitionSource(Asource);
		super.setType("Monkey");
		
	}
	 
	public String getBreed() {
		return this.breed;
	}
	
	public float getTailLength() {
		return this.tailLength;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public float getBodyLength() {
		return this.bodyLength;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public float getTorsoSize() {
		return this.torsoSize;
	}
	
	public float getSkullSize() {
		return this.skullSize;
	}
	
	public float getNeckLength() {
		return this.neckLength;
	}
	
	/**
     * If an accepted breed, sets the breed of the monkey.
     * @param monkeyBreed
     */
    public void setSpecies(String species) {
    	if(!species.isEmpty()) {
    		
    		if(species.equalsIgnoreCase("Capuchin")) { // this ugliness is because of my switch issues
    			this.breed = species;
    		} else if(species.equalsIgnoreCase("Guenon")) {
    			this.breed = species;
    		} else if(species.equalsIgnoreCase("Macaque")) {
    			this.breed = species;
    		} else if(species.equalsIgnoreCase("Marmoset")) {
    			this.breed = species;
    		} else if(species.equalsIgnoreCase("Squirrel Monkey")) {
    			this.breed = species;
    		} else if(species.equalsIgnoreCase("Tamarin")) {
    			this.breed = species;
    		} else {
    			throw new Error("Sorry, species is not in the list of approved breeds.");
    		}
    		
//    		switch(species.toLowerCase()) { // eval based on the lowercase to make the check easier
//    			case "capuchin":
//    			case "guenon":
//    			case "macaque":
//    			case "marmoset":
//    			case "squirrel monkey":
//    			case "tamarin":
//    				this.breed = species; // all valid cases will 'fall-through' and get assigned
//    				break;
//    			default: // assume the user did not enter a valid breed, throw err.
//    				throw new Error("Sorry, species is not in the list of approved breeds.");
//    		}
    	}
    }
    
    public void setTailLength(float length) {
    	if(length > 0) {
    		this.tailLength = length;
    	}
    	else {
    		throw new Error("Tail length must be greater than 0");
    	}
    }
    
    public void setHeight(float height) {
    	if(height > 0) {
    		this.height = height;
    	}
    	else {
    		throw new Error("Height must be greater than 0");
    	}
    }
	
	public void setBodyLength(float length) {
		if(length > 0) {
			this.bodyLength = length;
		}
		else {
			throw new Error("Length must be greater than 0");
		}
	}
	
	public void setTorseSize(float size) {
		if(size > 0) {
			this.torsoSize = size;
		}
		else {
			throw new Error("Torso size must be greater than 0");
		}
	}
	
	public void setSkullSize(float size) {
		if(size > 0) {
			this.skullSize = size;
		}
		else {
			throw new Error("Skull size must be greater than 0");
		}
	}
	
	public void setNeckLength(float length) {
		if(length > 0) {
			this.neckLength = length;
		}
		else {
			throw new Error("Neck length must be greater than 0");
		}
	}
}
