import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Info on printf:
 * https://linux.die.net/man/3/printf
 * 
 */

public class Driver {
	
//	private static Map<String, ArrayList<RescueAnimal>> animals;
	private static ArrayList<RescueAnimal> animals;
	
	/**
	 * Small function to generate a formatted table of the animals in the list
	 * @param list - An array of animals
	 * @param message - The message to display at the table header
	 * @return The animal the user selected from the list
	 */
	public static RescueAnimal DisplayListOfAnimals(ArrayList<RescueAnimal> list, String message) {
		if(message.length() > 0) { // Only print a message if provided
			System.out.print(message);
		}

		for(int i = 0; i < list.size(); i++) { // iterate over all of the animals and print their info
			RescueAnimal animal = list.get(i);
			String trainingEnd = animal.getTrainingEnd().format(new Date());
			System.out.printf("%d) Name: %-15s, Date: %-15s Type: %-15s", i, animal.getName(), trainingEnd, animal.getType() );
			System.out.println("");
		}

		Scanner scnr = new Scanner(System.in); // ask the user to select animal from the list
		System.out.print("Select a Rescue Animal from the list: ");
		RescueAnimal animal = list.get(scnr.nextInt());

		scnr.close();
		return animal;
	}
	
	public static RescueAnimal RequestAnimal(String country, String animalType ) {
		
// OpenJDK8 doesn't support string switches
//		switch(country) {
//			case "Greece":
//			case "Japan":
//			case "Madagascar":
//			case "Singapore":
//			case "South Korea":
//			case "Turkey":
//			case "United Kingdom":
//			case "United States":
//				break;
//			default:
//				throw new Error("We dont have any locations in this country.");
//		}
		
		ArrayList<RescueAnimal> validAnimals = new ArrayList<RescueAnimal>(); // start a list of animals to return
		
		// accumulate a list of animals that fit the customer's criteria
		for(RescueAnimal animal : animals) {
			if(animal.getServiceCountry().equalsIgnoreCase(country.toLowerCase())) { // ensure animals that
				if(animal.getType().equalsIgnoreCase(animalType.toLowerCase())) {   // are valid for rescue
					if(animal.getTrainingStatus().equalsIgnoreCase("In Service"))   // make it into the list
						validAnimals.add(animal);
				}
			}
		}
		
		RescueAnimal animal = DisplayListOfAnimals(validAnimals, "\nAvailable Rescues:\n");
		animal.setReserved(true); // mark the animal as reserved to prevent double booking
		animal.setTrainingStatus("Service"); // set the animals status to 'service' per spec
		
		return animal;
	}
	
	public RescueAnimal Select(RescueAnimal animal) {
		
		for(RescueAnimal selectedAnimal : animals) {
			if(selectedAnimal == animal) { // == in java compares reference addresses, so this can guarantee
				return selectedAnimal;	   // that we have the desired animal object
			}
		}

		throw new Error("Animal not found");
	}
	
	/**
	 * Search the animal repository for an animal with a matching name.
	 * @param name
	 * @return
	 */
	public static RescueAnimal FindByName(String name) {
		
		for(RescueAnimal selectedAnimal : animals) { // Java forEach loop, passes object instead of index for brevity
			if(selectedAnimal.getName().equalsIgnoreCase(name)) { // compare lowercase strings to eliminate discrepancies
				return selectedAnimal;
			}
		}

		throw new Error("Animal not found");
	}
	
	// Method to display matrix of animals based on location and status/training phase
	public static void DisplayAnimalsAtLocation(String location) {
		ArrayList<RescueAnimal> validAnimals = new ArrayList<RescueAnimal>();  // our working list of animals
		
		for(RescueAnimal animal : animals) {
			if (animal.getServiceCountry().equalsIgnoreCase(location)) {
				validAnimals.add(animal);
			}
		}
		
		System.out.printf("All animals at %s%n", location);
		for(RescueAnimal animal : animals) {
			String trainingEnd = animal.getTrainingEnd().format(new Date()); // get a date suitable for printing
			System.out.printf("Name: %-15s, Training Status: %-15s Date: %-15s Type: %-15s%n", 
				animal.getName(), animal.getTrainingStatus(), trainingEnd, animal.getType() );
		}
	}
	
	public static void AddNewRescue(RescueAnimal animal, String location) {
		Scanner scnr = new Scanner(System.in);
		animal.setTrainingStatus("Intake");
		
		if(animal.getName() == null) { // fill in any missing information on the animal
			System.out.print("What is the Dogs name? ");
	    	animal.setName(scnr.next());
		}
		
		if(animal.getGender() == null) {
			System.out.print("\nIs the dog male or female? ");
	    	animal.setGender(scnr.next());
		}
    	
		if(animal.getAge() == 0) {
			System.out.print("\nHow old is the dog? ");
	    	animal.setAge(scnr.nextInt());
		}
		
		if(animal.getWeight() == 0) {
			System.out.print("\nHow heavy is the dog (in lbs)? ");
	    	animal.setWeight((float) scnr.nextFloat());
		}
    	
		if(animal.getAcquisitionDate() == null) {
			System.out.print("\nAt what date was the dog obtained (yyyy-mm-dd)? ");
	    	String date = scnr.next();
	    	animal.setAcquisitionDate(new SimpleDateFormat(date));
		}
		
		if(animal.getAcquisitionSource() == null) {
			System.out.print("\nFrom where was the dog obtained? ");
	    	animal.setAcquisitionSource(scnr.next());
		}
		
		animal.setTrainingLocation(location);
		String type = animal.getType();
		
		if(type.equalsIgnoreCase("Dog")) {
			Dog dog = (Dog) animal;
			if(dog.getBreed() == null) {
				System.out.print("\n What breed is the dog? ");
				if(scnr.hasNext()) {
					dog.setBreed(scnr.next());
				} else {
					dog.setBreed("belgian malinois");
				}
				
			}
			animals.add(dog);
			System.out.printf("%n %s", dog.getName());
		}
		
		if(type.equalsIgnoreCase("Monkey")) {
			Monkey monkey = (Monkey) animal;
			
			if(monkey.getTailLength() == 0) {
				System.out.print("\n How long is the monkey's tail? ");
				if(scnr.hasNextFloat()) { 		// I dont know why, but my eclipse wont let me enter more than one
					monkey.setTailLength(scnr.nextFloat()); // entry into STDIN. This works fine when I am using
				} else {									// the linux terminal, so I added all these default
					monkey.setTailLength(20.8f);			// values to ensure it runs smoothly in eclipse
				}
				
			}
			
			if(monkey.getHeight() == 0) {
				System.out.print("\n How tall is the monkey? ");
				if(scnr.hasNextFloat()) { // see above comment
					monkey.setHeight(scnr.nextFloat());
				} else {
					monkey.setHeight(45.8f);
				}
			}
			
			if(monkey.getBodyLength() == 0) {
				System.out.print("\n How long is the monkey's body?");
				if(scnr.hasNextFloat()) { // again
					monkey.setBodyLength(scnr.nextFloat());
				} else {
					monkey.setBodyLength(95.73f);
				}
			}
			
			if(monkey.getTorsoSize() == 0) {
				System.out.print("\n What size is the monkey's torso? ");
				if(scnr.hasNextFloat()) { // again
					monkey.setTorseSize(scnr.nextFloat());
				} else {
					monkey.setTorseSize(35f);
				}
			}
			
			if(monkey.getSkullSize() == 0) {
				System.out.print("\n How large is the monkey's skull ");
				if(scnr.hasNextFloat()) { // and again
					monkey.setSkullSize(scnr.nextFloat());
				} else {
					monkey.setSkullSize(15.3f);
				}
			}
			
			if(monkey.getNeckLength() == 0) {
				System.out.print("\n How long is the monkey's neck? ");
				if(scnr.hasNextFloat()) { // and again
					monkey.setNeckLength(scnr.nextFloat());
				} else {
					monkey.setNeckLength(4.57f);
				}
			}
			
			if(monkey.getBreed() == null) {
				System.out.print("\n What species is the Monkey? ");
				if(scnr.hasNext()) { // and again
					monkey.setSpecies(scnr.next());
				} else {
					monkey.setSpecies("Capuchin");
				}
				
			}
			animals.add(monkey);
			System.out.printf("%n %s ", monkey.getName());
		}

		System.out.print("will begin training soon.\n");

		scnr.close();
	}
	
	public static void ShowAllInServiceAnimals() {
		ArrayList<RescueAnimal> validAnimals = new ArrayList<RescueAnimal>();
		
		System.out.println("\nAll In Service Animals:");
		
		for(RescueAnimal animal : animals) { // iterate over all animals looking for a status of "In Service"
			if(animal.getTrainingStatus().equalsIgnoreCase("In Service")) {
				validAnimals.add(animal);
			}
		}
		
		for(RescueAnimal animal : validAnimals) { // iterate over working list and display each animal's info
			String endDate = animal.getTrainingEnd().format(new Date());
			System.out.printf("Name: %-15s Date: %-10s Type: %-10s%n", animal.getName(), endDate, animal.getType());
		}
	}
	
	/**
	 * Process reports from in-service agencies reporting death/retirement
	 */
	public static void StatusReport() {
		HashMap<String, ArrayList<RescueAnimal>> report = new HashMap<String, ArrayList<RescueAnimal>>();
		
		for(RescueAnimal animal : animals) {
			String country = animal.getServiceCountry();
			if(report.get(country) == null) { // if a country doesn't yet have any animals stored, the arraylist will be null
				ArrayList<RescueAnimal> list = new ArrayList<RescueAnimal>(); // create an empty arraylist and store it in the country key
				report.put(country, list); // this prevents NPE's when iterating over the hashmap later
			}

			ArrayList<RescueAnimal> list = report.get(country); // we can not get an actual list, even if empty from the country key
			String status = animal.getTrainingStatus();
			
			if(status.equalsIgnoreCase("Farm") || status.equalsIgnoreCase("Deceased")) {
				list.add(animal); // we ignore the casing in string comparison to accommodate user input
			}
			report.put(country, list);
		}
		
		System.out.print("\n\nStatus Report\n"); // report header

		for(Entry<String, ArrayList<RescueAnimal>> entry : report.entrySet()) { // using entrySet, we can iterate over a hashmap's keys
			String country = entry.getKey();
		    ArrayList<RescueAnimal> currAnimals = entry.getValue(); // the value of the Entry object will be the ArrayList storing the animals
		    
		    System.out.printf("%nCountry: %s%n", country); // report subheader
		    if(currAnimals != null) { // protect from NPE's in case the above failed
		    	for(RescueAnimal animal : currAnimals) { // iterate over all of the animals in a country key and print their info
			        System.out.printf("  Name: %-15s Status: %-15s", animal.getName(), animal.getTrainingStatus());
			    }
		    }
		}
	}

    public static void main(String[] args) {

        // Instance variables
    	animals = new ArrayList<RescueAnimal>();

        Dog dog1 = new Dog("Spot", "Male", 8, 86.7f, "2018-05-07", "United States"); // Create New Dog
        dog1.setTrainingLocation("United States");
        dog1.setTrainingStatus("Phase IV");
        dog1.setServiceCountry("United States");
        dog1.setTrainingEnd(new SimpleDateFormat("2020-01-13"));

        Monkey monkey1 = new Monkey("Mr. Chippers", "Male", 15, 20.8f, "2019-07-09", "Madagascar"); // Create New Monkey
        monkey1.setTrainingLocation("Madagascar");
        monkey1.setTrainingStatus("In Service");
        monkey1.setServiceCountry("Madagascar");
        monkey1.setTrainingEnd(new SimpleDateFormat("2019-03-07"));

        animals.add(dog1); // Add animals to the system manually
        animals.add(monkey1);

        // Method to process request for a rescue animal
        RescueAnimal selectedAnimal = RequestAnimal("Madagascar", "Monkey");
        System.out.printf("%nCongrats on adopting %s%n%n", selectedAnimal.getName());
        selectedAnimal = null;

        // Method(s) to update information on existing animals
        selectedAnimal = FindByName("Mr. Chippers");
        
        selectedAnimal.setAge(16);
        selectedAnimal.setWeight(25f);


        // Method to display matrix of animals based on location and status/training phase
        DisplayAnimalsAtLocation("Madagascar");


        // Method to add animals
        Monkey monkey2 = new Monkey("Shina", "female", 15, 20.8f, "2019-07-09", "Madagascar");
        AddNewRescue(monkey2, "United Kingdom"); // Add an animal using api

        // Method to out process animals for the farm or in-service placement
        RescueAnimal farmAnimal = FindByName("Shina");
        farmAnimal.setTrainingStatus("Farm");


        // Method to display in-service animals
        dog1.setTrainingStatus("In Service"); // modify the statuses of the demo animals
        monkey1.setTrainingStatus("In Service"); // so that they appear in the report
        ShowAllInServiceAnimals();


        // Process reports from in-service agencies reporting death/retirement
        dog1.setServiceCountry("United States");
        monkey1.setServiceCountry("Madagascar"); // modify the information on the demo animals
        monkey2.setServiceCountry("United Kingdom"); // so that they appear in the report
        dog1.setTrainingStatus("Farm");
        monkey1.setTrainingStatus("Farm");
        monkey2.setTrainingStatus("Deceased");
        StatusReport();


    }
}
