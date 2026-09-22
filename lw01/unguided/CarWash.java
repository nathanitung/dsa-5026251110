public class CarWash extends WashService{

        public CarWash(String id, int days){
            super(id, days);
        }

        public int calculateCharge(){
            if(getDays()>3){
                return 105000 + ((getDays()-3) *25000) + 15000;
            }else {
                return getDays()*15000;
            }
        }

        public String label(){
            return "CAR";
        }


}
