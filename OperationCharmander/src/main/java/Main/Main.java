
package Main;

import MLP.MLP;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        
        ArrayList<ArrayList<double[]>> data_train = new IOData(false).getAllData();
        ArrayList<ArrayList<double[]>> data_test = new IOData(true).getAllData();
        
        for (int i = 0 ; i < 28 ; i++){
            for (int j =0 ; j < 28 ; j++)
                System.out.print(data_train.get(200).get(0)[i*j] == 1 ? "*": " ");
            System.out.println("");
        }
        
        for (double d : data_train.get(200).get(1))
            System.out.println(d);


        
//        System.out.println();
//        
//        MLP network = new MLP("number rec");
//        
//        int[] config = { 784 , 20, 20, 10 };
//        network.setConfigs(config);
//        network.init(data_train, data_test, 0.35);
//        network.learn(600);
//        double[] res = network.run_network(data_test.get(30).get(0));
//        
//        for (double d: res)
//            System.out.println("res :" + d);
//        
//        for (double d: data_test.get(30).get(1))
//            System.out.println("res :" + d);
//        
//        
//       
//        System.out.println("evaluation:" + network.evaluate());
//        network.print_weights();
//        network.print_bias();
        
        
        
        
        
        
        
        
        

//        MLP2 mlp = new MLP2("Test");
//        double[] d_tr = {1,1};
//        double[] d_res = {1,0,1};
//        ArrayList<ArrayList<double[]>> dat = new ArrayList<>();
//        ArrayList<double[]> l = new ArrayList<>();
//        l.add(d_tr);
//        l.add(d_res);
//        dat.add(l);
//        
//        double[][][] weights = {
//                                    {{ 0.7, 0.4 } , {-0.2 , 0.3}},
//                                    {{ 0.5, 0.1  } , { 0.8, 0.5 } , { 0.6 , 0.4 }}
//        };
////        
//        double[][] bias = { {0.4 , 0.6} , {-0.3 , -0.4 , -0.2} };
//        int[] conf = {2,2,3};
//        
//        mlp.setConfigs(conf);
//        System.out.println(mlp.setWeights(weights));
//        System.out.println(mlp.setBiases(bias));
//        System.out.println(mlp.init(dat, dat, 0.25));
//        mlp.backpropogation(l);
//        mlp.print_weights();
//        mlp.print_bias();
        
//        mlp.print_weights();
  
//        mlp.init(l,2,, 2, 3, 2, 0.5, weights,bias) ;
//        
//        mlp.inititate_learning(0);
//        
//        mlp.print();

        
        
    }
    
}
