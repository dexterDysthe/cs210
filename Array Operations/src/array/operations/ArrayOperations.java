/*
 * Dexter Dysthe
 * Csc 210 - 02
 * 04 October 2016
 * Arrays Project
 */

/**
 * This program will create an Array, "NumberSetArray", with 10,000 type int indexes. 
 * Each index will take on a random value from 0 to 200. The program will run 8
 * loops total; such loops will be for loops all with the same conditions. 
 */
package array.operations;

import java.util.Random;

public class ArrayOperations {


    public static void main(String[] args) {
        
        // Creation of Random class and the array "NumberSetArray"
        Random rnd = new Random();
        int[] NumberSetArray = new int[10000];

        /* Loop that sets each index of the array equal to the next random integer 
        *  from 0 - 200.
        */
        for (int k = 0; k < NumberSetArray.length; k++) {
            /* k = 0 is the 1st index of the array. 'k' will then be incremented
            *  until it become equal to the length of the array (10,000), which then
            *  falsifies the Boolean expression within the loop.
            */ 
            NumberSetArray[k] = rnd.nextInt(201); 
        }

        
        
        // Declaration and initialization of Sum1 variable
        double Sum1 = 0.0;
        // Loop that will compute the sum of all the elements in the array
        for (int k = 0; k < NumberSetArray.length; k++) {
            
            // Implementation of addition operator to concatenate value of Sum1.
            Sum1 += NumberSetArray[k];
        }
        // Print statement displaying final value of Sum1.
        System.out.println("The sum of the array is: " + Sum1 + ".");
        System.out.println(" Length: "+ NumberSetArray.length);

        

        // Declaration and initialization of Average and Sum2 variables.
        double Average = 0;
        double Sum2 = 0.0;
        // Loop to compute average of the array.
        for (int k = 0; k < NumberSetArray.length; k++) {
           
            Sum2 += NumberSetArray[k];
            // Computation of Average through concatenation process. 
            Average = Sum2 / NumberSetArray.length;
        }
        // Print statement displaying final value of Average. 
        System.out.println("The average value of the array is: " + Average + ".");
        
        
        
        // Declaration and initialization of Min and MinIndex variables. 
        int Min = NumberSetArray[0];
        int MinIndex = 0;
        // Loop to find the minimum value of the array, and the index where it occurs.
        for (int k = 0; k < NumberSetArray.length; k++) {
           
            /* If body to carry out only when the value of some index 'k' is less
            * than the initialized value of the Min variable. Upon this condition
            * being met, the 'k' index's value will be assigned to the Min variable
            * and the index where it occurs will be assinged to to the MinIndex variable.
            */        
            if (NumberSetArray[k] < Min) {
                Min = NumberSetArray[k];
                MinIndex = k;
            }
        }
        // Print statement displaying the minimum value of the array and its index.
        System.out.println("The minimum value of the array is " + Min + ", and"
                + " its index is " + MinIndex + ".");
        

        
        // Declaration and initialization of Max and MaxIndex variables. 
        int Max = NumberSetArray[0];
        int MaxIndex = 0;
        // Loop to find the maximum value of the array, and the index where it occurs.
        for (int k = 0; k < NumberSetArray.length; k++) {
            
            /* If body to carry out only when the value of some index 'k' is greater
            * than the initialized value of the Max variable. Upon this condition
            * being met, the 'k' index's value will be assigned to the Max variable
            * and the index where it occurs will be assinged to to the MaxIndex variable.
            */ 
            if (NumberSetArray[k] > Max) {
                Max = NumberSetArray[k];
                MaxIndex = k;
            }
        }
        // Print statement displaying the maximum value of the array and its index.
        System.out.println("The maximum value of the array is " + Max + ", and"
                + " its index is " + MaxIndex + ".");
        
        

        // Declaration and initiazliation of EvenNumberCount and OddNumberCount variables.
        int EvenNumberCount1 = 0;
        int OddNumberCount1 = 0;
        // Loop to find, and count the amount of, even and odd numbers within the array. 
        for (int k = 0; k < NumberSetArray.length; k++) {
            
            /* If body using modulus operator to check if the value of index k is
            *  completely divisible by 2.
            */        
            if (NumberSetArray[k] % 2 == 0) {
                // If condtions are met, increment EvenNumberCount variable.
                EvenNumberCount1++;

            } else if (NumberSetArray[k] % 2 == 1) {
                // If conditions are met, increment OddNumberCount variable.
                OddNumberCount1++;
            }
        }
        // Print statements displaying amount of even and odd numbers in the array.
        System.out.println("There are " + EvenNumberCount1 + " even numbers in "
                + "the array.");
        
        System.out.println("There are " + OddNumberCount1 + " odd numbers in "
                + "the array.");
        
        
        
        // Declaration and initialization of EvenNumbersSum variable.
        int EvenNumbersSum = 0;
        // Loop to compute the sum of the even numbers.
        for (int k = 0; k < NumberSetArray.length; k++) {
            
            
            if (NumberSetArray[k] % 2 == 0) {
                /* Value of EvenNumbersSum is set initially to 0 then adding the 
                *  value of the 1st index, 'k'. This is then stored in the EvenNumbersSum
                *  variable, as the loop then increments k, to reveal the 2nd index's
                *  value. This is then summed with the value of the EvenNumbersSum
                *  to create a new value for the variable. This loop repeates while k < 201.
                */
                EvenNumbersSum = EvenNumbersSum + NumberSetArray[k];
            
            } 
        }
        // Print statement displaying the sum of the even numbers.
        System.out.println("The sum of the even numbers in the array is: "
                + EvenNumbersSum + ".");
        
        
        
        //  // Declaration and initialization of OddNumbersSum variable.
        int OddNumbersSum = 0;
        for (int k = 0; k < NumberSetArray.length; k++){
            
            if (NumberSetArray[k] % 2 == 1) {
                /* Value of OddNumbersSum is set initially to 0 then adding the 
                *  value of the 1st index, 'k'. This is then stored in the OddNumbersSum
                *  variable, as the loop then increments k, to reveal the 2nd index's
                *  value. This is then summed with the value of the OddNumbersSum
                *  to create a new value for the variable. This loop repeates while k < 201.
                */
                OddNumbersSum = OddNumbersSum + NumberSetArray[k];
                
            }
        }
        // Print statement displaying the sum of the odd numbers.
        System.out.println("The sum of the odd numbers in the array is: "
                + OddNumbersSum + ".");

    }

}
