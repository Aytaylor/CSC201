import java.util.Scanner;
import java.util.Random;

/*
 * Problem: Display all closest pairs of pointArray with the same minimum distance. This is a revision of Listing 8.3 "FindNearestpointArray.java"
 * 
 * Pseudo:
 * Create Scanner object
 * PROMPT: User enters N number of pointArray
 * PROMPT: User enters N pairs of pointArray as integers
 * Store pointArray into a 2-D array that is [N][2] size.
 * 
 * METHOD: Calculate and return the distance value between two pointArray
 * 		formula: distance = squareroot(x2-x1)squared + (y2 + y1)squared
 * 
 * after finding shortest distance, rerun the loop
 * 		if distance = shortest distance, then print points
 * print shortest distance value
 * 
 */
public class AllClosestPairs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    System.out.print("Enter the number of points: ");
	    int nPoints = input.nextInt();
	    //initialize pointArray array
	    double[][] pointArray = new double[nPoints][2];
	    
	    System.out.print("Do you want the array automatically filled with random integers? Y/N: " );
	    String ans = input.next();
	    System.out.println(ans);
	    if (ans.equals("N") || ans.equals("n")) {
	    	//create manual array
		    System.out.print("Enter " + nPoints + " points with a space between the numbers: ");
		    for (int i = 0; i < pointArray.length; i++) {
		      pointArray[i][0] = input.nextDouble();
		      pointArray[i][1] = input.nextDouble();
		    }
	
	    }
	    else {
	    	//create random array
	    	Random rand = new Random();
	    	int max = 10;
	    	int min = -10;
	    	System.out.println("Generating array of points between " + min + " and " + max + "...");
	    	for (int i = 0; i < pointArray.length; i++) {
	    		pointArray[i][0] = rand.nextInt((max - min) + 1) + min;
	    		pointArray[i][1] = rand.nextInt((max - min) + 1) + min;
	    	}
	    }
	    
	     // p1 and p2 are the indices in the pointArray' array
	    int p1 = 0, p2 = 1; // Initial two pointArray 
	    
	    //run calcDistance method and store distance
	    double shortestDistance = calcDistance(pointArray[p1][0], pointArray[p1][1], pointArray[p2][0], pointArray[p2][1]);
	 
	    // Compute distance for every combination of points in pointArray
	    for (int i = 0; i < pointArray.length; i++) { 
	      for (int j = i + 1; j < pointArray.length; j++) { 
	        double distance = calcDistance(pointArray[i][0], pointArray[i][1], pointArray[j][0], pointArray[j][1]);
	         if (shortestDistance > distance) { 
	        	 //store pointArray that are the shortest distance
	        	 p1 = i; 
	        	 p2 = j;
	        	 shortestDistance = distance;
	         }
	      }
	    }
	    
	    //iterate through entire array once more, now that shortest distance is known...
	    for (int i = 0; i < pointArray.length; i++) { 
		      for (int j = i + 1; j < pointArray.length; j++) { 
		        double distance = calcDistance(pointArray[i][0], pointArray[i][1], pointArray[j][0], pointArray[j][1]);
		         if (distance == shortestDistance) { 
		        	 // Display result 
		        	 System.out.println("The closest two points are " + "(" + pointArray[i][0] + ", " + pointArray[i][1] + ") and (" + pointArray[j][0] + ", " + pointArray[j][1] + ")");
		         }
		      }
		 }
	    System.out.println("The shortest distance between two points is: " + shortestDistance);
	  }
	
	  //Compute the distance between two pointArray (x1, y1) and (x2, y2)
	  public static double calcDistance(double x1, double y1, double x2, double y2) {
		  double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		  return dist;
	  }	
}
