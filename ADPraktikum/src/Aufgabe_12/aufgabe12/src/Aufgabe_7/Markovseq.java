package Aufgabe_7;



/**
 * The {@code markovseq} class provides static methods for generating a random sequence bases on a Markov system.
 *  @author Michael K�hler-Bussmeier
 */

public class Markovseq {

    
 public static void main(String[] args) {

     int numberOfGeneratedBits = 10;
     if (args.length == 1) {
	 numberOfGeneratedBits = Integer.parseInt(args[0]);
     }


     double matrix[][] = {
	 { 0.00, 0.50, 0.50},
	 { 0.30, 0.30, 0.70},
	 { 0.20, 0.20, 0.50}
     };

     /*
     double matrix1[][] = {
	 { 0.25, 0.25, 0.25, 0.25 }, 
	 { 0.25, 0.25, 0.25, 0.25 }, 
	 { 0.25, 0.25, 0.25, 0.25 }, 
	 { 0.25, 0.25, 0.25, 0.25 }

     };
     */
     /*
     double matrix2[][] = {
	 { 0.0, 1.0, 0.0, 0.0 }, 
	 { 0.0, 0.0, 1.0, 0.0 },
	 { 0.0, 0.0, 0.0, 1.0 },
	 { 1.0, 0.0, 0.0, 0.0 } 
     };
     */

     // deterministischer Startzustand
     int state = 0;

     for (int i = 0; i < numberOfGeneratedBits; i++) {
	 // Moore-Ausgabe: State 
	 System.out.print(state);
	 // next state
	 state = StdRandom.discrete(matrix[state]);
     }
     System.out.println("");
 }//end-of-main

}
