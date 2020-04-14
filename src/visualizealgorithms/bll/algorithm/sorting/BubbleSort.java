package visualizealgorithms.bll.algorithm.sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
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
        super("Bubble Sort", "Simple O(N^2) sorting algorithm", AlgorithmType.SORTING);        
    }

    /**
     * The actual algorithm implementation
     */
    @Override
    public void doWork() {

        int[] arr = (int[]) super.getData();
        
         for (int i = 1; i < arr.length; i++) {
            
             for (int j = 0; j < arr.length -i; j++) {
                
                 if(arr[j] > arr[j + 1])
                 {
                     int tmp = arr[j];
                     arr[j] = arr[j +1];
                     arr[j + 1] = tmp;
                     
                 
                 
                 }
                 
             }
            
        }
         {
         
         
         
         }
        
        
        
        
        }
/*
        //algorithm implementation...
        for (int i = 1; i < arr.length; i++) // repeat sorting phase N – 1 times
        {
            for (int j = 0; j < arr.length - 1; j++) {

                {
                    if (arr[j] > arr[j + 1]) // compare elements pair-wise
                    {
                        int tmp = arr[j]; // swap element pair
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }*/
            }
        
    

