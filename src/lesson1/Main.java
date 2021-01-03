package lesson1;

public class Main {

    public static void main(String[] args) {

        // собираем команду (массив)
        Actions[] team = new Actions[3];
        team[0] = new Cat(3, 5, "Кот");
        team[1] = new Human(4,6, "Человек");
        team[2] = new Robot(10, 20, "Робот");

        // собираем трассу (массив)
        Lets[] trace = new Lets[2];
        trace[0] = new Treadmill(5);
        trace[1] = new Wall(15);

        // прохождение трассы
        for(int i = 0; i < team.length; ++i) {
            String name = team[i].getname();

            for(int j = 0; j < trace.length; ++j) {
                double size = j == 0 ? team[i].getsizeRun() : team[i].getsizeJump();
                trace[j].doAction(size);
                if (!trace[j].result()) {
                    System.out.println(name.concat(" Сошел с дистанции!"));
                    break;
                }
            }
        }

    }
}
