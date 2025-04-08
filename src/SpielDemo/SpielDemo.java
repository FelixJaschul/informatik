package SpielDemo;

// Beispielklasse mit main-Methode zum Testen
public class SpielDemo {
    public static void main(String[] args) {
        // Shop erstellen
        Shop shop = new Shop("Hope for Dope");

        // Produkte erstellen
        Produkt dope = new Produkt("Dope", 10, "Epic", 9, 10);
        Produkt regeneration = new Produkt("Regeneration", 3, "Rare", 2, 20);

        // Spielfiguren erstellen
        Spielfigur einfacheFigur = new Spielfigur("Dorfbewohner", 50, 5);
        Krieger krieger = new Krieger("Ragnar", 100, 7, 20, "Axt");
        Magier magier = new Magier("Gandora", 70, 6, 100, "Feuer");
        Heiler heiler = new Heiler("Melsebub", 150, 3, 20, 40);

        // Shop füllen
        shop.addProdukt(dope);
        shop.addProdukt(regeneration);

        // Informationen anzeigen
        System.out.println("=== CHARAKTERINFORMATIONEN ===");
        System.out.println(einfacheFigur.getInfo());
        System.out.println("\n" + krieger.getInfo());
        System.out.println("\n" + magier.getInfo());
        
        // Aktionen durchführen
        System.out.println("\n=== AKTIONEN ===");
        einfacheFigur.bewegen();
        krieger.bewegen();  // Überschriebene Methode
        magier.bewegen();   // Überschriebene Methode
        heiler.visitShop();
        heiler.kaufe("dope");
        
        // Kampfaktionen
        System.out.println("\n=== KAMPF ===");
        krieger.angreifen(einfacheFigur);  // Spezielle Methode des Kriegers
        magier.zaubern(krieger);           // Spezielle Methode des Magiers
        magier.magiePunkteAufladen(20);    // Weitere spezielle Methode
        magier.zaubern(krieger);           // Erneuter Zauberangriff
    
        // Heilaktionen
        System.out.println("\n=== HEILEN ===");
        System.out.println(einfacheFigur.getInfo());           // Info über den Dorfbewohner   
        heiler.heilen(einfacheFigur);                          // Spezielle Methode des Heilers
        System.out.println(einfacheFigur.getInfo());           // Info über den Dorfbewohner   
        heiler.bewegen();                                      // Spezielle Methode des Heilers
        heiler.getInfo();                                      // Informationen über den Heiler
        heiler.meditieren();                                   // Spezielle Methode des Heilers
        heiler.verbrauchProdukt("dope");
    }
  
}
