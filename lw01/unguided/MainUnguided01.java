import java.util.Scanner;

public class MainUnguided01 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(MainUnguided01.class.getResourceAsStream("washes.txt"));
        int size = scanner.nextInt();
        WashService[] wash = new WashService[size];

        for (int i = 0; i<size;i++){
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if(type.equals("MOTORCYCLE")){
                wash[i] = new MotorcycleWash(id, days);
            } else if (type.equals("CAR")) {
                wash[i] = new CarWash(id, days);
            }

            System.out.println(wash[i].summary(units));
        }

        scanner.close();

    }
}
