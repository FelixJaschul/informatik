package KünstlicheIntelligenz;

import java.util.Objects;

public class Neuron
{
    String name;
    double t, w1, w2, rate = 0.1;

    public Neuron(String name, double t, double w1, double w2)
    {
        this.name = name;
        this.t = t;
        this.w1 = w1;
        this.w2 = w2;
    }

    public int fire(int i1, int i2)
    {
        if ((i1 * this.w1) + (i2 * this.w2) > this.t) return 1;
        else return 0;
    }

    private void train(int i1, int i2, int expected_value)
    {
        int output = this.fire(i1, i2);
        int error  = expected_value - output;
        this.w1 = w1 + (error * i1 * this.rate);
        this.w2 = w2 + (error * i2 * this.rate);
    }

    private void output()
    {
        System.out.println();
        System.out.println("Neuron: " + this.t + " W1: " + this.w1 + " W2: " + this.w2);
        System.out.println("-> Rate: " + this.rate);
        System.out.println("-> " + this.name + ": (0, 0) -> Out: " + this.fire(0, 0));
        System.out.println("-> " + this.name + ": (1, 1) -> Out: " + this.fire(1, 1));
        System.out.println("-> " + this.name + ": (1, 0) -> Out: " + this.fire(1, 0));
        System.out.println("-> " + this.name + ": (0, 1) -> Out: " + this.fire(0, 1));
    }

    public void train(int epochs)
    {
        for (int i = 0; i < epochs; i++)
        {
            if (this.name.equals("OR"))
            {
                train(0, 0, 0);
                train(1, 0, 1);
                train(0, 1, 1);
                train(1, 1, 1);
            }

            if (this.name.equals("NOR"))
            {
                train(0, 0, 1);
                train(1, 0, 0);
                train(0, 1, 0);
                train(1, 1, 0);
            }

            if (this.name.equals("AND"))
            {
                train(0, 0, 0);
                train(1, 0, 0);
                train(1, 1, 1);
                train(0, 1, 0);
            }

            if (this.name.equals("NAND"))
            {
                train(0, 0, 1);
                train(1, 0, 1);
                train(1, 1, 0);
                train(0, 1, 1);
            }

            // XOR night als single layer ausführbar
        }
    }

    static void main()
    {
        Neuron or = new Neuron("OR" , 0.5, 0, 0);
        or.train(100);
        or.output();

        Neuron nor = new Neuron("NOR" , -0.5, 0, 0);
        nor.train(100);
        nor.output();

        Neuron and = new Neuron("AND" , 1.5, 0, 0);
        and.train(100);
        and.output();

        Neuron nand = new Neuron("NAND" , -1.5, 0, 0);
        nand.train(100);
        nand.output();

        System.out.println(and.fire(or.fire(0, 1), nand.fire(0, 1)));
        System.out.println(and.fire(or.fire(0, 0), nand.fire(0, 0)));
        System.out.println(and.fire(or.fire(1, 1), nand.fire(1, 1)));
        System.out.println(and.fire(or.fire(1, 0), nand.fire(1, 0)));
    }

}
