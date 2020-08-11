public class Dog {

    // instance variables
	private String name;
	private String type;
	private String breed;
	private String topTrick;
	

    // constructor
	public Dog(String type, String breed, String name) {
		this.type = type; // store args as instance vars / properties
		this.breed = breed;
		this.name = name;
	}

    // methods
	public void setTopTrick(String trick) {
		if(!trick.isEmpty()) { // if the trick isn't empty, use it
			this.topTrick = trick;	
		} else {
			throw new Error("Trick cannot be empty");
		}
		
	}

    // method used to print Dog information
    public String toString() {
        String temp = "\nDOG DATA\n" + name + " is a " + breed +
                ", a " + type + " dog. \nThe top trick is : " +
                topTrick + ".";
        return temp;
    }

}
