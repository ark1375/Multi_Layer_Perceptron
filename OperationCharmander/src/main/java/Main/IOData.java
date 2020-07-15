package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * This class will read the .png images and turns their pixels into 2D arrays
 */
public class IOData {

    private String path = "src/main/java/Resources/";  //TODO: get dynamic path
    private String fileName = "2.png";
    private BufferedImage image;
    private int imageWidth = 28;    //image width, by default is 28 pixels
    private int imageHeight = 28;   //image height, by default is 28 pixels
    private double [][] binaryImage;   //image built from the actual image but the pixel color is binary, 0 means black, 1 means white.

    public IOData() {
        binaryImage = new double[imageWidth][imageHeight];
        preProcessing();
    }
    
    /**
     * first: read the image
     * then for every pixel in the image, gather rgb data,
     * then convert rgb data to binary data, just black and white.
     */
    private void preProcessing(){
        for (int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
                image = readImage();    //read the image of the path and filename attribute.
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
    }

    private BufferedImage readImage() {
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
     * 
     * @param width Width of the image, for example 28 pixels
     * @param height Height of the image, for example 28 pixels
     */
    private void imageToMatrix(int width, int height){
        //TODO: complete it soon.
    }
}
