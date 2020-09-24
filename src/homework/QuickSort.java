package homework;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println(arrayToString(array));
        quickSort(array,0,array.length-1);
    }


    private static int[] createArray() {
        List<Integer> numbers = new ArrayList<>();
        boolean isFinish = false;
        try(Scanner scan = new Scanner(System.in)) {
            do {
                System.out.println("Input some digit or \"0\" to open exit menu: ");
                int input = scan.nextInt();
                if (input == 0) {
                    System.out.println("Input \"1\" to finish or \"2\" to add \"0\" to array:");
                    int inputAnswer = scan.nextInt();
                    switch (inputAnswer){
                        case 1: isFinish=true;
                                break;
                        case 2: numbers.add(input);
                                System.out.println("Your array is next: ");
                                System.out.println(numbers);
                                break;
                        default:
                            System.out.println("Incorrect input data!");
                    }
                } else {
                    numbers.add(input);
                    System.out.println("Your array is next: ");
                    System.out.println(numbers);
                }
            } while (!isFinish);
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect input data. Please, try again! Use only digits");
        }
            int[] arr = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                arr[i] = numbers.get(i);
            }
        return arr;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            printSortStep(arr,begin,end,partitionIndex);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);

        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.println("\npartition element is " + arr[partitionIndex]);
        System.out.println("partition at index: " + partitionIndex);
        System.out.print("left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)));
        System.out.print(arrayToString(arr) + "\n");
    }
}
