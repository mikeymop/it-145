package project1;

public class Dog extends Pet {
	   public int dogSpaceNbr;
	   private double dogWeight;
	   private boolean grooming;

	   public Dog(String name, int age) { // automatically declares a pet of type Dog
	      super(name, age, "Dog"); // super is used to call the parent classes constructor
	   }

	   public double getDogWeight() {
	      return this.dogWeight;
	   }

	   public boolean getGrooming() {
	      return this.grooming;
	   }

	   public void setDogWeight(double weight) {
	      this.dogWeight = (double) weight; // casting a double here might be redundant, but it helps us to be sure
	   }									// we don't get at type error

	   public void setGrooming(boolean value) {
	      this.grooming = value;
	   }
}

