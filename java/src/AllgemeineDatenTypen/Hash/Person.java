package AllgemeineDatenTypen.Hash;

public record Person(int id, String name, int age) {
    @Override
    public String toString() {
        return  String.format("Person{" + "id=%d, name=&s, age=&d}", this.id, this.name, this.age);
    }
}
