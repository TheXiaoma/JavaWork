import java.util.Arrays;
import java.util.Random;

public class ArrayCopier {
    public static void main(String[] args) {
        int[] oldArr = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            oldArr[i] = random.nextInt(100);
        }
        int[] newArray = copyArray(oldArr);
        System.out.println("oldArr: " + Arrays.toString(oldArr));
        System.out.println("newArray: " + Arrays.toString(newArray));
    }

    public static int[] copyArray(int[] arrayOne) {
        int[] newArray = new int[arrayOne.length];
        for (int i = 0; i < arrayOne.length; i++) {
            newArray[i] = arrayOne[i];
        }
        return newArray;
    }
}