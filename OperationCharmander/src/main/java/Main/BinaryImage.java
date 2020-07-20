package Main;

import java.util.ArrayList;

public class BinaryImage {

	private double[][] binaryPixels;   //the matrix of pixels, if pixel color is white (255, 255, 255) then it's 1, and if it's black (0,0,0) then the number is 0;
	private double[][] rgbPixels;		//the matrix of RGB pixels of every pixel. for now it's not used & initialized.
//    private ArrayList<double[]> binaryImage = new ArrayList<>();
	private int label;
	private double[] binaryLabel;

	public BinaryImage(int label, double[][] binaryMatrix, double[] binaryLabel) {
		this.label = label;
		this.binaryLabel = binaryLabel;
		setBinaryPixels(binaryMatrix);
	}

	public void setBinaryPixels(double[][] matrix) {
		this.binaryPixels = matrix;
	}

	public double[][] getBinaryPixels() {
		return this.binaryPixels;
	}

	public double[] getBinaryLabel() {
		return this.binaryLabel;
	}

	public double[] getContinuousBinaryPixels() {
		int w = this.binaryPixels.length;
		int h = this.binaryPixels[0].length;
		double[] continuousBinPixels = new double[w * h];
		int iterator = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				continuousBinPixels[iterator] = binaryPixels[i][j];
				iterator++;
			}
		}
		return continuousBinPixels;
	}
}
