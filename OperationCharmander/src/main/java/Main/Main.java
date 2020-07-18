
package Main;

import MLP.MLP;
import MLP.Sig_MLP;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.lang.Math;
import java.util.ArrayList;

//class vector{
        
//        public double x = 0;
//        public double y = 0;
//        
//        vector (double x , double y){
//            this.x = x;
//            this.y = y;
//        }
//        
//        vector(){}
//        
//        public vector normal(){
//            if (x == 0 && y ==0)
//                return new vector(0,0);
//            else {
//                vector v = new vector();
//                v.x = x / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//                v.y = y / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//                
//                return v;
//            }  
//                
//        }
//        
//        @Override
//        public String toString(){return x + "," + y;}
//        
//    }
//
public class Main {
//
    public static void main(String[] args) throws IOException {
//        
//        
//        BufferedImage img = ImageIO.read(new File("E:\\Projects\\Projects 2020\\ANN-Final Project\\op-charmander\\Data\\train\\allow.png"));
//        int pix[][]= new int[img.getWidth()][img.getHeight()];
//        
//        for (int i=0 ; i < img.getWidth() ; i++)
//            for (int j =0 ; j < img.getHeight() ; j++)
//                pix[i][j]= img.getRGB(i,j);
//        
////        for (int i=0 ; i < img.getWidth() ; i++)
////            for (int j =0 ; j < img.getHeight() ; j++)
////                System.out.println (pix[i][j]);
//        
//        double sumx = 0;
//        double sumy = 0;
//
//        for (int i=0 ; i < img.getWidth() ; i++){
//            for (int j =0 ; j < img.getHeight() ; j++){
//                
//                if ( pix[i][j] == -1 ){
//                    vector vec = new vector(i-14 , j-14);
//                    vector ven = vec.normal();
//                    sumx += ven.x;
//                    sumy += ven.y;
//                }
//            
//            }    
//        }
//        
//        vector vec = new vector(sumx,sumy);
//        vector vecn = vec.normal();
//        System.out.println(vecn);
//        
//        double[][][] n = new double [3][3][5];
//        System.out.println(n[0][0].length);
        
          Sig_MLP m;
          m = new Sig_MLP("name");
          ArrayList<double[]> dataset = new ArrayList<>();
          double[] d1 = {0.5,0.3,0.4,1,1};
          dataset.add(d1);
//public boolean init(int numberOfHiddenLayers, int hiddenLayerDimension, int outPutDimension, int inputDimension, double learningRate)
          boolean b = m.init(dataset, 1,2,2,3,0.25);
          double[][] er = m.backpropogation(d1);
          for (double[] o1 : er)
              for (double o : o1)
                System.out.println(o + " , ");


    }
    
}
