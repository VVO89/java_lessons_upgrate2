package lesson1;

public class Robot implements Actions {
    private final double LIMIT_SIZE_RUN = 30.0D;
    private final double LIMIT_SIZE_JUMP = 50.0D;
    private String name;
    private double sizeRun;
    private double sizeJump;

    public String getname() {
        return this.name;
    }

    public double getsizeRun() {
        return this.sizeRun;
    }

    public double getsizeJump() {
        return this.sizeJump;
    }

    public Robot(double sizeRun, double sizeJump, String name) {
        this.name = name;
        this.sizeRun = sizeRun;
        this.sizeJump = sizeJump;
    }

    public void run(double size) {
        double robotSize = 0.0D;
        if (this.sizeRun > 30.0D) {
            robotSize = 30.0D;
        } else {
            robotSize = this.sizeRun;
        }

        String message = robotSize > size ? this.name.concat(" Успешно пробежал") : this.name.concat("Не смог пробежать");
        System.out.println(message);
    }

    public void jump(double size) {
        double robotSize = 0.0D;
        if (this.sizeJump > 50.0D) {
            robotSize = 50.0D;
        } else {
            robotSize = this.sizeJump;
        }

        String message = robotSize > size ? this.name.concat(" Успешно перепрыгнул") : this.name.concat(" Не смог перепрыгнуть");
        System.out.println(message);
    }
}
