package src.Q2.Klassen.Zoo;

public abstract class Tier {

    // Felder
    private final String name;
    private int energie, gesundheit, zufriedenheit;

    // Konstruktor
    public Tier(String name, int energie, int gesundheit, int zufriedenheit) {
        this.name = name;
        setEnergie(energie);
        setGesundheit(gesundheit);
        setZufriedenheit(zufriedenheit);
    }

    // Getter
    public String getName() { return name; }

    public int getEnergie() { return energie; }

    public int getGesundheit() { return gesundheit; }

    public int getZufriedenheit() { return zufriedenheit; }

    // Setter mit Validierung
    public void setEnergie(int energie) { 
        this.energie = Math.max(0, Math.min(100, energie));
    }

    public void setGesundheit(int gesundheit) { 
        this.gesundheit = Math.max(0, Math.min(100, gesundheit));
    }

    public void setZufriedenheit(int zufriedenheit) { 
        this.zufriedenheit = Math.max(0, Math.min(100, zufriedenheit)); 
    }

    // Abstrakte Methoden
    public abstract String macheGeraeusche();
    public abstract String getBeschreibung();

}
