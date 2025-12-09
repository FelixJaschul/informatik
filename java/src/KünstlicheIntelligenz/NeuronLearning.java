package KünstlicheIntelligenz;

import java.util.Random;

public class NeuronLearning
{
    private double w1, w2, t;
    private final String name;
    private final Random random = new Random();

    public NeuronLearning(String name)
    {
        this.w1 = random.nextDouble() * 4 - 2;
        this.w2 = random.nextDouble() * 4 - 2;
        this.t  = random.nextDouble() * 4 - 2;
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
        // return (i1 * w1) + (i2 * w2) > t ? 1 : 0;
        return (i1 * w1) + (i2 * w2) + t > 0 ? 1 : 0;
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

    private int getErrorCount(int[][] inputs, int[] expectedOutputs)
    {
        int z = 0;
        for (int i = 0; i < inputs.length; i++)
        {
            if (this.fire(inputs[i][0], inputs[i][1]) != expectedOutputs[i]) z++;
        }
        return z;
    }

    public void display()
    {
        System.out.println(this.name + " (" + this.w1 + ", " + this.w2 + ", " + this.t + ")");
    }

    // Not member of NeuronLearning class
    public static NeuronLearning trainData(String name, int[][] inputs, int[] outputs)
    {
        NeuronLearning neuron = new NeuronLearning(name);

        int errors = neuron.getErrorCount(inputs, outputs);

        // for (int i = 0; i < 10000000; i++)
        do
        {
            NeuronLearning copy = neuron.getCopy();
            neuron.mutate();

            int newErrors = neuron.getErrorCount(inputs, outputs);

            if (newErrors > errors) neuron = copy;
            else errors = newErrors;

        } while (errors != 0);

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
