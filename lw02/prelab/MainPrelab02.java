import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MainPrelab02 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(MainPrelab02.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transaction = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();
        LinkedList<String> customername = new LinkedList<>();

        Stack<String[]> failedTransaction = new Stack<>();

        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            String s3 = scanner.next();
            String[] arr = new String[3];
            arr[0] = s1;
            arr[1] = s2;
            arr[2] = s3;
            transaction.add(arr);

            String[] array = new String[2];

            if(!customername.contains(s1)){
                customer.add(new String[]{s1, "0"});
                customername.add(s1);
            }


        }

        Queue<String[]> queue = new LinkedList<>(transaction);

        while (!queue.isEmpty()){
            String[] curr = queue.poll();
            String name = curr[0];
            String type = curr[1];
            int amount = Integer.parseInt(curr[2]);

            int custIndex =-1 ;
            String[] custAcc = new String[2];

            for(int i = 0; i<customer.size(); i++){
                String[] temp = customer.get(i);
                if (temp[0].equals(name)){
                    custIndex = i;
                    custAcc = temp;
                }
            }

            if(type.equals("DEPOSIT")){
                int before = Integer.parseInt(custAcc[1]);
                int after = before + amount;
                custAcc[1] = Integer.toString(after);
                customer.set(custIndex, custAcc);
            } else if (type.equals("WITHDRAW")) {
                if (amount > Integer.parseInt(custAcc[1])) {
                    failedTransaction.push(curr);
                } else {
                    int before = Integer.parseInt(custAcc[1]);
                    int after = before - amount;
                    custAcc[1] = Integer.toString(after);
                    customer.set(custIndex, custAcc);
                }
            }
        }


        System.out.println("=== Final Balances ===");
        for (String[] arr : customer){
            System.out.println(arr[0] + " : " + arr[1]);
        }
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failedTransaction.isEmpty()) {
            String[] arr = failedTransaction.pop();
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        scanner.close();

    }
}
