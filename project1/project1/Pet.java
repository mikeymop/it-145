package project1;

import java.util.Scanner;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Pet {
	   private String petType;
	   private String petName;
	   private int petAge;
	   private Map<Pet, Integer> dogSpace; // contains the Pet and days it is staying
	   private Map<Pet, Integer> catSpace; // same but for cats
	   
	   private int daysStay;
	   public double amountDue;


	   /**
	    * Pet, base class for Dog and Cat
	    * @param String name - Name of the Pet
	    * @param int age - Age of the Pet
	    * @param String type - Cat | Dog
	    */
	   public Pet(String name, int age, String type) {
	      this.petName = name;
	      this.petAge = age;
	      this.petType = type;
	      this.dogSpace = new HashMap<Pet, Integer>(); // use a hashmap to keep track of pets in the shelter
	      this.catSpace = new HashMap<Pet, Integer>(); // the Pet object is the key, and the days they are staying is the value.
	   }

	   public void checkIn(Pet pet) {
		   Scanner in = new Scanner(System.in);
		   System.out.println("How many days will your " + this.petType + " be staying?");
		   int days = (int) in.nextInt();
		   this.daysStay = days;

		   switch(this.petType) {
		   case "Dog":
			   if(days > 1) {
				   System.out.println("Do you require grooming services?");
				   String needsGrooming = in.next();
				   boolean grooming;
				   if(needsGrooming.equals("yes") || needsGrooming.equals("y")) {
					   System.out.println("We will groom your dog...\n");
					   grooming = true;
				   }
				   else {
					   grooming = false;
				   }
				   this.checkInDog((Dog) pet, days, grooming); // handle the special dog cases
			   }
			   else {
				   this.checkInDog((Dog) pet, days, false);
			   }
			   break;
		   case "Cat":
			   if(this.catSpace.size() < 12) {
				   this.catSpace.put(pet, days);
			   }
			   break;
		   default: // Throw an exception if a pet other than a Cat | Dog is booked.
			   in.close(); // Close the scanner before exiting.
			   throw new RuntimeException("Sorry, we only accept cats and dogs");
		   }
		   in.close(); // Close the scanner when there is no exceptin thrown.
	   }
	   
	   /**
	    * Contains extra steps for checking in a dog.
	    * @param pet - The dog object.
	    * @param days - Number of days staying.
	    * @param grooming - Whether or not the dog needs grooming.
	    */
	   private void checkInDog(Dog pet, int days, boolean grooming) {
		   pet.setGrooming(grooming);
		   
		   try {
			   if(this.dogSpace.size() < 30) { // Enforce the maximum of 30 dogs in the shelter.
				   this.dogSpace.put(pet, days);
				   pet.dogSpaceNbr = this.dogSpace.size() + 1;
				   pet.setDaysStay(days);
			   }   
		   }
		   catch (Exception e) { // For some Map objects, calling size() on an empty collection can throw an error.
			   System.out.println("You're our first visitor!");
			   System.out.print(pet);
			   this.dogSpace.put(pet, days);
			   pet.dogSpaceNbr = 1;
		   }
		   System.out.println("" + pet.getPetName() + " will miss you, but is in good hands.");		   
	   }

	   /**
	    * Check out the desired Pet and calculate how much is owed for the boarding.
	    * @param pet - The pet you wish the check-out.
	    * @return amountDue - The amount of money owed for the boarding.
	    */
	   public double checkOut(Pet pet) {
		   double fee;

		   if(pet.getPetType() == "Dog") {
			   double groomingfee = 0.0;
			   Dog animal = (Dog) pet;
			   int days = this.dogSpace.remove(pet);
			   double weight = animal.getDogWeight();
			   if(weight < 20) {
				   fee = 24.00;
				   if(animal.getGrooming()) {
					   groomingfee = 19.95;   
				   }
			   } else if (weight > 20 && weight < 30) {
				   fee = 29.00;
				   if(animal.getGrooming()) {
					   groomingfee = 24.95;
				   }
			   } else {
				   fee = 34.00;
				   if(animal.getGrooming()) {
					   groomingfee = 29.95;
				   }
			   }
			   System.out.println("Fee Schedule:\n Boarding Fee: " + (fee*days) + "\nGrooming Fee: " + groomingfee);
			   animal.amountDue = (fee * days) + groomingfee;
			   return animal.amountDue;
		   }
		   else {
			   int days = this.catSpace.remove(pet);
			   fee = 18.00;
			   pet.amountDue = (fee * days);
			   return pet.amountDue;
		   }
	   }

	   public Pet getPet(Pet pet) { // Not sure why we need this.
		   return pet;
	   }

	   public Pet createPet(String name, int age, String type) {
		   switch(type) {
		   case "Dog":
			   return new Dog(name, age);
		   case "Cat":
			   return new Pet(name, age, "Cat"); // I have implemented the dog class, not the cat.
		   default:
			   throw new Error("Only Dogs and Cats can stay at this facility.");
		   }
	   }

	   /**
	    * Asks the user to fill in all of the attributes of a pet. Saves them directly to the object it was called on.
	    * @param pet - The pet you wish to update information on.
	    */
	   public void updatePet(Pet pet) {
		   Scanner in = new Scanner(System.in);
		   System.out.println("What is the pets new name?");
		   pet.setPetName(in.next());
		   System.out.println("What is the pets age?");
		   pet.setPetAge(in.nextInt());
		   System.out.println("What type of animal is your pet?");
		   pet.setPetType(in.next());
		   in.close();
	   }

	   public String getPetName() {
	      return this.petName;
	   }

	   public int getPetAge() {
	      return this.petAge;
	   }

	   public String getPetType() {
	      return this.petType;
	   }

	   public void setPetName(String name) {
	      this.petName = name;
	   }

	   public void setPetAge(int age) {
	      this.petAge = age;
	   }

	   public void setPetType(String type) {
		  switch(type) { // while a switch is extra here, it will make it easier to add other pets.
		  case "Dog":
			  this.petType = type;
			  break;
		  case "Cat":
			  this.petType = type;
			  break;
		  }
	   }
	   
	   public void setDaysStay(int days) {
		   this.daysStay = days;
	   }
	}

