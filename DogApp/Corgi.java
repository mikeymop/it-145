public class Corgi extends Dog {

    // additional instance variables
	private int weight;
	private int age;

    // constructor
    public Corgi(String type, String breed, String name, int pounds, int years) {

        // invoke Dog class (super class) constructor
        super(type, breed, name);
        weight = pounds;
        age = years;
    }

    // mutator methods
    public void setAge(int years) {
    	if(years < 0) { // if appropriate, set the Corgi's age
    		throw new Error("The dog must be greater than 0 years old.");	
    	}
    	this.age = years;
    }
    
    public void setWeight(int weight) {
    	if(weight < 0) { // if appropriate, set the Corgis weight
    		throw new Error("The dog must weight more than 0lbs.");
    	}
    	this.weight = weight;
    }


    // override toString() method to include additional dog information
    @Override
    public String toString() {
        return (super.toString() + "\nThe Corgi is " + age +
                " years old and weighs " + weight + " pounds.");
    }

}
