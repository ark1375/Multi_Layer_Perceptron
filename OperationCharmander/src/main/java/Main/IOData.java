package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * This class will read the .png images and turns their pixels into 2D arrays
 */
public class IOData {

    private String path = "src/main/java/Resources/2.png";  //TODO: get dynamic path
    private int[] rgb;  //the rgb code for one pixel
    private int imageWidth = 28;    //image width, by default is 28 pixels
    private int imageHeight = 28;   //image height, by default is 28 pixels

    public IOData() {
        rgb = new int[4];
        BufferedImage image2 = readImage();
        System.out.println(Arrays.toString(image2.getRaster().getPixel(12, 11, rgb)));
        System.err.println("Done");
    }
    
    private void preProcessing(int [][] image){
        
    }

    private BufferedImage readImage() {
        File file = new File(path);
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
