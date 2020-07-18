package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/*
 * This class will read the .png images and turns their pixels into 2D arrays
 */
public class IOData {

    private String path = "src/main/java/Resources/train/"; //path of training samples
    private String fileLabel;
    private int imageWidth = 28;    //image width, by default is 28 pixels
    private int imageHeight = 28;   //image height, by default is 28 pixels
    private ArrayList<BufferedImage> trainImages = new ArrayList<>(); //all images, around 60,000
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

    public IOData() { 
        //TODO: call the shuffle() method and select 1 from all the lists. then remove and return it.
    }
    
    /**
     * first: read the image
     * then for every pixel in the image, gather rgb data,
     * then convert rgb data to binary data, just black and white.
     */
    private double [][] imgToMatrix(BufferedImage image){
        double [][] binaryImage = new double[imageWidth][imageHeight];//image built from the actual image but the pixel color is binary, 0 means black, 1 means white.
        for (int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
//                image = readImage(fileName);    //read the image of the path and filename attribute.
                double[] rgb = new double[4]; //the array that holds the pixel rgb raw data.
                image.getRaster().getPixel(j, i, rgb); //get the [i][j] pixel of the image and copy the rgb meta into the rgb[] array
                //initializing the binary matrix
                if(rgb[0] < 160){
                    if(rgb[1] < 160){
                        if(rgb[2] < 160){
                            binaryImage[i][j] = 0;
                        }
                        else
                            binaryImage[i][j] = 1;
                    }
                    else
                        binaryImage[i][j] = 1;
                }
                else
                    binaryImage[i][j] = 1;
            }
        }
        return binaryImage;
    }


     private BufferedImage readImage(String fileName) {
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
     * This method is separate images from the directory to each specific array list.
     */
    private void classificationImages(String path){
        File folder = new File(path);
        File[] files = folder.listFiles();
        int j = 0;
        for(int i = 0; i < files.length; i++){
            switch (j){
                case 0:
                    no0.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 1:
                    no1.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 2:
                    no2.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 3:
                    no3.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 4:
                    no4.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 5:
                    no5.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 6:
                    no6.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 7:
                    no7.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 8:
                    no8.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j++;
                    break;
                case 9:
                    no9.add(new BinaryImage(j, imgToMatrix(readImage(files[i].getName()))));
                    j = 0;
                    break;
                default:
                    j = 0;
            }
        }
    }
}
