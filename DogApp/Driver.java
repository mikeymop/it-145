
public class Driver {
	
	public static void main(String args[]) {
		Dog dog = new Dog("cattle herding dog", "Pembroke Welsh Corgi", "Java");
		Corgi corgi = new Corgi("small fluffy dog", "Corgi", "Cici", 10, 2); // creates the Dog and Corgi

		dog.setTopTrick("ringing the bell to go outside"); // sets the dogs trick
		
		System.out.println(dog.toString());
		System.out.println(corgi.toString());
	}

}
