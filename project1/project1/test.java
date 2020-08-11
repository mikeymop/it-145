package project1;

public class test {
	public static void main(String args[]) { 
        Pet pet = new Pet("Spot", 12, "Dog" );
        System.out.println("Pet name is " + pet.getPetName());

        Dog dog = new Dog("Pepper", 15);
        System.out.println("" + dog.getPetName() + " is " + dog.getPetAge() + " years old.");
        
        Cat cat = new Cat("Bailey", 5);
        System.out.println("" + cat.getPetName() + " is " + cat.getPetAge() + " years old.");
        
        pet.checkIn(dog);
        
        double price = pet.checkOut(dog);
        System.out.println("You owe " + price + ".");
    }
}
