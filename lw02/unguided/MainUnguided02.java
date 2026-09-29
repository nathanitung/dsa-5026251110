import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MainUnguided02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(MainUnguided02.class.getResourceAsStream("orders.txt"));
        LinkedList<String[]> order = new LinkedList<>();
        LinkedList<String[]> food = new LinkedList<>();
        LinkedList<String[]> drink = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        food.add(new String[]{"Bakso", "2"});
        food.add(new String[]{"Sate", "1"});
        food.add(new String[]{"Soto", "2"});
        drink.add(new String[]{"EsTeh", "4"});
        drink.add(new String[]{"EsJeruk", "2"});

        while (scanner.hasNext()){
            String[] arr = new String[4];
            arr[0] = scanner.next();
            arr[1] = scanner.next();
            arr[2] = scanner.next();
            arr[3] = scanner.next();

            order.add(arr);
        }
        queue.addAll(order);

        while(!queue.isEmpty()){
            String[] arr = queue.poll();
            String foodName = arr[1];
            String drinkName = arr[2];

            String[] orderedFood = null;
            String[] orderedDrink = null;

            boolean foodAvailable = true;
            boolean drinkAvailable = true;

            if (!foodName.equals("-")) {
                for (String[] f : food) {
                    if (f[0].equals(foodName)) {
                        orderedFood = f;
                        break;
                    }
                }
                if (orderedFood == null || Integer.parseInt(orderedFood[1]) <= 0) {
                    foodAvailable = false;
                }
            }

            if (!drinkName.equals("-")) {
                for (String[] d : drink) {
                    if (d[0].equals(drinkName)) {
                        orderedDrink = d;
                        break;
                    }
                }
                if (orderedDrink == null || Integer.parseInt(orderedDrink[1]) <= 0) {
                    drinkAvailable = false;
                }
            }

            if (foodAvailable && drinkAvailable) {
                if (orderedFood != null) {
                    int s = Integer.parseInt(orderedFood[1]);
                    orderedFood[1] = Integer.toString(s - 1);
                }
                if (orderedDrink != null) {
                    int s = Integer.parseInt(orderedDrink[1]);
                    orderedDrink[1] = Integer.toString(s - 1);
                }
                success.add(arr);
            } else {
                failed.push(arr);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for(String[] arr : success){
            System.out.println(arr[0] + " " +arr[1] + " " +arr[2] + " " +arr[3]);
        }
        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for(String[] arr : food){
            System.out.println(arr[0] + " : " +arr[1] );
        }
        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for(String[] arr : drink){
            System.out.println(arr[0] + " : " +arr[1] );
        }
        System.out.println();
        System.out.println("=== Failed Orders ===");
        while(!failed.isEmpty()){
            String[] arr = failed.pop();
            System.out.println(arr[0] + " " +arr[1] + " " +arr[2] + " " +arr[3]);
        }

    }
}