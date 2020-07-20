package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

/*
 * This class will read the .png images and turns their pixels into 2D arrays
 */
public class IOData {

	private String trainPath = "src/main/java/Resources/train/"; //path of training samples
	private String testPath = "src/main/java/Resources/test/";	//path of test samples
	private String fileLabel;
	private int imageWidth = 28;    //image width, by default is 28 pixels
	private int imageHeight = 28;   //image height, by default is 28 pixels
	private ArrayList<ArrayList<double[]>> allData = new ArrayList<>(); //all images, around 60,000
	//10 lists to hold each type of image. then select randomly from these
	//every select round, is a collection of 10 images.
	//every of these 10 lists contains about 6000 images.
	private ArrayList<BinaryImage> no0 = new ArrayList<>(); //all number 0
	private ArrayList<BinaryImage> no1 = new ArrayList<>(); //all number 1
	private ArrayList<BinaryImage> no2 = new ArrayList<>(); //all number 2
	private ArrayList<BinaryImage> no3 = new ArrayList<>(); //all number 3
	private ArrayList<BinaryImage> no4 = new ArrayList<>(); //all number 4
	private ArrayList<BinaryImage> no5 = new ArrayList<>(); //all number 5
	private ArrayList<BinaryImage> no6 = new ArrayList<>(); //all number 6
	private ArrayList<BinaryImage> no7 = new ArrayList<>(); //all number 7
	private ArrayList<BinaryImage> no8 = new ArrayList<>(); //all number 8
	private ArrayList<BinaryImage> no9 = new ArrayList<>(); //all number 9

	public IOData(Boolean isTest) {
		if(!isTest)
			orderingImages(trainPath);
		else
			orderingImages(testPath);
		shuffleAllLists();
	}
    //TODO: this method will return a batch of images contains 10 numbers randomly from 0 to 9.
    //do not delete it!!!
//	public ArrayList<double[]> getBatchData() {
//		ArrayList<BinaryImage> imageList = new ArrayList<>();
//		ArrayList<double[]> imageData = new ArrayList<>();
//
//		imageList.add(no0.get(0));
//		no0.remove(0);
//		imageList.add(no1.get(0));
//		no1.remove(0);
//		imageList.add(no2.get(0));
//		no2.remove(0);
//		imageList.add(no3.get(0));
//		no3.remove(0);
//		imageList.add(no4.get(0));
//		no4.remove(0);
//		imageList.add(no5.get(0));
//		no5.remove(0);
//		imageList.add(no6.get(0));
//		no6.remove(0);
//		imageList.add(no7.get(0));
//		no7.remove(0);
//		imageList.add(no8.get(0));
//		no8.remove(0);
//		imageList.add(no9.get(0));
//		no9.remove(0);
//
//		Collections.shuffle(imageList);
////		imageData.add(imageList.get(0).getContinuousBinaryPixels());
////		imageData.add(imageList.get(0).getBinaryLabel());
//		return imageData;
//	}
    
    /**
     * 
     * @return Get All the data of train resources.<br>
     *  List (List([]))<br><br>From the most inner part:<br>
     *  <b>[]</b>: 1D array includes all the <i>binary pixels</i> of an image. every row separates by 28 elements. and also includes the <i>binary label</i>.<br>
     *  <b>List([])</b>: The inner list contains 2 arrays. first one is binary pixels array. the second one is binary label. Every element of this list is for <b>just 1 image</b>.<br>
     *  <b>List(List())</b>: this list contains all the images binary data.
     */
    public ArrayList<ArrayList<double[]>> getAllData(){
//        ArrayList<ArrayList<double[]>> allData = new ArrayList<>(); //this list contains all list of images.
        ArrayList<double[]> oneData = new ArrayList<>();    //this list contains information of just one image.
        ArrayList<BinaryImage> allImages = joinAll();   //now all images are in one list
        
        for (BinaryImage img : allImages){
            oneData.add(img.getContinuousBinaryPixels());
            oneData.add(img.getBinaryLabel());
            allData.add((ArrayList<double[]>) oneData.clone());
            oneData.clear();
        }
        return allData;
    }

    /**
     * Shuffles all the lists of various numbers.
     */
	private void shuffleAllLists() {
		//shuffle all the number lists:
		Collections.shuffle(no0);
		Collections.shuffle(no1);
		Collections.shuffle(no2);
		Collections.shuffle(no3);
		Collections.shuffle(no4);
		Collections.shuffle(no5);
		Collections.shuffle(no6);
		Collections.shuffle(no7);
		Collections.shuffle(no8);
		Collections.shuffle(no9);
	}
    /**
     * 
     * @return Returns the Array List of all joined numbers.
     */
    private ArrayList<BinaryImage> joinAll(){
        ArrayList<BinaryImage> temp = new ArrayList<>();
        temp.addAll(no0);
        temp.addAll(no1);
        temp.addAll(no2);
        temp.addAll(no3);
        temp.addAll(no4);
        temp.addAll(no5);
        temp.addAll(no6);
        temp.addAll(no7);
        temp.addAll(no8);
        temp.addAll(no9);
		Collections.shuffle(temp);
        return temp;
    }

	/**
	 * first: read the image then for every pixel in the image, gather rgb data,
	 * then convert rgb data to binary data, just black and white.
	 */
	private double[][] imgToMatrix(BufferedImage image) {
		double[][] binaryImage = new double[imageWidth][imageHeight];//image built from the actual image but the pixel color is binary, 0 means black, 1 means white.
		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
//                image = readImage(fileName);    //read the image of the path and filename attribute.
				double[] rgb = new double[4]; //the array that holds the pixel RGB raw data. length 4 means Red, Green, Blue, Transparency.
				image.getRaster().getPixel(j, i, rgb); //get the [i][j] pixel of the image and copy the rgb meta into the rgb[] array
				//initializing the binary matrix
				if (rgb[0] < 160) {
					if (rgb[1] < 160) {
						if (rgb[2] < 160) {
							binaryImage[i][j] = 0;
						} else {
							binaryImage[i][j] = 1;
						}
					} else {
						binaryImage[i][j] = 1;
					}
				} else {
					binaryImage[i][j] = 1;
				}
			}
		}
		return binaryImage;
	}

	/**
	 *
	 * @param fileName Read the image with given name. Path is default resources
	 * package.
	 * @return BufferedImage which contains RGB data of every pixel.
	 */
	private BufferedImage readImage(String path, String fileName) {
		File file = new File(path + fileName);
		try {
			BufferedImage image = ImageIO.read(file);
			return image;
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * This method is separate images from the directory to each specific array
	 * list.
	 */
	private void orderingImages(String path) {
		File folder = new File(path);
		File[] files = folder.listFiles();
		int j = 0;
		for (int i = 0; i < files.length; i++) {
			switch (j) {
				case 0:
					double[] label0 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
					no0.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label0));
					j++;
					break;
				case 1:
					double[] label1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
					no1.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label1));
					j++;
					break;
				case 2:
					double[] label2 = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
					no2.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label2));
					j++;
					break;
				case 3:
					double[] label3 = {0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
					no3.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label3));
					j++;
					break;
				case 4:
					double[] label4 = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
					no4.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label4));
					j++;
					break;
				case 5:
					double[] label5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
					no5.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label5));
					j++;
					break;
				case 6:
					double[] label6 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
					no6.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label6));
					j++;
					break;
				case 7:
					double[] label7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
					no7.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label7));
					j++;
					break;
				case 8:
					double[] label8 = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
					no8.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label8));
					j++;
					break;
				case 9:
					double[] label9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
					no9.add(new BinaryImage(j, imgToMatrix(readImage(path, files[i].getName())), label9));
					j = 0;
					break;
				default:
					j = 0;
			}
		}
	}
}
