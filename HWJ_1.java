/*
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!) */

package Java_lessons.HWJ_lesson_1;
import java.net.SocketImpl;
import java.net.SocketPermission;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Random;
import javax.swing.plaf.synth.SynthToggleButtonUI;

public class HWJ_1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        System.out.println("Случайное число i: " + i);
        
        int n = highestBitNumber(i);
        System.out.println("Номер старшего бита n: " + n);
        
        if (n != 0){
            System.out.println("Элементы массива m1: ");
            int[] m1 = divisiblesInRange(i, Short.MAX_VALUE, n);
            
            System.out.println("Элементы массива m2: ");        
            int[] m2 = divisiblesInRange(Short.MIN_VALUE, i, n, true);
        }
    }


    static int highestBitNumber(int num){
        int result = 0;
        while (num > 0){
            num >>= 1;
            result++;
        }
        return result;
    }

    static int[] divisiblesInRange (int start, int end, int divider, boolean indivisiblesInstead){
        int resLength = 0;
        for (int i = start; i <= end; i++){
            if (i % divider == 0 ^ indivisiblesInstead) resLength++;
        }
        int[] result = new int[resLength];
        for (int i = start, j = 0; i <= end; i++){
            if (i % divider == 0 ^ indivisiblesInstead){
                result[j] = i;
                j++;
            }
        }
        for (int j = 0; j < result.length - 1; j++){
            if (j > 9 && j < result.length - 10){
                System.out.print("... ");
                j = result.length - 11;
            }
            else System.out.print(result[j] + ", ");
        }
        if (result.length > 0) System.out.println(result[result.length - 1]);
        return result;
    }

    static int[] divisiblesInRange (int start, int end, int divider){
        return divisiblesInRange (start, end, divider, false);
    }
}