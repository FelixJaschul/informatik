package SpielDemo;

// Basisklasse für alle Spielcharaktere
public class Spielfigur {
    // Attribute, die alle Spielfiguren gemeinsam haben
    protected String name;
    protected int lebenspunkte;
    protected int geschwindigkeit;
    protected int inventorySize;

    // Konstruktor
    public Spielfigur(String name, int lebenspunkte, int geschwindigkeit) {
        this.name = name;
        this.lebenspunkte = lebenspunkte;
        this.geschwindigkeit = geschwindigkeit;
        this.inventorySize = 27;
    }

    // Methoden, die alle Spielfiguren gemeinsam haben  nimm
    public void bewegen() {
        System.out.println(name + " bewegt sich mit Geschwindigkeit " + geschwindigkeit);
    }

    // Methode um beim Shop einkaufen zu können
    public void visitShop() {
        System.out.println(name + " besucht den Shop");
    }
    public void kaufe(String name) {
        Produkt p = Shop.getINSTANCE().lookforProdukt(name);

        if (p == null) {
            System.out.println("Produkt: " + name + " nicht gefunden.");
            return;
        }
        p.decreaseAmount();
        this.decreaseInventorySize(p.getWeight());
        System.out.println("Produkt: " + name + " gekauft!");
    }

    public void nimmSchaden(int schaden) {
        lebenspunkte -= schaden;
        System.out.println(name + " nimmt " + schaden + " Schaden und hat noch " + lebenspunkte + " Lebenspunkte.");

        if (lebenspunkte <= 0) {
            System.out.println(name + " wurde besiegt!");
        }
    }

    public void verbrauchProdukt(String name) {
        Produkt p = Shop.getINSTANCE().lookforProdukt(name);

        if (p == null) {
            System.out.println("kein Produkt mit dem Namen " + name + " gefunden.");
            return;
        }
        this.increaseInventorySize(p.getWeight());
        this.increaseLebenspunkte(p.getHeilWert());
        System.out.println("Produkt " + name + " verbraucht!");
    }

    public String getName() {
        return name;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public void increaseLebenspunkte(int value) {
        lebenspunkte += value;
    }

    public void decreaseLebenspunkte(int value) {
        lebenspunkte -= value;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void decreaseInventorySize(int value) {
        inventorySize -= value;
    }

    public void increaseInventorySize(int value) {
        inventorySize += value;
    }

    public String getInfo() {
        return "Spielfigur: " + name +
                "\nLebenspunkte: " + lebenspunkte +
                "\nGeschwindigkeit: " + geschwindigkeit;
    }
}
