
package Main;

import MLP.MLP;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        
        int[] conf = {2,2,3};
        double[] d1_in = {1,-1};
        double[] d1_out = {1,1,0};
        
        double[][][] weights = {{{0.6,0.2} , {0.3 , -0.2}},
                                {{0.3,0.2} , {-0.1 , 0.2} , {-0.4 , 0.1}}
                                };
        
        double[][] bias = {{0,0} , {0.2,0.3,0.1}};
        
        ArrayList<double[]> data = new ArrayList<>();
        data.add(d1_in);
        data.add(d1_out);
        
        MLP net = new MLP("Tst");
        net.setConfigs(conf);
        net.setWeights(weights);
        net.setBiases(bias);
        net.setLearningRate(0.25);
        net.print_weights();
        net.print_bias();
        System.out.println("############################");
        net.backpropogation(data);
        net.print_weights();
        net.print_bias();
        
        
        
        
        
        
        
//        int[] configs = { 784, 10,10 ,10  };
//                
//        ArrayList<ArrayList<double[]>> data_train = new IOData(false).getAllData();
//        ArrayList<ArrayList<double[]>> data_test = new IOData(true).getAllData();
//        
////        
//        MLP network = new MLP("MLP-ANN");
//        network.init(data_train, data_test, configs ,0.25);
//        network.learn(100);
//        System.out.println(network.evaluate());
//        
//        double[] res = network.run_network(data_test.get(30).get(0));
//
//        for (double d: res)
//            System.out.println("res :" + d);
//
//        for (double d: data_test.get(30).get(1))
//            System.out.println("des :" + d);
 
        
        
    }
    
}
