/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizealgorithms.bll.algorithm.misc;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

/**
 *
 * @author Søren Spangsberg
 */
public class TowerOfHanoi extends GenericAlgorithm {

    public TowerOfHanoi() {
        super("Tower of Hanoi", "O(2^n) exponential algorithm", AlgorithmType.MISC);
    }

    @Override
    public void doWork() {
        
        int[] data = (int[]) super.getData();
        
        move(data[0],'A','B','C');
    }

    /**
     * 
     * @param n
     * @param a
     * @param b
     * @param c 
     */
    public void move(int n, char a, char b, char c) {
        if (n > 1) {
            move(n - 1, a, b, c);
        }
        System.out.println("Moves one disc from " + a + " to " + c);
        if (n > 1) {
            move(n - 1, b, c, a);
        }
    }
}
