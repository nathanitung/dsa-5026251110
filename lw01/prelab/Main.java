package prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        List<PrintJob> jobs = new ArrayList<>();

        while(scanner.hasNext()){
            String type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();
            
            if(type.equals("MONO")){
                jobs.add(new MonoPrint(id, pages));
            } else if(type.equals("COLOUR")){
                jobs.add(new ColourPrint(id, pages));
            } else {
                System.out.println("Unknown print job type: " + type);
            }

        }  

        for(PrintJob job : jobs){
            System.out.println(job.summary());
        }
        

        scanner.close();

    }
}
