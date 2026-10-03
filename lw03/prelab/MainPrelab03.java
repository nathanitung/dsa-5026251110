import java.util.*;

public class MainPrelab03 {
    public static void main(String[] args){
        problemOne();
        System.out.println();
        problemTwo();
        System.out.println();
        problemThree();
    }

    static void problemOne(){
        Scanner scanner = new Scanner(MainPrelab03.class.getResourceAsStream("playlist.txt"));
        List<String> song = new LinkedList<>();
        while(scanner.hasNext()){
            String inputType = scanner.next();

            if(inputType.equals("ADD")){
                song.add(scanner.nextLine());
            } else if (inputType.equals("INSERT")) {
                song.add(scanner.nextInt(), scanner.nextLine());
            } else if (inputType.equals("REMOVE")) {
                song.remove(scanner.nextLine());
            }
        }
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + song.size());
        int num = 1;
        for(String s : song){
            System.out.println(num++ + ": " + s);
        }
        scanner.close();
    }
    static void problemTwo(){
        Scanner scanner = new Scanner(MainPrelab03.class.getResourceAsStream("participant.txt"));

        Set<String> name = new LinkedHashSet<>();
        int duplicate = 0;

        while(scanner.hasNext()){
            String temp = scanner.next();

            if(name.contains(temp)){
                duplicate++;
            } else {
                name.add(temp);
            }
        }

        System.out.println("=== Problem 2 ===");
        System.out.println("Unique participants: " + name.size());
        int num = 1;
        for(String s : name){
            System.out.println(num++ + ": " + s);
        }
        System.out.println("Duplicate registrations: " + duplicate);
        scanner.close();
    }

    static void problemThree(){
        Scanner scanner = new Scanner(MainPrelab03.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> product = new LinkedHashMap<>();
        int failed = 0;
        while(scanner.hasNext()){
            String op = scanner.next();
            String obj = scanner.next();
            int count = scanner.nextInt();

            if(op.equals("ADD")){
                if(!product.containsKey(obj)){
                    product.put(obj, count);
                } else {
                    product.replace(obj, product.get(obj) + count);
                }
            } else if (op.equals("SELL")) {
                if(product.containsKey(obj) && count <= product.get(obj)){
                    product.replace(obj, product.get(obj) - count);
                } else if(!product.containsKey(obj) || count > product.get(obj)){
                    failed++;
                }
            }
        }
        System.out.println("=== Problem 3 ===");
        for(String s : product.keySet()){
            System.out.println(s + ": " + product.get(s));
        }
        System.out.println("Failed sales: " + failed);
        scanner.close();

    }
}