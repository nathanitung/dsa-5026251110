

public abstract class PrintJob implements Chargeable  {
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Jumlah lembar harus lebih dari 0.");
        } else if (pages > 100) {
            throw new IllegalArgumentException("Jumlah lembar tidak boleh lebih dari 100.");
        }
        
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }
    
    @Override
    public abstract int calculateCharge();


    public int calculateCharge(int copies) { 
        if (copies <= 0) {
            throw new IllegalArgumentException("Jumlah salinan harus lebih dari 0.");
        } else if (copies > 10) {
            throw new IllegalArgumentException("Jumlah salinan tidak boleh lebih dari 10.");
        }
        return copies *  calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
    
}
