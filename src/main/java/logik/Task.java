package logik;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Task {

    public void runTask(){
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    private void task7() {
//        7. **** Написать метод, которому на вход подается одномерный массив и число n
// (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("Задание № 7");
        Random rn = new Random();
        int[] array = new int[rn.nextInt(8) + 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
        }

        System.out.println("Исходный массив: \n" + Arrays.toString(array));
        int n = rn.nextInt(2 * array.length) - array.length;
        array = shifter(array, n);
        System.out.println("Измененный массив: \n" + Arrays.toString(array));
        System.out.println("Сдвиг на " + n + " элементов");
    }

    private int[] shifter(int[] array, int n) {
        int temp = 0;

        if (n > 0) {
            for (int j = 0; j < array.length - 1; j++) {
                temp = array[j];
                array[j] = array[array.length - 1];
                array[array.length - 1] = temp;
            }
            n--;
        }

        if (n < 0) {
            for (int j = array.length - 1; j > 0; j--) {
                temp = array[j];
                array[j] = array[0];
                array[0] = temp;
            }
            n++;
        }

        if (n != 0) {
            array = shifter(array, n);
        }

        return array;
    }


    private void task6() {
//        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
//
// Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
// checkBalance ([2, 1, 1, 2, 1]) → false,
// checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.

        System.out.println("Задание № 6");
        Random rn = new Random();
        int[] array = new int[rn.nextInt(13) + 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(11);
        }
        System.out.println("Заданный массив: \n" + Arrays.toString(array));

        if (isBalance(array)) {
            System.out.println("сбалансирован");
        }
        else {
            System.out.println("не сбалансирован");
        }
    }

    private boolean isBalance(int[] array) {
        int summOne = 0;
        int summTwo = 0;
        boolean cond = false;

        int middle = 0;

        if ((array.length % 2) == 0){
            middle = Math.round(array.length / 2);
        }
        else {
            middle = Math.round(array.length / 2) + 1;
        }

        for (int i = 0; i < middle; i++) {
            summOne += array[i];
            summTwo += array[array.length - i - 1];
        }

        if ((array.length % 2) != 0){
            summTwo -= array[middle];
        }

        if (summOne == summTwo) {
            cond = true;
        }
        else cond = false;

        return cond;
    }

    private void task5() {
//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание № 5");
        Random rn = new Random();
        int[] array = new int[rn.nextInt(13) + 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
        }
        System.out.println("Задан массив: \n" + Arrays.toString(array));

        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println("минимальный элемент:" + min);
        System.out.println("максилальный элемент: "+ max);
    }

    private void task4() {
//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание № 4");

        Random rn = new Random();
        int arrayLength = rn.nextInt(13) + 2;

        int[][] array = new int[arrayLength][arrayLength];

        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }

        System.out.println("Полученный массив с размерностью " + arrayLength + "х" + arrayLength +" :");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private void task3() {
//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание № 3");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: \n" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6 ){
                array[i] *=2;
            }
        }
        System.out.println("Полученный массив: \n" + Arrays.toString(array));
    }

    private void task2() {
//        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание № 2");

        int[] array = new int[8];

        for (int i = 0; i < array.length; i++) {
            array[i] = i*3;
        }

        System.out.println("Полученный массив: \n" + Arrays.toString(array));
    }

    private void task1() {
        System.out.println("Задание № 1");
        
        int[] array = new int[10];

        Random rn = new Random();
        for (int i = 0; i < array.length ; i++) {
            array[i] = rn.nextInt(2);
        }
        System.out.println("Исходный массив: \n" + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0){
                array[i] = 1;
            }
            else {
                array[i] = 0;
            }
        }
        System.out.println("Измененный массив: \n" + Arrays.toString(array));
    }
}

