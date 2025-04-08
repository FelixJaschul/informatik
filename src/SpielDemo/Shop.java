package SpielDemo;

import java.util.ArrayList;

public class Shop {
    protected String name;
    protected ArrayList<Produkt> produkte;
    protected static Shop INSTANCE;

    public Shop(String name) {
        this.name = name;
    }

    public static Shop getINSTANCE() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void addProdukt(Produkt produkt) {
        produkte.add(produkt);
    }

    public void removeProdukt(Produkt produkt) {
        produkte.remove(produkt);
    }

    public ArrayList<Produkt> getProdukte() {
        return produkte;
    }

    public Produkt lookforProdukt(String name) {
        for (Produkt p : produkte) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }
}
