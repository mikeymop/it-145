package project1;

public class Cat extends Pet {
	private int catSpaceNbr; // The number space the cat is in.
	
    public Cat(String name, int age) { // automatically declares a pet of type Cat
        super(name, age, "Cat"); // Calls the constructor of the parent class
    }
    
    public int getCatSpace() {
    	return this.catSpaceNbr;
    }
    
    public void setCatSpace(int number) {
    	this.catSpaceNbr = number;
    }
}
