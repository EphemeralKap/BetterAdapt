/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.neuralnet;

import java.util.ArrayList;

public class NeuralNet {
    private int numInputs;
    private int numOutputs;
    private int numHiddenLayers;
    private int neuronsPerHiddenLayer;
    
    private ArrayList<NeuronLayer> layers = new ArrayList<NeuronLayer>();
    
    public NeuralNet() {
        
    }
    
    public void CreateNet() {
        
    }
    
    public int GetNumberOfWeights() {
        return 0;
    }
    
    public void PutWeights(ArrayList<Double> weights) {
        
    }
    
    public ArrayList<Double> Update(ArrayList<Double> inputs) {
        ArrayList<Double> outputs = new ArrayList<Double>();
        int weight = 0;
        
        if(inputs.size() != numInputs) {
            return outputs;
        }
        
        for (int i = 0; i < numHiddenLayers + 1; i++) {
            if( i > 0) {
                inputs = outputs;
            }
            outputs.clear();
            weight = 0;
            
            //Sum the (inputs * weight) for each neuron in this layer
            //Throw the total at the Sigmoid function, to get the output.
            
            for (int j = 0; j < layers.get(i).numNeurons; j++) {
                double netinput = 0;
                int numInputs = layers.get(i).Neurons.get(j).numInputs;
                
                //For each weight
                for (int k = 0; k < numInputs; k++) {
                    //Sum the weights x inputs
                    netinput += layers.get(i).Neurons.get(j).vecWeights.get(k) * inputs.get(weight++);
                }
                
                //Add in the bias!
                netinput += layers.get(i).Neurons.get(j).vecWeights.get(numInputs-1);
            }
        }
        return null;
    }
    
    public double Sigmoid(double activation, double response) {
        return 0;
    }
    
    
} 