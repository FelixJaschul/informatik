
## 1. Grundlagen der Programmierung

### Hello-World-Programm

```java
public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
    }
}
```

### Programmkopf

```java
/**
 * Klasse: Taschenrechner
 * Autor: Dein Name
 * Datum: 08.03.2025
 * Version: 1.0
 * Beschreibung: Einfacher Taschenrechner mit Grundrechenarten
 */

public class Taschenrechner {

    // Klasseninhalt folgt
}
```

### Kommentare

```java
// Einzeiliger Kommentar

/* 
 * Mehrzeiliger Kommentar
 * über mehrere Zeilen verteilt
 */

/**
 * JavaDoc-Kommentar für Dokumentation
 * @param wert Ein Parameter
 * @return Gibt einen Wert zurück
 */
```

### Wichtige Schlüsselwörter

```java
public    // Zugriffsmodifikator für öffentlichen Zugriff
private   // Zugriffsmodifikator für privaten Zugriff
protected // Zugriffsmodifikator für geschützten Zugriff
class     // Definiert eine Klasse
static    // Definiert eine klassenbezogene (nicht objektbezogene) Methode/Variable
void      // Rückgabetyp für Methoden ohne Rückgabewert
final     // Konstante (kann nicht geändert werden)
this      // Bezieht sich auf das aktuelle Objekt
new       // Erzeugt ein neues Objekt
return    // Gibt einen Wert zurück und beendet die Methode
```

### Konsolenausgabe

```java
System.out.println("Ausgabe mit Zeilenumbruch");
System.out.print("Ausgabe ohne Zeilenumbruch");
System.out.printf("Formatierte Ausgabe: %d, %.2f\n", 10, 3.14159);
```

### main-Methode

```java
public class MeinProgramm {

    // Der Einstiegspunkt jedes Java-Programms
    public static void main(String[] args) {

        // args enthält die Kommandozeilenargumente
        System.out.println("Anzahl der Argumente: " + args.length);

        for (int i = 0; i < args.length; i++) {

            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
```

## 2. Datentypen und Variablen

### Primitive Datentypen

```java
// Ganzzahlen
byte b = 127;                // 8 Bit, -128 bis 127
short s = 32767;             // 16 Bit, -32.768 bis 32.767
int i = 2147483647;          // 32 Bit, -2^31 bis 2^31-1
long l = 9223372036854775807L; // 64 Bit, -2^63 bis 2^63-1

// Fließkommazahlen
float f = 3.14159f;          // 32 Bit, Suffix f notwendig
double d = 3.141592653589793; // 64 Bit, genauer als float

// Andere primitive Typen
char c = 'A';                // 16 Bit, Unicode-Zeichen
boolean bool = true;         // true oder false
```

### Referenztypen

```java
// Referenztypen verweisen auf Objekte im Heap
String text = "Hallo Welt";     // String ist eine Klasse
int[] zahlen = {1, 2, 3, 4, 5}; // Arrays sind Referenztypen
Integer zahl = 42;              // Wrapper-Klasse für int

// Eigene Klassen als Referenztypen
Person person = new Person("Max", 17);
```

### Explizite und implizite Umwandlung von Variablen

```java
// Implizite Umwandlung (automatisch, wenn kein Datenverlust)
int zahl = 100;
long grosseZahl = zahl; // int passt in long (Erweiterung)

// Explizite Umwandlung (Casting, manuell bei möglichem Datenverlust)
double kommaZahl = 3.14;
int ganzeZahl = (int) kommaZahl; // 3 (Nachkommastellen gehen verloren)

// Wrapper-Klassen
String zahlAlsText = "42";
int zahlAusText = Integer.parseInt(zahlAlsText);
double kommaZahlAusText = Double.parseDouble("3.14");
```

## 3. Kontrollstrukturen

### Fallunterscheidungen (if/else oder switch)

```java
// if-else-Struktur
int alter = 17;

if (alter >= 18) System.out.println("Volljährig");
else if (alter >= 16) System.out.println("Eingeschränkt geschäftsfähig");
else System.out.println("Minderjährig");

// switch-Struktur
int note = 2;
switch (note) {

    case 1:
        System.out.println("Sehr gut");
        break;
    case 2:
        System.out.println("Gut");
        break;
    case 3:
        System.out.println("Befriedigend");
        break;
    case 4:
        System.out.println("Ausreichend");
        break;
    case 5:
        System.out.println("Mangelhaft");
        break;
    case 6:
        System.out.println("Ungenügend");
        break;
    default:
        System.out.println("Ungültige Note");
}
```

### Wiederholungen (while/for/do-While)

```java
// for-Schleife (feste Anzahl von Durchläufen)
for (int i = 0; i < 5; i++) {

    System.out.println("Durchlauf " + i);
}

// while-Schleife (Bedingung wird vor jedem Durchlauf geprüft)
int j = 0;

while (j < 5) {

    System.out.println("While-Durchlauf " + j);
    j++;
}

// do-while-Schleife (wird mindestens einmal ausgeführt)
int k = 0;

do {

    System.out.println("Do-While-Durchlauf " + k);
    k++;
} while (k < 5);
```

## 4. Programmierparadigmen

### Unterschied zwischen imperativer und objektorientierter Programmierung

```java
// Imperativ (prozedural): Schritt-für-Schritt-Anweisungen
public class ImperativeBeispiel {

    public static void main(String[] args) {

        // Daten und Aktionen sind getrennt
        int[] zahlen = {5, 3, 8, 1, 2};
        int summe = 0;
        
        // Explizite Schritte zur Summenberechnung
        for (int i = 0; i < zahlen.length; i++) {

            summe += zahlen[i];
        }
        
        System.out.println("Summe: " + summe);
    }
}

// Objektorientiert: Daten und Verhalten sind in Objekten gekapselt
public class OOPBeispiel {

    public static void main(String[] args) {

        // Objekt erstellen, das Daten und Verhalten kapselt
        Zahlensammlung sammlung = new Zahlensammlung(new int[]{5, 3, 8, 1, 2});
        
        // Objekt kümmert sich selbst um die Berechnung
        System.out.println("Summe: " + sammlung.berechneSumme());
    }
}

class Zahlensammlung {

    private int[] zahlen;
    
    public Zahlensammlung(int[] zahlen) {

        this.zahlen = zahlen;
    }
    
    public int berechneSumme() {

        int summe = 0;
        for (int zahl : zahlen) {

            summe += zahl;
        }

        return summe;
    }
}
```

## 5. Objektorientierte Programmierung

### Attribute

```java
public class Schueler {

    // Attribute/Eigenschaften eines Schülers
    private String name;
    private int alter;
    private double notendurchschnitt;
    private boolean istKlassensprecher;
    
    // Statisches Attribut (gehört zur Klasse, nicht zu Objekten)
    public static int anzahlSchueler = 0;
}
```

### Konstruktor

```java
public class Schueler {

    private String name;
    private int alter;
    
    // Standardkonstruktor
    public Schueler() {

        this.name = "Unbekannt";
        this.alter = 0;
    }
    
    // Parametrisierter Konstruktor
    public Schueler(String name, int alter) {

        this.name = name;
        this.alter = alter;
    }
    
    // Überladener Konstruktor
    public Schueler(String name) {

        this.name = name;
        this.alter = 16; // Standardalter
    }
}
```

### Get- und Set-Methoden

```java
public class Schueler {

    private String name;
    private int alter;
    
    // Konstruktor
    public Schueler(String name, int alter) {

        this.name = name;
        this.alter = alter;
    }
    
    // Getter für Name
    public String getName() {

        return name;
    }
    
    // Setter für Name
    public void setName(String name) {

        this.name = name;
    }
    
    // Getter für Alter
    public int getAlter() {

        return alter;
    }
    
    // Setter für Alter mit Validierung
    public void setAlter(int alter) {

        if (alter >= 6 && alter <= 20) this.alter = alter;
        else System.out.println("Ungültiges Alter für einen Schüler!");
    }
}
```

### Zugriffsmodifikatoren

```java
public class Zugriffsbeispiel {

    public String oeffentlich;      // Überall zugreifbar
    private String privat;          // Nur in dieser Klasse zugreifbar
    protected String geschuetzt;    // In dieser Klasse, Unterklassen und im selben Paket
    String paketIntern;             // Im selben Paket zugreifbar (default)
    
    public void methodeDemo() {

        // Hier können alle Attribute verwendet werden
        oeffentlich = "Wert 1";
        privat = "Wert 2";
        geschuetzt = "Wert 3";
        paketIntern = "Wert 4";
    }
}

class AndereKlasse {

    public void zugriff() {

        Zugriffsbeispiel beispiel = new Zugriffsbeispiel();
        
        beispiel.oeffentlich = "OK";     // Erlaubt
        // beispiel.privat = "Fehler";   // Nicht erlaubt (privat)
        beispiel.geschuetzt = "OK";      // Erlaubt (gleiches Paket)
        beispiel.paketIntern = "OK";     // Erlaubt (gleiches Paket)
    }
}
```

### Kapselung

```java
public class Bankkonto {

    // Gekapselte Daten (privat)
    private String kontonummer;
    private double kontostand;
    
    public Bankkonto(String kontonummer, double startguthaben) {

        this.kontonummer = kontonummer;
        if (startguthaben >= 0) this.kontostand = startguthaben;
        else {

            this.kontostand = 0;
            System.out.println("Startguthaben kann nicht negativ sein.");
        }
    }
    
    // Gekapselter Zugriff durch Methoden
    public double getKontostand() {

        return kontostand;
    }
    
    public void einzahlen(double betrag) {

        if (betrag > 0) {

            kontostand += betrag;
            System.out.println(betrag + "€ eingezahlt. Neuer Kontostand: " + kontostand + "€");
        }
        else System.out.println("Betrag muss positiv sein!");
    }
    
    public boolean abheben(double betrag) {

        if (betrag > 0 && kontostand >= betrag) {

            kontostand -= betrag;
            System.out.println(betrag + "€ abgehoben. Neuer Kontostand: " + kontostand + "€");
            return true;
        }
        else {

            System.out.println("Abhebung nicht möglich!");
            return false;
        }
    }

    public static void main(String[] args) {

        Bankkonto felix = new Bankkonto(12345, 200.0);

        felix.einzahlen(200.0);
    }
}
```

### Objektinstanzen

```java
public class AutoBeispiel {

    public static void main(String[] args) {

        // Objektinstanzen erstellen
        Auto auto1 = new Auto("VW", "Golf", "rot");
        Auto auto2 = new Auto("BMW", "X3", "schwarz");
        
        // Methoden auf Objekten aufrufen
        auto1.starten();
        auto1.beschleunigen(30);
        
        auto2.starten();
        auto2.beschleunigen(50);
        
        // Objekteigenschaften ausgeben
        System.out.println(auto1.getMarke() + " " + auto1.getModell() + " fährt " + auto1.getGeschwindigkeit() + " km/h");
        System.out.println(auto2.getMarke() + " " + auto2.getModell() + " fährt " + auto2.getGeschwindigkeit() + " km/h");
    }
}

class Auto {

    private String marke;
    private String modell;
    private String farbe;
    private int geschwindigkeit;
    private boolean motorLaeuft;
    
    public Auto(String marke, String modell, String farbe) {

        this.marke = marke;
        this.modell = modell;
        this.farbe = farbe;
        this.geschwindigkeit = 0;
        this.motorLaeuft = false;
    }
    
    public void starten() {

        motorLaeuft = true;
        System.out.println(marke + " " + modell + " wurde gestartet.");
    }
    
    public void stoppen() {

        motorLaeuft = false;
        geschwindigkeit = 0;
        System.out.println(marke + " " + modell + " wurde gestoppt.");
    }
    
    public void beschleunigen(int kmh) {

        if (motorLaeuft) {

            geschwindigkeit += kmh;
            System.out.println(marke + " " + modell + " beschleunigt auf " + geschwindigkeit + " km/h.");
        }
        else System.out.println("Der Motor muss zuerst gestartet werden!");
        
    }
    
    public String getMarke() {

        return marke;
    }
    
    public String getModell() {

        return modell;
    }
    
    public int getGeschwindigkeit() {

        return geschwindigkeit;
    }
}
```

### Aufteilung in verschiedene Dateien

```java
// Datei: Person.java
public class Person {

    private String name;
    private int alter;
    
    public Person(String name, int alter) {

        this.name = name;
        this.alter = alter;
    }
    
    public String getName() {

        return name;
    }
    
    public int getAlter() {

        return alter;
    }
}

// Datei: Adresse.java
public class Adresse {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    
    public Adresse(String strasse, String hausnummer, String plz, String ort) {

        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }
    
    public String getVolleAdresse() {

        return strasse + " " + hausnummer + ", " + plz + " " + ort;
    }
}

// Datei: Kontakt.java
public class Kontakt {

    private Person person;
    private Adresse adresse;
    
    public Kontakt(Person person, Adresse adresse) {

        this.person = person;
        this.adresse = adresse;
    }
    
    public void zeigeKontaktInfo() {

        System.out.println("Name: " + person.getName());
        System.out.println("Alter: " + person.getAlter());
        System.out.println("Adresse: " + adresse.getVolleAdresse());
    }
}

// Datei: Main.java (mit main-Methode)
public class Main {

    public static void main(String[] args) {

        Person max = new Person("Max Mustermann", 17);
        Adresse maxAdresse = new Adresse("Musterstraße", "42", "12345", "Musterstadt");
        
        Kontakt maxKontakt = new Kontakt(max, maxAdresse);
        maxKontakt.zeigeKontaktInfo();
    }
}
```

## 6. UML-Diagramme

### Standard-UML-Diagramme: Klassendiagramm / Objektdiagramm

```
// Klassendiagramm Beispiel (Textbasiert)

+------------------------+
|       Person           |
+------------------------+
| - name: String         |
| - alter: int           |
+------------------------+
| + Person(name, alter)  |
| + getName(): String    |
| + getAlter(): int      |
| + setName(name): void  |
+------------------------+
          ^
          | erbt von
          |
+------------------------+
|       Student          |
+------------------------+
| - matrikelnummer: int  |
| - studiengang: String  |
+------------------------+
| + Student(name, alter, |
|   matrikelnr, studiengang) |
| + getMatrikelnr(): int |
| + getStudiengang(): String |
+------------------------+

// Objektdiagramm Beispiel (Textbasiert)

+------------------------+
| :Student               |
+------------------------+
| name = "Lisa Müller"   |
| alter = 19             |
| matrikelnummer = 12345 |
| studiengang = "Informatik" |
+------------------------+
```

## 7. Benutzereingaben

### Scanner instanziieren

```java
import java.util.Scanner;

public class ScannerBeispiel {

    public static void main(String[] args) {

        // Scanner-Objekt erstellen, das die Eingabe von der Konsole liest
        Scanner scanner = new Scanner(System.in);
        
        // Alternativ: Scanner für Dateien
        // Scanner dateiScanner = new Scanner(new File("daten.txt"));
    }
}
```

### Scanner verwenden

```java
import java.util.Scanner;

public class ScannerVerwendung {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // Text einlesen
        System.out.print("Wie heißt du? ");
        String name = scanner.nextLine();
        
        // Ganzzahl einlesen
        System.out.print("Wie alt bist du? ");
        int alter = scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch nach nextInt() konsumieren
        
        // Fließkommazahl einlesen
        System.out.print("Wie groß bist du (in Metern)? ");
        double groesse = scanner.nextDouble();
        scanner.nextLine(); // Zeilenumbruch konsumieren
        
        // Boolean einlesen
        System.out.print("Magst du Programmieren? (true/false) ");
        boolean magProgrammieren = scanner.nextBoolean();
        
        // Ausgabe der eingelesenen Werte
        System.out.println("\nDeine Eingaben:");
        System.out.println("Name: " + name);
        System.out.println("Alter: " + alter);
        System.out.println("Größe: " + groesse + " m");
        System.out.println("Mag Programmieren: " + magProgrammieren);
        
        // Scanner schließen
        scanner.close();
    }
}
```
