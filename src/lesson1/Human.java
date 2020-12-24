
package lesson1;

public class Human implements Actions{
    private final double LIMIT_SIZE_RUN = 10;
    private final double LIMIT_SIZE_JUMP = 20;
    private String name;
    private double sizeRun;
    private double sizeJump;

    public Human(double sizeRun, double sizeJump, String name) {
        this.name = name;
        this.sizeRun = sizeRun;
        this.sizeJump = sizeJump;
    }

    public String getname() {
        return this.name;
    }

    public double getsizeRun() {
        return this.sizeRun;
    }

    public double getsizeJump() {
        return this.sizeJump;
    }

    public void run(double size) {
        double humanSize = 0.0D;
        if (this.sizeRun > 10.0D) {
            humanSize = 10.0D;
        } else {
            humanSize = this.sizeRun;
        }

        String message = humanSize > size ? this.name.concat(" Успешно пробежал") : this.name.concat(" Не смог пробежать");
        System.out.println(message);
    }

    public void jump(double size) {
        double humanSize = 0.0D;
        if (this.sizeJump > 20.0D) {
            humanSize = 20.0D;
        } else {
            humanSize = this.sizeJump;
        }

        String message = humanSize > size ? this.name.concat(" Успешно перепрыгнул") : this.name.concat(" Не смог перепрыгнуть");
        System.out.println(message);
    }
}
