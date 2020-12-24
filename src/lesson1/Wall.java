package lesson1;

public class Wall implements Lets {
    private double size;
    private boolean success;

    public Wall(double size) {
        this.size = size;
    }

    public void doAction(double valSize) {
        String message = valSize > this.size ? "Стену предолел" : "Стену не преодолел";
        this.success = valSize > this.size;
        System.out.println(message);
    }

    public boolean result() {
        return this.success;
    }
}
