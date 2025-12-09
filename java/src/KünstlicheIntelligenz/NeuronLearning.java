package KünstlicheIntelligenz;

import java.util.Random;

public class NeuronLearning
{
    double w1, w2, t, rate = 0.1;
    String name;
    Random random = new Random();

    public NeuronLearning(String name)
    {
        this.w1 = random.nextDouble() * 4 - 2;  // [-2, 2)
        this.w2 = random.nextDouble() * 4 - 2;  // [-2, 2)
        this.t  = random.nextDouble() * 4 - 2;  // [-2, 2)
        this.name = name;
    }

    public NeuronLearning(String name, double w1, double w2, double t)
    {
        this.w1 = w1;
        this.w2 = w2;
        this.t  = t;
        this.name = name;
    }

    public int fire(int i1, int i2)
    {
        if ((i1 * this.w1) + (i2 * this.w2) > this.t) return 1;
        else return 0;
    }

    public NeuronLearning getCopy()
    {
        return new NeuronLearning(this.name, this.w1, this.w2, this.t);
    }

    public void mutate()
    {
        int r = random.nextInt(3);
        double v = random.nextDouble() * 0.2 - 0.1;

        if (r == 0) this.w1 += v;
        if (r == 1) this.w2 += v;
        if (r == 2) this.t  += v;
    }

    public int getErrorCount(int[][] inputs, int[] expectedOutputs)
    {
        int z = 0;
        for (int i = 0; i < inputs.length; i++)
        {
            if (this.fire(inputs[i][0], inputs[i][1]) != expectedOutputs[i]) z++;
        }
        return z;
    }

    public void output()
    {
        System.out.println(this.name + " (" + this.w1 + ", " + this.w2 + ", " + this.t + ")");
    }

    public NeuronLearning getTrainedData(int[][] inputs, int[] outputs)
    {
        NeuronLearning neuron = new NeuronLearning("Neuron 1");

        int errors = neuron.getErrorCount(inputs, outputs);

        do {
            NeuronLearning copy = neuron.getCopy();
            neuron.mutate();

            if (neuron.getErrorCount(inputs, outputs) > errors) neuron = copy;
            else errors = neuron.getErrorCount(inputs, outputs);

        } while (errors != 0);

        return neuron;
    }

    static void main()
    {
        int[][] i = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };
        NeuronLearning OR   = new NeuronLearning("OR"  ).getTrainedData(i, new int[]{0, 1, 1, 1});
        NeuronLearning AND  = new NeuronLearning("AND" ).getTrainedData(i, new int[]{0, 0, 0, 1});
        NeuronLearning NAND = new NeuronLearning("NAND").getTrainedData(i, new int[]{1, 1, 1, 0});

        for (int[] input : i)
        {
            System.out.println(AND.fire(OR.fire(input[0], input[1]), NAND.fire(input[0], input[1])));
        }
    }
}
