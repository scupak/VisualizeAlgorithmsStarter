/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizealgorithms.util;

import java.util.Random;

/**
 *
 * @author Søren Spangsberg
 */
public class DataGenerator {
    
    private static DataGenerator _instance = null;
    
    
    private DataGenerator() {
        
    }
    
    public static DataGenerator getInstance() {
        if (_instance == null)
            _instance = new DataGenerator();
        
        return _instance;
    }
    
    /**
     * 
     * @param size
     * @param multiplier
     * @return Array of Integers (Comparable)
     */
    public Comparable[] generateRandomIntegers(int size, int multiplier) {
        Integer[] randomNumbers = new Integer[size];
        Random r = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(size * multiplier);
            //System.out.print(randomNumbers[i] + ",");
        }
        return randomNumbers;
    }
}
