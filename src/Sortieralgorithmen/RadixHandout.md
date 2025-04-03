# Radix Sort Handout

## **Einführung**
Radix Sort ist ein nicht-vergleichender, stabiler Sortieralgorithmus. Er sortiert Zahlen anhand ihrer Ziffernstellen von der niederwertigsten bis zur höchstwertigen Stelle. Dabei werden die Zahlen in Buckets einsortiert und danach in neuer Reihenfolge ausgegeben.

**Komplexität:**
- **Zeit:** O(n * k), wobei k die Anzahl der Ziffern der größten Zahl ist.
- **Speicher:** Zusätzlicher Platz für Buckets erforderlich.

Radix Sort ist besonders effizient für große Datensätze mit Zahlen ähnlicher Länge, da er nicht auf Vergleichsoperationen angewiesen ist.

---

## **Funktionsweise (Beispiel)**
Gegebenes Array:
```
124, 523, 483, 128, 923, 584, 009, 054
```
**1. Sortieren nach der letzten Ziffer:**
```
| 0-9  | Zahlen        |
|------|---------------|
| 0    |               |
| 1    |               |
| 2    | 124           |
| 3    | 523, 483      |
| 4    |               |
| 5    |               |
| 6    |               |
| 7    |               |
| 8    | 128           |
| 9    | 923, 009, 054 |
```

**2. Sortieren nach der mittleren Ziffer:**
```
| 0-9  | Zahlen        |
|------|---------------|
| 0    | 009           |
| 1    | 124, 128      |
| 2    |               |
| 3    | 523, 483      |
| 4    | 054           |
| 5    |               |
| 6    |               |
| 7    |               |
| 8    | 584           |
| 9    | 923           |
```

**3. Sortieren nach der ersten Ziffer:**
```
009, 054, 124, 128, 483, 523, 584, 923
```

---

## **Vergleich der Laufzeit in Abhängigkeit von der Eingabe**
| Eingabegröße | Array-Typ          | Zeit (ms) | Vergleiche | Swaps  |
|--------------|--------------------|-----------|-----------|--------|
| 10           | Zufällig           | 1,21      | 57        | 30     |
| 100          | Zufällig           | 0,06      | 327       | 300    |
| 1000         | Zufällig           | 0,50      | 3027      | 3000   |
| 10           | Sortiert           | 0,01      | 19        | 10     |
| 100          | Sortiert           | 0,03      | 218       | 200    |
| 1000         | Sortiert           | 0,37      | 3027      | 3000   |
| 10           | Reverse Sorted     | 0,01      | 19        | 10     |
| 100          | Reverse Sorted     | 0,03      | 218       | 200    |
| 1000         | Reverse Sorted     | 0,37      | 3027      | 3000   |
| 10           | Mit Duplikaten     | 0,01      | 19        | 10     |
| 100          | Mit Duplikaten     | 0,02      | 109       | 100    |
| 1000         | Mit Duplikaten     | 0,14      | 1009      | 1000   |
| 10           | Teilweise sortiert | 0,01      | 19        | 10     |
| 100          | Teilweise sortiert | 0,03      | 218       | 200    |
| 1000         | Teilweise sortiert | 0,39      | 3027      | 3000   |

---

## **Big-O-Notation**
- **Best Case:** O(n) – wenn alle Zahlen nur eine Ziffer haben.
- **Average Case:** O(n * k) – normale Zahlenverteilung.
- **Worst Case:** O(n * k) – wenn die größte Zahl genauso viele Ziffern hat, wie sie groß ist.

---

## **Fazit**
 **Vorteile:**
- Keine Vergleichsoperationen nötig.
- Stabiler Algorithmus (relative Reihenfolge bleibt erhalten).
- Effizient bei vielen Duplikaten.

 **Nachteile:**
- Benötigt zusätzlichen Speicher.
- Nicht für negative Zahlen direkt geeignet.
- Bei sehr großen Zahlen kann k groß werden, wodurch der Algorithmus ineffizient wird.

**Wann Radix Sort verwenden?**
- Wenn Zahlen in einem engen Bereich liegen.
- Wenn Stabilität eine wichtige Rolle spielt.
- Wenn Vergleiche teuer sind (z. B. Strings oder große Zahlen).

---

Das Handout bietet eine vollständige Übersicht über Radix Sort mit Erklärungen, Beispielen und Performance-Daten. Falls du noch eine visuelle Darstellung möchtest, könnte eine Schritt-für-Schritt-Grafik helfen! 😊

