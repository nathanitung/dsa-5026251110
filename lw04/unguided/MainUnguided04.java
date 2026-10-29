import java.util.Scanner;

public class MainUnguided04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(MainUnguided04.class.getResourceAsStream("branches.txt"));

        int N = scanner.nextInt();
        int[] branches = new int[N];

        for(int i = 0; i<N; i++){
            branches[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] stabilityValues = new int[M];

        for(int i = 0; i< M; i++){
            stabilityValues[i] = scanner.nextInt();
        }

        insertionSort(branches);

        for(int num : branches){
            System.out.print(num + " ");
        }
        System.out.println();

        for (int target : stabilityValues){
            int index = linearSearch(branches, target);
            if(index == -1){
                System.out.println(target + ": NOT FOUND");
            } else {
                System.out.println(target + ": FOUND at index " + index);
            }
        }

    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < 4; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int linearSearch(int[] arr, int target) {
        int index = -1;
        for(int i = 0; i<arr.length; i++){
            if( arr[i] == target){
                index = i;
                break;
            }
        }
        return index;
    }
}
