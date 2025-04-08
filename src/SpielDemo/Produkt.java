package SpielDemo;

public class Produkt {
    protected String name;
    protected int price;
    protected String seltenheit;
    protected int weight;
    protected int amount;
    protected int heilWert;
    protected int damage;

    public Produkt(String name, int price, String seltenheit, int weight, int amount) {
        this.name = name;
        this.price = price;
        this.seltenheit = seltenheit;
        this.weight = weight;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSeltenheit() {
        return seltenheit;
    }

    public int getWeight() {
        return weight;
    }

    public void decreaseAmount() {
        this.amount--;
    }

    public void increaseAmount() {
        this.amount++;
    }

    public void setHeilWert(int heilWert) {
        this.heilWert = heilWert;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHeilWert() {
        return heilWert;
    }

    public int getDamage() {
        return damage;
    }
}
