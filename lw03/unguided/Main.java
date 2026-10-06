package unguided;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scanner1 = new Scanner(Main.class.getResourceAsStream("registrations.txt")), scanner2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> reg = new LinkedHashSet<>(), check = new LinkedHashSet<>();
        int reject = 0 ;

        while(scanner1.hasNext()){
            reg.add(scanner1.next());
        }

        System.out.println("===== Event Check-In Results =====");
        while(scanner2.hasNext()){
            String id = scanner2.next();
            if(reg.contains(id) && !check.contains(id)){
                check.add(id);
                System.out.println(id + ": Checked in");
            } else {
                String failed = reg.contains(id) && check.contains(id) ? ": Rejected (already checked in)" : ": Rejected (not registered)";
                System.out.println(id + failed);
                reject++;
            }
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + reg.size());
        System.out.println("Successful check-ins: " + check.size());
        System.out.println("Absent students: "+ (reg.size() - check.size()));
        System.out.println("Rejected attempts: "+reject);

        scanner1.close();
        scanner2.close();
    }
}