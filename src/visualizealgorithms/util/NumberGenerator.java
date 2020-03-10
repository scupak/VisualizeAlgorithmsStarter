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
public class NumberGenerator {
    
    private static NumberGenerator _instance = null;
    
    
    private NumberGenerator() {
        
    }
    
    public static NumberGenerator getInstance() {
        if (_instance == null)
            _instance = new NumberGenerator();
        
        return _instance;
    }
    
    public int[] generateRandomNumbers(int size, int multiplier) {
        int[] randomNumbers = new int[size];
        Random r = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(size * multiplier);
            //System.out.print(randomNumbers[i] + ",");
        }
        return randomNumbers;
    }
    
}
