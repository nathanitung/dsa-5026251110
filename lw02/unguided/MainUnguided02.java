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
        drink.add(new String[]{"EsJEruk", "2"});

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
            boolean bool = true;

            //cek makanan
            switch (arr[1]){
                case "Bakso":
                    String[] bakso = food.get(0);
                    if(!bakso[1].equals("0")){
                        bakso[1] = Integer.toString(Integer.parseInt(bakso[1]) - 1);
                    } else {
                        bool = false;
                    }
                    break;
                case "Sate":
                    String[] sate = food.get(1);
                    if(!sate[1].equals("0")){
                        sate[1] = Integer.toString(Integer.parseInt(sate[1]) - 1);
                    } else {
                        bool = false;
                    }
                    break;
                case "Soto":
                    String[] soto = food.get(2);
                    if(!soto[1].equals("0")){
                        soto[1] = Integer.toString(Integer.parseInt(soto[1]) - 1);
                    } else {
                        bool = false;
                    }
                    break;
            }

            //cek minum
            switch (arr[2]) {
                case "EsTeh":
                    String[] esteh = drink.get(0);
                    if (!esteh[1].equals("0")) {
                        esteh[1] = Integer.toString(Integer.parseInt(esteh[1]) - 1);
                    } else {
                        bool = false;
                    }
                    break;
                case "EsJeruk":
                    String[] esjeruk = drink.get(1);
                    if(!esjeruk[1].equals("0")){
                        esjeruk[1] = Integer.toString(Integer.parseInt(esjeruk[1]) - 1);
                    } else {
                        bool = false;
                    }
                    break;
            }

            if(bool){
                success.add(arr);
            } else {
                failed.add(arr);
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
