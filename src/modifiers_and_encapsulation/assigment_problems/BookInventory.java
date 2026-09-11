public class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;


    public BookInventory(int copiesTotal) {

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }


    public void checkOut() {

        // Don't allow available copies to become negative
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }


    public void checkIn() {

        // Don't allow available copies
        // to exceed total copies
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }


    public int getCopiesAvailable() {

        return copiesAvailable;
    }
}