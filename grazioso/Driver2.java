import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Driver2 {
	
	private static RescueAnimal selectedAnimal;
	private static Map<String, ArrayList<RescueAnimal>> animals;
	
	public static Map<String, ArrayList<RescueAnimal>> PrepareStorage() {
		animals = new HashMap<String, ArrayList<RescueAnimal>>();
		animals.put("Greece", new ArrayList<RescueAnimal>());
		animals.put("Japan", new ArrayList<RescueAnimal>());
		animals.put("Madagascar", new ArrayList<RescueAnimal>());
		animals.put("Singapore", new ArrayList<RescueAnimal>());
		animals.put("South Korea", new ArrayList<RescueAnimal>());
		animals.put("Turkey", new ArrayList<RescueAnimal>());
		animals.put("United Kingdom", new ArrayList<RescueAnimal>());
		animals.put("United States", new ArrayList<RescueAnimal>());

		return animals;
	}
	
	public static Dog DisplayListOfDogs(ArrayList<Dog> list, String message) {
		System.out.print(message);
		
		for(int i = 0; i < list.size(); i++) {
			RescueAnimal animal = list.get(i);
			String trainingEnd = animal.getTrainingEnd().format(new Date());
			System.out.printf("%d) Name: %-15s, Date: %-15s Type: %-15s", i, animal.getName(), trainingEnd, animal.getType() );
		}
		
		Scanner scnr = new Scanner(System.in);
		System.out.print("Select a Rescue Animal from the list: ");
		Dog animal = list.get(scnr.nextInt());
		
		scnr.close();
		return animal;
	}
	
	public static Monkey DisplayListOfMonkeys(ArrayList<Monkey> list, String message) {
		System.out.print(message);
		
		for(int i = 0; i < list.size(); i++) {
			Monkey animal = list.get(i);
			String trainingEnd = animal.getTrainingEnd().format(new Date());
			System.out.printf("%d) Name: %-15s, Date: %-15s Type: %-15s", i, animal.getName(), trainingEnd, animal.getType() );
		}
		
		Scanner scnr = new Scanner(System.in);
		System.out.print("Select a Rescue Animal from the list: ");
		Monkey animal = list.get(scnr.nextInt());
		
		scnr.close();
		return animal;
	}
	
	public static void RequestAnimal(String country, String animalType ) {
		
		switch(country) {
			case "Greece":
			case "Japan":
			case "Madagascar":
			case "Singapore":
			case "South Korea":
			case "Turkey":
			case "United Kingdom":
			case "United States":
				break;
			default:
				throw new Error("We dont have any locations in this country.");
		}
		
		ArrayList<RescueAnimal> location = animals.get(country);
		ArrayList<Dog> validDogs = new ArrayList<Dog>();
		ArrayList<Monkey> validMonkeys = new ArrayList<Monkey>();
		
		for(int i = 0; i < location.size(); i++) {
			RescueAnimal animal = location.get(i);
			String type = animal.getType();
			
			switch(type) {
				case "Monkey": 
					if(animal.getTrainingStatus() == "In Service") {
						validMonkeys.add((Monkey) animal); break;	
					}
				case "Dog":
					if(animal.getTrainingStatus() == "In Service") {
						validDogs.add((Dog) animal); break;	
					}
			}
		}
		
		switch(animalType) {
			case "Monkey":
				Monkey selectedMonkey = DisplayListOfMonkeys(validMonkeys, "Available Monkeys in your location:\n");
				selectedAnimal = (RescueAnimal) selectedMonkey;
				
			case "Dog":
				Dog selectedDog = DisplayListOfDogs(validDogs, "Available Dogs in your location:\n");
				selectedAnimal = (RescueAnimal) selectedDog;
		}
		// get type customer requested
		// display list of animals from that array
		// prompt selection
		// update status of selection
	}

    public static void main(String[] args) {

        // Instance variables
    	animals = PrepareStorage(); // Prepares a Map who's keys are each valid country.

        Dog dog1 = new Dog("Spot", "male", 8, 86.7f, "2018-05-07", "United States"); // Create New Dog
        dog1.setTrainingLocation("United States");

        Monkey monkey1 = new Monkey("Mr. Chippers", "male", 15, 20.8f, "2019-07-09", "Madagascar"); // Create New Monkey
        monkey1.setTrainingLocation("Madagascar");

        animals.get("United States").add(dog1);
        animals.get("Madagascar").add(monkey1);

        // Method to process request for a rescue animal
        RequestAnimal("Madagascar", "Monkey");
        System.out.printf("You've selected: %s\n", selectedAnimal);
        ArrayList<RescueAnimal> animal = animals.get("Madagascar");
        for(int i=0; i < animals.size(); i++) {
        	if(animal.get(i).getName() == selectedAnimal.getName()) {
        		selectedAnimal = animal.remove(i);
        	}
        }
        System.out.printf("Congrats on adopting %s\n", selectedAnimal.getName());


        // Method(s) to update information on existing animals
        


        // Method to display matrix of animals based on location and status/training phase



        // Method to add animals


        // Method to out process animals for the farm or in-service placement



        // Method to display in-service animals



        // Process reports from in-service agencies reporting death/retirement



    }
}
