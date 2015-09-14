/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.neuralnet;

import java.util.ArrayList;
import java.util.Random;


public class Neuron {

    int numInputs;
    ArrayList<Double> vecWeights;
    Random rand = new Random();
    
    public Neuron(int numInputs) {
        this.numInputs = numInputs;
        for (int i = 0; i < numInputs+1; i++) {
            vecWeights.add((double)rand.nextFloat() * 2 - 1);
        }
    }
    
} 