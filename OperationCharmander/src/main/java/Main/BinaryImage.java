package Main;

import java.util.ArrayList;

public class BinaryImage {

	private double[][] binaryPixels;   //the matrix of pixels, if pixel color is white (255, 255, 255) then it's 1, and if it's black (0,0,0) then the number is 0;
	private double[][] rgbPixels;		//the matrix of RGB pixels of every pixel. for now it's not used & initialized.
	private int label;              
	private double[] binaryLabel;   //binary array that represents the label of the image. the length is 10 and only 1 element is 1. For example, 0 is [1 0 0 0 0 0 0 0 0 0] and 1 is [0 1 0 0 0 0 0 0 0 0].

	public BinaryImage(int label, double[][] binaryMatrix, double[] binaryLabel) {
		this.label = label;
		this.binaryLabel = binaryLabel;
		setBinaryPixels(binaryMatrix);
	}

    /**
     * 
     * @param matrix Sets the binary pixel attribute.<br>
     * This matrix contains binary value of pixels in the image which are 0 and 1.
     */
	public void setBinaryPixels(double[][] matrix) {
		this.binaryPixels = matrix;
	}
    
    /**
     * 
     * @return Binary Pixels of image, which 0 represents black pixel and 1 represents white.
     */
	public double[][] getBinaryPixels() {
		return this.binaryPixels;
	}

    /**
     * 
     * @return A binary array that represents the label of the image. the length is 10 and only 1 element is 1.<br>
     * For example, 0 is [1 0 0 0 0 0 0 0 0 0] and 1 is [0 1 0 0 0 0 0 0 0 0].
     */
	public double[] getBinaryLabel() {
		return this.binaryLabel;
	}

    /**
     * 
     * @return Array contains of width * height elements. width and height of the image.<br>
     *  This array is 1D version of the binary pixel array.
     */
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
