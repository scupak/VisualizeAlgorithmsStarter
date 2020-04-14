/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizealgorithms.util;

import java.util.Random;
import visualizealgorithms.be.User;

/**
 *
 * @author Søren Spangsberg
 */
public class DataGenerator {

    private static DataGenerator _instance = null;

    private DataGenerator() {

    }

    public static DataGenerator getInstance() {
        if (_instance == null) {
            _instance = new DataGenerator();
        }

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

    /**
     *
     * @return
     */
    public Comparable[] generateRandomBEs(int size) {
        User[] randomBEs = new User[size];
        Random r = new Random();

        for (int i = 0; i < randomBEs.length; i++) {
            randomBEs[i] = new User(getRandomCharacters(10), getRandomCharacters(10), r.nextInt(100));
            
        }
        return randomBEs;
    }

    /**
     * 
     * @param size
     * @return 
     */
    private String getRandomCharacters(int size) {

        Random r = new Random();
        char[] subset = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

        char buf[] = new char[size];
        
        for (int i = 0; i < buf.length; i++) {
            int index = r.nextInt(subset.length);
            buf[i] = subset[index];
        }

        return new String(buf);
    }
}
