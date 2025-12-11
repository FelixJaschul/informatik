package KünstlicheIntelligenz;

import java.util.Random;

public class Sigmoid
{
    public static class Neuron
    {
        private final String name;
        private double w1, w2, bias;
        private static final Random random = new Random();

        public Neuron(String name)
        {
            this.name = name;
            this.w1   = random.nextGaussian() * 0.5;
            this.w2   = random.nextGaussian() * 0.5;
            this.bias = random.nextGaussian() * 0.5;
        }

        private void display()
        {
            System.out.println(this.name + " (w1: " + this.w1 + ", w2: " + this.w2 + ", bias: " + this.bias + ")");
        }

        private double sigmoid(double x)
        {
            return 1.0 / (1.0 + Math.exp(-x));
        }

        private double forward(double i1, double i2)
        {
            return sigmoid((i1 * this.w1) + (i2 * this.w2) + this.bias);
        }

        public void update(double i1, double i2, double target)
        {
            double rate   = 0.5;
            double output = forward(i1, i2);
            double error  = target - output;
            // output * (1- output) => Ableitung
            double delta  = error * output * (1 - output);

            // update weights
            this.w1   += rate * delta * i1;
            this.w2   += rate * delta * i2;
            this.bias += rate * delta;
        }
    }

    // Helper
    private static Neuron trainNeuron(String name, double[][] inp, double[] out)
    {
        Neuron neuron = new Neuron(name);

        for (int epoch = 0; epoch < 10000; epoch++)
            for (int i = 0; i < inp.length; i++)
                neuron.update(inp[i][0], inp[i][1], out[i]);

        neuron.display();
        return neuron;
    }

    static void main()
    {
        double[][] i = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };

        Neuron or   = trainNeuron("OR:   ", i, new double[]{0, 1, 1, 1});
        Neuron and  = trainNeuron("AND:  ", i, new double[]{0, 0, 0, 1});
        Neuron nand = trainNeuron("NAND: ", i, new double[]{1, 1, 1, 0});

        for (double[] input : i)
            System.out.println("=> XOR: (" + input[0] + " " + input[1] + ") -> " + and.forward(or.forward(input[0], input[1]), nand.forward(input[0], input[1])));
    }
}