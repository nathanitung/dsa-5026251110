import java.util.Scanner;

public class MainUnguided04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(MainUnguided04.class.getResourceAsStream("parcels.txt"));

        int N = scanner.nextInt();
        int[] parcels = new int[N];
        for (int i = 0; i < N; i++) {
            parcels[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = scanner.nextInt();
        }

        scanner.close();

        int[] after2Passes = new int[N];

        bubbleSort(parcels);
        System.out.println();
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for (int parcel : parcels) {
            System.out.print(parcel + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int target : targets) {
            binarySearch(parcels, target);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (i == 1) {
                System.out.println("==== After 2 Passes ====");
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k] + " ");
                }

            }
        }

    }
    public static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;
        int foundIndex = -1;

        while (low<=high) {
            steps++;
            int mid=(low + high) / 2;

            if (arr[mid]==target) {
                foundIndex=mid;
                break;
            } else if (arr[mid] < target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        if (foundIndex != -1) {
            System.out.println(target+ ": FOUND at index " +foundIndex + " (steps: " + steps + ")");
        } else {
            System.out.println(target+": NOT FOUND (steps: "+ steps + ")");
        }
    }
}
