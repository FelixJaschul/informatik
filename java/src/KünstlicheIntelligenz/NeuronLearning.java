package KünstlicheIntelligenz;

import java.util.Random;

public class NeuronLearning
{
    private double w1, w2, t;
    private final String name;

    public NeuronLearning(String name)
    {
        Random random = new Random();
        this.w1 = random.nextDouble() * 4 - 2;
        this.w2 = random.nextDouble() * 4 - 2;
        this.t  = random.nextDouble() * 4 - 2;
        this.name = name;
    }

    public int fire(int i1, int i2)
    {
        return (i1 * w1) + (i2 * w2) + t > 0 ? 1 : 0;
    }

    public void display()
    {
        System.out.println(this.name + " (" + this.w1 + ", " + this.w2 + ", " + this.t + ")");
    }

    public static NeuronLearning trainData(String name, int[][] inputs, int[] outputs)
    {
        NeuronLearning neuron = new NeuronLearning(name);
        double rate = 0.1;

        for (int epoch = 0; epoch < 1000; epoch++)
        {
            int errors = 0;

            for (int i = 0; i < inputs.length; i++)
            {
                int i1 = inputs[i][0], i2 = inputs[i][1];

                // Value, if
                // delta ==  0 -> neuron.fire == output[i],
                // delta ==  1 -> neuron.fire is 0, but 1 is right
                // delta == -1 -> neuron.fire is 1, but 0 is right
                int delta  = outputs[i] - neuron.fire(i1, i2);

                if (delta != 0)
                {
                    // learn based on the value of delta
                    neuron.w1 += rate * delta * i1; // only change if i1 is == 1 not 0
                    neuron.w2 += rate * delta * i2; // only change if i2 is == 1 not 0
                    neuron.t  += rate * delta;      // always change the threshold
                    errors++;
                }
            }

            if (errors == 0) break;
        }

        neuron.display();
        return neuron;
    }

    static void main()
    {
        int[][] i = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };

        NeuronLearning or   = trainData("OR:   ", i, new int[]{0, 1, 1, 1});
        NeuronLearning and  = trainData("AND:  ", i, new int[]{0, 0, 0, 1});
        NeuronLearning nand = trainData("NAND: ", i, new int[]{1, 1, 1, 0});

        for (int[] input : i)
        {
            System.out.println("-> for: (" + input[0] + " " + input[1] + ") -> " + and.fire(or.fire(input[0], input[1]), nand.fire(input[0], input[1])));
        }
        System.out.println("XOR: ^^");
    }
}
