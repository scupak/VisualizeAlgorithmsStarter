package visualizealgorithms.bll.algorithm.sorting;

import visualizealgorithms.bll.algorithm.GenericAlgorithm;

/**
 *
 * @author Søren Spangsberg
 */
public class BubbleSort extends GenericAlgorithm {

    /**
     * Constructor that calls super class with basic info
     */
    public BubbleSort() {
        super("Bubble Sort", "Simple O(N^2) sorting algorithm");
    }

    /**
     * The actual algorithm implementation
     */
    @Override
    public void doWork() {

        int[] arr = (int[]) super.getData();

        //FIXME: implement algorithm...
    }
}
