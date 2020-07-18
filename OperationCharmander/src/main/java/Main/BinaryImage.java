package Main;

import java.util.ArrayList;

public class BinaryImage {
    private double [][] binaryPixels;   //the matrix of pixels, if pixel color is white (255, 255, 255) then it's 1, and if it's black (0,0,0) then the number is 0;
    private double [][] rgbPixels;
    private ArrayList<Double[]> binaryImage = new ArrayList<>();
    private int label;
    private double[] binaryLabel;
    
    public BinaryImage(int label, double [][] binaryMatrix){
        this.label = label;
        binaryLabel = new double[10];
        setBinaryPixels(binaryMatrix);
    }
    
    public void setBinaryPixels(double [][] matrix){
        this.binaryPixels = matrix;
    }
}
