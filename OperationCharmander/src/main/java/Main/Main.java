
package Main;


import MLP.MLP2;
import MLP.Sig_MLP;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        MLP2 mlp = new MLP2("Test");
        double[] d_tr = {1,1};
        double[] d_res = {1,0,1};
        ArrayList<ArrayList<double[]>> dat = new ArrayList<>();
        ArrayList<double[]> l = new ArrayList<>();
        l.add(d_tr);
        l.add(d_res);
        dat.add(l);
        
        double[][][] weights = {
                                    {{ 1, 1 } , {1 , 1}},
                                    {{ 1, 1  } , { 1, 1 } , { 1 , 1 }}
        };
//        
        double[][] bias = { {0 , 0} , {0 , 0 , 0} };
        int[] conf = {2,2,3};
        mlp.setConfigs(conf);
//        System.out.println(mlp.setWeights(weights));
        System.out.println(mlp.setBiases(bias));
        System.out.println(mlp.init(dat, dat, 0.25));
        mlp.print_weights();
  
//        mlp.init(l,2,, 2, 3, 2, 0.5, weights,bias) ;
//        
//        mlp.inititate_learning(0);
//        
//        mlp.print();

        
        
    }
    
}
