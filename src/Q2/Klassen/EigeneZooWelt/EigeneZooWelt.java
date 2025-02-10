package src.Q2.Klassen.EigeneZooWelt;
public class EigeneZooWelt {

    // Fields (keine statischen Variablen)
    private final String zooName = "Zoomania";
    private int energie, gesundheit, zufriedenheit;

    // Konstruktor
    public EigeneZooWelt(int energie, int gesundheit, int zufriedenheit) {

        setEnergie(energie);
        setGesundheit(gesundheit);
        setZufriedenheit(zufriedenheit);

    } 
    
    // Getter

    public String getZooName() { return zooName; }

    public int getEnergie() { return energie; }

    public int getGesundheit() { return gesundheit; }

    public int getZufriedenheit() { return zufriedenheit; }

    // Setter mit Validierung

    public void setEnergie(int energie) { 

        this.energie = (energie < 0 || energie > 100) ? 80 : energie;

    }

    public void setGesundheit(int gesundheit) { 

        this.gesundheit = (gesundheit < 0 || gesundheit > 100) ? 80 : gesundheit;
    
    }

    public void setZufriedenheit(int zufriedenheit) { 

        this.zufriedenheit = (zufriedenheit < 0 || zufriedenheit > 100) ? 80 : zufriedenheit;
    
    }

    // Main-Methode
    public static void main(String[] args) {

        EigeneZooWelt zoo = new EigeneZooWelt(20, 20, 20);

        zoo.setEnergie(200);
        System.out.println(zoo.getEnergie()); // Ausgabe: 80
    }
}
