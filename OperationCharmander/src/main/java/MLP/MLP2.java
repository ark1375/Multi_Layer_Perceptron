
package MLP;
/*issues , What if user sets configs, sets data and then try to set config again*/

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;


public class MLP2 {
    
    /*Configs is an int array that tells the class how to build the network. Each element represent number of neurons in each layer
    for example {a,b,c,d} is a 3 layer network with a-Dimension input 2 hidden layers with dimmension b and c and a d-dimension output
    */
    private int[] configs;                          
    private boolean isConfigSet = false;
    
    private double[][][] weights;                //Weights of the network
    private boolean isWeightsSet = false;
    
    private double[][] bias;
    private boolean isBiasSet = false;
    
    private String mlpName ="";                  //A chosen name for the ann
    private double learingingRate = 0;           //The alpha parameter or the learning reate
    
    private ArrayList<  ArrayList<double[]> > train_data = null;     //Actual input data that ann will be train with
    private ArrayList<  ArrayList<double[]> > test_data = null;
    
    private int train_pointer = 0;
    
    private boolean isClassActivated = false;
    
    public MLP2(String name){  this.mlpName = name; }
    
    public boolean setConfigs(int[] config){
        
        if( config.length >= 2 && !isClassActivated) // The network isn't activated and not initialized yet
            for(int dim : config)                    // The dimmension of each layer is bigger than 1
                if (dim < 1)
                    return false;
        
        this.configs = config;
        
        isConfigSet = true;
        return true;
                
    }
    
    public boolean setWeights(double[][][] weights){
        
        if (!isConfigSet && !isClassActivated)   return false;           //If configs not set yet, don't set the weights
        
        if (weights.length != configs.length - 1)   //If number of layers don't match
            return false;
        
        for (int i=0 ; i < weights.length ; i++){   
            
            if (weights[i].length != configs[i+1])  //If number of neurons in each layer don't match
                return false;
            
            for (int j=0 ; j < weights[i].length ; j++)
                if (weights[i][j].length != configs[i]) //If the weights coming into a neuron don't match
                    return false;
        }
        
        this.weights = weights;
        isWeightsSet = true;
        return true;
    
    }
    
    public boolean setBiases(double[][] bias){
    
        if (!isConfigSet && !isClassActivated)   return false;           //If configs not set yet, don't set the weights
        
        if (bias.length != configs.length -1)       //If number of layers don't match
            return false;
        
        for (int i=0 ; i < bias.length ; i++)
            if (bias[i].length != configs[i+1])
                return false;
        
        this.bias = bias;
        isBiasSet = true;
        return true;
    
    }
    
    public void setMlpName(String mlpName) {
        this.mlpName = mlpName;
    }

    public void setLearningRate(double lrate){
        
        if (lrate >= 1)
            this.learingingRate = 1;
        
        else if (lrate <= 0)
            this.learingingRate = 0.0001;
       
        else
            this.learingingRate = lrate;
            
    }
    
    public boolean set_train_data(ArrayList< ArrayList<double[]> > data){
    
        if (!isConfigSet) return false;
        
        if (!evaluate_data(data))
            return false;
        
        this.train_data = data;
        
        return true;
        
    }
    
    public boolean set_test_data(ArrayList< ArrayList<double[]> > data){
        
        if (!isConfigSet) return false;
        
        if (!evaluate_data(data))
            return false;
    
        this.test_data = data;
        
        return true;
    }
    
    private boolean evaluate_data(ArrayList< ArrayList<double[]> > data){
        
        for (ArrayList<double[]> dt : data){

            if(dt.size() != 2)
                return false;
            
            if (dt.get(0).length != configs[0])
                return false;
            
            if (dt.get(1).length != configs[configs.length-1])
                return false;
        }
            
        return true;
    
    }
    
    public boolean init(ArrayList< ArrayList<double[]> > data_train, ArrayList< ArrayList<double[]> > data_test, double learningRate){
        
        if (isClassActivated)
            return false;
        
        if (!isConfigSet)
            return false;
        
        if (!set_train_data(data_train))
            return false;
        
        if (!set_test_data(data_test))
            return false;
        
        this.learingingRate = learningRate;
        
        if (!isWeightsSet){
            
            this.weights = new double[configs.length -1][][];
            
            for (int i=0 ; i < this.weights.length ; i++)
                this.weights[i] = new double[   configs[i+1]   ][ configs[i] ];
                
            for (int i=0 ; i < this.weights.length ; i++)
                for (int j=0 ; j < this.weights[i].length ; j++)
                    for (int k=0 ; k < this.weights[i][j].length ; k++)
                        this.weights[i][j][k] = new Random().nextGaussian();
            
        }
        
        
        if (!isBiasSet){
            
            this.bias = new double[configs.length -1][];
            
            for (int i=0 ; i < this.bias.length ; i++)
                this.bias[i] = new double[configs[i+1]];
            
        }
        
        
        
        this.isClassActivated = true;
        
        return true;
    
        
    }
    
    public boolean init(ArrayList< ArrayList<double[]> > data_train, ArrayList< ArrayList<double[]> > data_test , int[] configs , double learningRate){
        
        if (isClassActivated)
            return false;
        
        if (!setConfigs(configs))
            return false;
        
        if (!set_train_data(data_train))
            return false;
        
        if (!set_test_data(data_test))
            return false;
        

        this.learingingRate = learningRate;
        
        if (!isWeightsSet){
            
            this.weights = new double[configs.length -1][][];
            
            for (int i=0 ; i < this.weights.length ; i++)
                this.weights[i] = new double[   configs[i+1]   ][ configs[i] ];
                
            for (int i=0 ; i < this.weights.length ; i++)
                for (int j=0 ; j < this.weights[i].length ; j++)
                    for (int k=0 ; k < this.weights[i][j].length ; k++)
                        this.weights[i][j][k] = new Random().nextGaussian();
            
        }
        
        if (!isBiasSet){
            
            this.bias = new double[configs.length -1][];
            
            for (int i=0 ; i < this.bias.length ; i++)
                this.bias[i] = new double[configs[i+1]];
            
        }
        
        
        this.isClassActivated = true;
        
        return true;
    
    
    }

    public double activation_function(double input){
    
        return Math.tanh(input);
        
    }
   
    public double activation_function_derivative(double input){
        
        return (1/Math.cosh(input)) * (1/Math.cosh(input));
    
    }

    public double[] run_network(double[] input){
        
        if (input.length != configs[0]) return null;
        
        double[] pre_layer_signals = input;
    
        for (int i=0 ; i < weights.length ; i++){
            
            double[] signals = new double[weights[i].length];
            for (int j=0 ; j < weights[i].length ; j++){
                signals[j] = this.bias[i][j];
                
                for (int k=0 ; k < weights[i][j].length ; k++)
                    signals[j] += weights[i][j][k] * pre_layer_signals[k]; 
                
                signals[j] = activation_function(signals[j]);
            }
            
            pre_layer_signals = signals;
        }
        
        return pre_layer_signals;
        
    }
    
    private double[][] network_fileds(double[] input){
        
        if (input.length != configs[0]) return null;
        
        double[] pre_layer_signals = input;
        double[][] fields = bias.clone();
        
        for (int i=0 ; i < weights.length ; i++){
            
            double[] signals = new double[weights[i].length];
            for (int j=0 ; j < weights[i].length ; j++){
                signals[j] = this.bias[i][j];
                
                for (int k=0 ; k < weights[i][j].length ; k++)
                    signals[j] += weights[i][j][k] * pre_layer_signals[k]; 
                
                fields[i][j] = signals[j];
                signals[j] = activation_function(signals[j]);
            }
            
            pre_layer_signals = signals;
        } 
        
        return fields;
    
    }
    
    //Room for improvment
    private double[][] network_output(double[] input){
    
        if (input.length != configs[0]) return null;
        
        double[] pre_layer_signals = input;
        double[][] outputs = bias.clone();
        
        for (int i=0 ; i < weights.length ; i++){
            
            double[] signals = new double[weights[i].length];
            for (int j=0 ; j < weights[i].length ; j++){
                signals[j] = this.bias[i][j];
                
                for (int k=0 ; k < weights[i][j].length ; k++)
                    signals[j] += weights[i][j][k] * pre_layer_signals[k]; 
                
                signals[j] = activation_function(signals[j]);
                outputs[i][j] = signals[j];
            }
            
            pre_layer_signals = signals;
        }
        
        return outputs;
    
    }
    
    private void backpropogation(ArrayList<double[]> input){
        
        if (input.size() != 2) return;
        
        double[] network_input = input.get(0);   //Network input
        double[] desiered_output = input.get(1);//d(j)
        
        double[][] fields = network_fileds(network_input);
        double[][] outputs = network_output(network_input);
        double[][][] weights = this.weights.clone();
        double[][] bias = this.bias.clone();
        double[][] errors = this.bias.clone();
        
        //Posible error
        for (int i = this.weights.length -1 ; i >= 0 ; i--){
            
            if (i == this.weights.length -1)
                for (int j=0 ; j < weights[i].length ; j++)
                    errors[i][j] = desiered_output[j] - outputs[i][j];
                
            else{
                
                for (int j=0 ; j < this.weights[i].length ; j++){
                    double error = 0;
                    
                    for (int k=0 ; k < this.weights[i+1].length ; k++)
                        
                        error += errors[i+1][k] * activation_function_derivative(fields[i+1][k]) * weights[i+1][k][j];
                    
                    errors[i][j] = error;
                }
            }
            
        }
        
        for (int i=0 ; i < this.weights.length ; i++){
            for (int j =0 ; j < this.weights[i].length ; j++){
                
                bias[i][j] += learingingRate * errors[i][j] * activation_function_derivative(fields[i][j]);
                
                for (int k=0 ; k < this.weights[i][j].length ; k++){
                    if (i == 0)
                        weights[i][j][k] += learingingRate * errors[i][j] * activation_function_derivative(fields[i][j]) * network_input[k];
                    else
                        weights[i][j][k] += learingingRate * errors[i][j] * activation_function_derivative(fields[i][j]) * outputs[i-1][k];
                }
            }
        }
        
        this.weights = weights;
        this.bias = bias;
        
    }
    
    public void learn(int epoch){
    
        for (int i=0 ; i < epoch ; i++){
            int index = train_pointer % test_data.size();
            backpropogation(this.test_data.get(index));
            train_pointer++;
        }
    }
    
    public double evaluate(){
        
        int score = 0;
        
        for ( ArrayList<double[]> test : this.test_data){
            
            double[] out = run_network( test.get(0) );
            
        }
        
        return score/this.train_data.size();
    
    }
    
    public void print_weights(){
    
        for (int i=0 ; i < this.weights.length ; i++){
            for (int j=0 ; j < this.weights[i].length; j++){
                for (int k=0 ; k < this.weights[i][j].length ; k++){
                
                    System.out.printf("W(%d,%d,%d): %f \t" , i , j , k , this.weights[i][j][k]);
                
                }
                System.out.println("");
            }
            System.out.println("**********************");
        
        }

    }
    
    public void print_config(){
        
        for (int a : configs)
            System.out.printf("\t%d" , a);
    
    }

    public void print_bias(){
        
        for (int i=0 ; i < this.bias.length ; i++){
                for (int j=0 ; j < this.bias[i].length; j++){


                    System.out.printf("B(%d,%d): %f \t" , i , j , this.bias[i][j]);


                System.out.println("");
                }
                
            System.out.println("**********************");

            }
        
    }
}
