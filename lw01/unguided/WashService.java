public abstract class WashService implements Billable{
    private String id;
    private int days;

    protected WashService(String id, int days){
        if (days <= 0) {
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0.");
        } else if (days > 30) {
            throw new IllegalArgumentException("Jumlah hari tidak boleh lebih dari 30.");
        }
        this.id = id;
        this.days = days;
    }

    public String getId(){
        return getId();
    }

    public int getDays() {
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units){
        return units * calculateCharge();
    }

    public String label(){
        return "Service";
    }

    public String summary(int units){
        return id + " | " + label() + " | " + calculateCharge(units);
    }


}
