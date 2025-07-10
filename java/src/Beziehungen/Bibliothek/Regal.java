package Beziehungen.Bibliothek;

import java.util.ArrayList;
import java.util.List;

public class Regal {
    private final List<Buch> buecher = new ArrayList<>();

    public void hinzufuegenBuecher(Buch buch) {
        buecher.add(buch);
    }

    // Getter
    public List<Buch> getBuecher() {
        return buecher;
    }
}