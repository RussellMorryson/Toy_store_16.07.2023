public class Toy {
    private Integer id;
    private String name;
    private Integer weight;
    public static int count = 101;

    public Toy(String name, Integer weight) {
        this.id = count++;
        this.name = name;
        this.weight = weight;
    } 

    @Override
    public String toString() {
        return String.format(new StringBuilder().append("\tId: %d, весомость: %d, название: %s").toString(), id, weight, name);
    }

    public int getID() { return this.id; }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getWeight()  { return this.weight; }
    public void setWeight(int value) { this.weight = value; }

    public boolean containsID(Integer value) {
        if (Toy.this.id == value) return true;
        else return false;
    }    
}