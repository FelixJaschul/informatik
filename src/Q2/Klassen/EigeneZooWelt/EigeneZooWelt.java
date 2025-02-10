package src.Q2.Klassen.EigeneZooWelt;

public abstract class EigeneZooWelt {

    // Fields

    private final String zooName = "Zoomania";
    private static int energie, gesundheit, zufriedenheit = 80;

    // Konstruktor

    public EigeneZooWelt(int energie, int gesundheit, int zufriedenheit) {

        EigeneZooWelt.energie = energie;
        EigeneZooWelt.gesundheit = gesundheit;
        EigeneZooWelt.zufriedenheit = zufriedenheit;

    } 
    
    // Getter und Setter

    public String getZooName() { return zooName; }

    public int getEnergie() { return energie; }

    public int getGesundheit() { return gesundheit; }

    public int getZufriedenheit() { 
        return zufriedenheit; 
    }

    public void setEnergie(int energie) { 
        if (energie < 0 || energie > 100) {
            EigeneZooWelt.energie = 80;
        } else {
            EigeneZooWelt.energie = energie;
        }
    }

    public void setGesundheit(int gesundheit) { 
        if (gesundheit < 0 || gesundheit > 100) { 
            EigeneZooWelt.gesundheit = 80;
        } else { 
            EigeneZooWelt.gesundheit = gesundheit;
        }
    }

    public void setZufriedenheit(int zufriedenheit) { 
        if (zufriedenheit < 0 || zufriedenheit > 100) {
            EigeneZooWelt.zufriedenheit = 80;
        } else {
            EigeneZooWelt.zufriedenheit = zufriedenheit;
        }
    }
    
    public static void main(String[] args) {
            
        EigeneZooWelt zoo = new EigeneZooWelt(20, 20, 20);

        zoo.setEnergie(200);
        System.out.println(zoo.getEnergie());
    }   

}
