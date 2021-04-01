import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in, "UTF-8");
        int num;
        System.out.print("Введите число:");
        num = in.nextInt();

        int[] array = getFilledArray(num, 2, (x, y) -> x + y);
        System.out.println(Arrays.toString(array));
        array = getFilledArray(num, 2, (x, y) -> x * y);
        System.out.println(Arrays.toString(array));
        array = getFilledArray(num, 2, (x, y) -> {
            if (x % 2 == 0) {
                return x / 2 + y;
            } else {
                return x * x - y;
            }
        });
        System.out.println(Arrays.toString(array));

        array = getFilledArray(num, -1, (x, y) -> x + y);
        System.out.println(Arrays.toString(array));
        array = getFilledArray(num, -1, (x, y) -> x * y);
        System.out.println(Arrays.toString(array));
        array = getFilledArray(num, -1, (x, y) -> {
            if (x % 2 == 0) {
                return x / 2 + y;
            } else {
                return x * x - y;
            }
        });
        System.out.println(Arrays.toString(array));

        // мои методы
        // модификатор в степени индекса
        array = getFilledArray(num, 2, (x, y) -> ((Double) Math.pow(y, x)).intValue());
        System.out.println(Arrays.toString(array));
        // високосные года, начиная с 2000
        // модификатор + 4 * индекс
        array = getFilledArray(num, 2000, (x, y) -> y + 4 * x);
        System.out.println(Arrays.toString(array));
    }

    static int[] getFilledArray(final int size, final int modificator, final Processable p) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = p.process(i, modificator);
        }
        return array;
    }
}
