package visualizealgorithms.bll.algorithm.sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

/**
 *
 * @author Søren Spangsberg
 */
public class InsertionSort extends GenericAlgorithm {

    /**
     * Constructor that calls super class with basic info
     */
    public InsertionSort() {
        super("InsertionSort", "Simple O(N^2) sorting algorithm", AlgorithmType.SORTING);
    }

    /**
     * The actual algorithm implementation
     */
    @Override
    public void doWork() {

        int[] arr = (int[]) super.getData();

        //algorithm implementation...
        for (int i = 1; i < arr.length; i++) {
            
            int tmp = arr[i]; // move an element to a temporary location to create a
            int holeIndex = i; // hole in the list
            
            //O(N^2)
            while (holeIndex > 0 && arr[holeIndex - 1] > tmp) // move the hole to the correct position 
            {
                arr[holeIndex] = arr[holeIndex - 1];
                holeIndex--;
            }
            arr[holeIndex] = tmp; // insert the temporary element into the hole.
        }
    }
}
