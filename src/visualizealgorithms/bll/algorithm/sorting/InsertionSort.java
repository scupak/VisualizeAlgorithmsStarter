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

        Comparable[] data = (Comparable[]) super.getData(); 
        
        doInsertionSort(data);
    }
    
    /**
     * 
     */
    private void doInsertionSort(Comparable[] data) {
        
        //algorithm implementation...
        for (int i = 1; i < data.length; i++) {
            
            Comparable tmp = data[i];
            //int tmp = arr[i]; // move an element to a temporary location to create a
            int holeIndex = i; // hole in the list
            
            //O(N^2)
            while (holeIndex > 0 && data[holeIndex - 1].compareTo(tmp) == 1)
            {
                data[holeIndex] = data[holeIndex - 1];
                holeIndex--;                
            }
            data[holeIndex] = tmp; // insert the temporary element into the hole.
        } 
    }
}
