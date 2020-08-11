import java.util.InputMismatchException;
import java.util.Scanner;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        
        final double squareFeetPerGallons = 350.0;
        
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's height
        while(wallHeight == 0) { // -1 is easy to check for, we repeat the loop until we change the value
        	System.out.println("Enter wall height (feet): ");
        	try {
        		wallHeight = scnr.nextDouble(); // errors on this line will throw an error
        		if(wallHeight == 0) {
        			System.out.println("Height cannot be 0...");
        			scnr.nextLine();
        			continue;
        		}
        	}
        	catch (InputMismatchException e) { // we catch the exception triggered if input cannot be stored in double
        		System.out.println("Error: Please enter a valid number..."); // our error message
        		scnr.nextLine(); // tells the scanner to move to the next line
        		continue; // jumps to the next iteration of the loop
        	}
        }

        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's width
        while(wallWidth == 0) { // repeat the same for the width
        	System.out.println("Enter wall width (feet): ");
        	try {
        		wallWidth = scnr.nextDouble();
        		if(wallWidth == 0) {
        			System.out.println("Width cannot be 0...");
        			scnr.nextLine();
        			continue;
        		}
        	}
        	catch (InputMismatchException e) {
        		System.out.println("Error: Please enter a valid number...");
        		scnr.nextLine();
        		continue;
        	}
        }

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth; // this was not multiplying the right two values
        System.out.printf("Wall area: %.1f square feet%n", wallArea); // %.1f prints the float to 1 decimal place

        // Calculate and output the amount of paint (in gallons) needed to paint the wall
        System.out.println("");
        gallonsPaintNeeded = wallArea/squareFeetPerGallons;
        System.out.printf("Paint needed: %.15f gallons.%n", gallonsPaintNeeded); // Match example and print float to 15 decimal places
        scnr.close();
    }
}
