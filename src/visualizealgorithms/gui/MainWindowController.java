package visualizealgorithms.gui;

//Java imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import visualizealgorithms.bll.algorithm.AlgorithmType;

//Project imports
import visualizealgorithms.bll.algorithm.sorting.*;
import visualizealgorithms.bll.algorithm.IAlgorithm;
import visualizealgorithms.bll.algorithm.misc.TowerOfHanoi;
import visualizealgorithms.util.NumberGenerator;

/**
 *
 * @author Søren Spangsberg
 */
public class MainWindowController implements Initializable {

    @FXML
    private Button btnStartAction;
    @FXML
    private ListView lvAlgorithms;
    @FXML
    private AnchorPane rightAnchorPane;
    @FXML
    private TextField txtInputs;
    @FXML
    private ProgressBar pbProgress;

    private ArrayList<Integer> inputRanges = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //only enable button if user clicked an algorithm
        lvAlgorithms.setOnMouseClicked((event) -> {
            btnStartAction.setDisable(lvAlgorithms.getSelectionModel().getSelectedIndex() == -1);
        });

        initializeInputRanges();

        lvAlgorithms.getItems().add(new BubbleSort());
        lvAlgorithms.getItems().add(new InsertionSort());
        lvAlgorithms.getItems().add(new QuickSort());
        lvAlgorithms.getItems().add(new TowerOfHanoi());        
        //add other algorithms
    }
    
    
    /**
     * 
     */
    private void initializeInputRanges() {
        
        //default ranges
        inputRanges.add(1000);
        inputRanges.add(2000);
        inputRanges.add(4000);
        inputRanges.add(8000);
        inputRanges.add(16000);
        inputRanges.add(32000);
        inputRanges.add(64000);

        StringBuilder sb = new StringBuilder();

        for (Integer inputRange : inputRanges) {
            sb.append(inputRange + ";");
        }

        txtInputs.setText(sb.toString());
    }

    /**
     * Convenience method that measures the time it takes the algorithm to do
     * its work.
     *
     * @param algorithm
     * @param data
     * @param series
     */
    private void runTask(IAlgorithm algorithm, int[] data, XYChart.Series series) {

        long startTime = System.currentTimeMillis();

        algorithm.setData(data);
        algorithm.doWork();

        long endTime = System.currentTimeMillis();

        long durationInMillis = (endTime - startTime);

        Platform.runLater(() -> {
            series.getData().add(new XYChart.Data(data.length, durationInMillis));
            //create and setup XY plot
            XYChart.Data<Number, Number> xyPlot = new XYChart.Data(data.length, durationInMillis);
            xyPlot.setNode(new HoveredThresholdNode(data.length, durationInMillis)); //create tooltip in the chart
            series.getData().add(xyPlot);
        });
    }

    
    
    
    
    /**
     *
     * @return
     */
    private LineChart<?, ?> buildChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("# of elements");
        yAxis.setLabel("ms");

        //creating the chart
        LineChart<?, ?> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setLegendVisible(false);

        //setup chart to fit parent (anchor pane)
        AnchorPane.setTopAnchor(lineChart, 0d);
        AnchorPane.setLeftAnchor(lineChart, 0d);
        AnchorPane.setRightAnchor(lineChart, 0d);
        AnchorPane.setBottomAnchor(lineChart, 0d);

        return lineChart;
    }

    /**
     * Do action and build line chart with result
     *
     * @param event
     */
    @FXML
    private void handleStartAction(ActionEvent event) {
        IAlgorithm selectedAlgorithm = (IAlgorithm) lvAlgorithms.getSelectionModel().getSelectedItem();
        NumberGenerator ng = NumberGenerator.getInstance();
        getInputRangeFromGUI(); //get user defined input
        pbProgress.setProgress(0.0);

        if (selectedAlgorithm != null) {

            LineChart<?, ?> lineChart = buildChart();
            XYChart.Series series = new XYChart.Series();

            Thread t = new Thread(() -> {

                for (int i = 0; i < inputRanges.size(); i++) {
                    final double value = (float) (i + 1) / (float) inputRanges.size();
                    
                    if (selectedAlgorithm.getType() == AlgorithmType.SORTING)    
                        runTask(selectedAlgorithm, ng.generateRandomNumbers(inputRanges.get(i), 1), series);
                    else
                        runTask(selectedAlgorithm, new int[]{inputRanges.get(i)}, series);
                    
                    
                    Platform.runLater(() -> {
                        pbProgress.setProgress(value);
                    });

                    System.out.println(value);
                }
            });
            t.start();

            //add more runs...
            //Optimizations:
            //FIXME: print out precise execution times for each
            //FIXME: include support for sorting/searching BE-instances
            lineChart.getData().add(series);

            rightAnchorPane.getChildren().clear();
            rightAnchorPane.getChildren().add(lineChart);
        }
    }

    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
    }

    /**
     *
     */
    private void getInputRangeFromGUI() {
        String text = txtInputs.getText();

        if (text.trim().length() > 0) {
            this.inputRanges.clear();

            String[] inputRange = text.split(";");
            for (int i = 0; i < inputRange.length; i++) {
                this.inputRanges.add(Integer.parseInt(inputRange[i]));
            }
        }
    }
}
