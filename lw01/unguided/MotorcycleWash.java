public class MotorcycleWash extends WashService{

    public MotorcycleWash(String id, int days){
        super(id, days);
    }

    public int calculateCharge(){
        return getDays() * 15000 + 5000;
    }

    public String label(){
        return "MOTORCYCLE";
    }
}
