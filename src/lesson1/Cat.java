
package lesson1;

public class Cat implements Actions {
    private final double LIMIT_SIZE_RUN = 10.0D;
    private final double LIMIT_SIZE_JUMP = 10.0D;
    private String name;
    private double sizeRun;
    private double sizeJump;

    public String getname() {
        return this.name;
    }

    public Cat(double sizeRun, double sizeJump, String name) {
        this.name = name;
        this.sizeRun = sizeRun;
        this.sizeJump = sizeJump;
    }

    public void run(double size) {
        double catSize = 0.0D;
        if (this.sizeRun > 10.0D) {
            catSize = 10.0D;
        } else {
            catSize = this.sizeRun;
        }

        String message = catSize > size ? this.name.concat(" Успешно пробежал") : this.name.concat(" Не смог пробежать");
        System.out.println(message);
    }

    public void jump(double size) {
        double catSize = 0.0D;
        if (this.sizeJump > 10.0D) {
            catSize = 10.0D;
        } else {
            catSize = this.sizeJump;
        }

        String message = catSize > size ? this.name.concat(" Успешно перепрыгнул") : this.name.concat(" Не смог перепрыгнуть");
        System.out.println(message);
    }

    public double getsizeRun() {
        return this.sizeRun;
    }

    public double getsizeJump() {
        return this.sizeJump;
    }
}
