package lesson1;

public class Treadmill implements Lets {
    private double size;
    private boolean success;

    public boolean result() {
        return this.success;
    }

    public Treadmill(double size) {
        this.size = size;
    }

    public void doAction(double valSize) {
        String message = valSize > this.size ? "Беговую дорожку предолел" : "Беговую дорожку не преодолел";
        this.success = valSize > this.size;
        System.out.println(message);
    }
}
