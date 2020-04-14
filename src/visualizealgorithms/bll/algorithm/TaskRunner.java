
package visualizealgorithms.bll.algorithm;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import visualizealgorithms.gui.HoveredThresholdNode;

/**
 *
 * @author Søren Spangsberg
 */
public class TaskRunner {
    
    /**
     * 
     * @param algorithm
     * @param data
     * @return 
     */
    public long runTask(IAlgorithm algorithm, Comparable[] data) {

        algorithm.setData(data);
        
        long startTime = System.currentTimeMillis();
        algorithm.doWork();
        long durationInMillis = (System.currentTimeMillis() - startTime);
        
        return durationInMillis;
    }
}
