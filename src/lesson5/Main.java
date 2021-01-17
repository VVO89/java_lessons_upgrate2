package lesson5;

import java.util.concurrent.TimeUnit;

public class Main {

    protected static final int SIZE = 10000000;
    protected static final int HALF = SIZE / 2;
    protected static float[] arr1 = new float[SIZE];
    protected static float[] arr2 = new float[SIZE];
    protected static float[] arr2_1 = new float[HALF];
    protected static float[] arr2_2 = new float[HALF];

    public static void main(String[] args) throws Exception {

        Thread thr1 = new Thread(new myCalculate1());
        thr1.start();

        Thread thr2 = new Thread(new myCalculate2());
        thr2.start();
    }

    static class myCalculate1 extends Thread implements Runnable {

        @Override
        public void run() {
            try {
                // заполнени массива единицами
                fillingArr(arr1);
                // вычисление элементов массива по формуле
                long start = System.currentTimeMillis();
                CalculateArr(arr1, SIZE);
                long end = System.currentTimeMillis();
                System.out.printf("Время заполнения 1 вариант %s миллисекунд %n", end - start);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class myCalculate2 extends Thread implements Runnable {

        @Override
        public void run() {
            try {
                //float[] arr = new float[SIZE];
                //long start = System.currentTimeMillis();
                // заполнение единицами
                fillingArr(arr2);
                // алгоритм заполнения
                Calculate2(arr2);
                //long end = System.currentTimeMillis();
                //System.out.printf("Время выполнения потока 2 %s%n", end - start);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class myCalculate2_1 extends Thread implements Runnable {

        @Override
        public void run() {

            try {
                // Вычисление элементов массива
                CalculateArr(arr2_1, HALF);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    static class myCalculate2_2 extends Thread implements Runnable {
        @Override
        public void run() {
            try {
                // Вычисление элементов массива
                CalculateArr(arr2_2, HALF);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // заполнение массива единицами, расчет нового значения
    private static void fillingArr(float[] arr) {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

    }

    private static void CalculateArr(float[] arr, int sizeArr) {
        // расчет новых значений
        for (int i = 0; i < sizeArr; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void Calculate2(float[] arr) {

        System.out.println("Разбиваем массив на 2 массива");

        long start2 = System.currentTimeMillis();
        // разбиваем на 2 массива
        long startBreak = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr2_1, 0, HALF);
        System.arraycopy(arr, HALF, arr2_2, 0, HALF);
        long endBreak = System.currentTimeMillis();
        System.out.printf("Время выполнения разбивки %s миллисекунд %n", endBreak - startBreak);

        System.out.println("Заполняем первый массив");
        // Создаем 2 ранее объявленных потока
        long startThr2_1 = System.currentTimeMillis();
        Thread thr2_1 = new Thread(new myCalculate2_1());
        thr2_1.start();
        long endThr2_1 = System.currentTimeMillis();
        System.out.printf("Время заполнения 1 массива %s миллисекунд %n", endThr2_1 - startThr2_1);

        long startThr2_2 = System.currentTimeMillis();
        Thread thr2_2 = new Thread(new myCalculate2_2());
        thr2_2.start();
        long endThr2_2 = System.currentTimeMillis();
        System.out.printf("Время заполнения 2 массива %s миллисекунд %n", endThr2_2 - startThr2_2);

        System.out.println("Обратно склеиваем массив");
        // обратная склейка 2 массивов
        long startGluing = System.currentTimeMillis();
        System.arraycopy(arr2_1, 0, arr, 0, HALF);
        System.arraycopy(arr2_2, 0, arr, HALF, HALF);
        long endGluing = System.currentTimeMillis();
        System.out.printf("Время выполнения склейки %s миллисекунд %n", endGluing - startGluing);

        long end2 = System.currentTimeMillis();
        System.out.printf("Время заполнения 2 вариант %s миллисекунд %n", end2 - start2);

    }
}
