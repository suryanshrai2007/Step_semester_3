public final class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;


    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = bookIds.clone();
    }


    public String[] getBookIds() {

        // Defensive copy
        return bookIds.clone();
    }


    public LoanReceipt withCorrectedBook(
            int index,
            String newId) {

        // Create a copy
        String[] newBookIds = bookIds.clone();


        // Change only the copy
        newBookIds[index] = newId;


        // Return a NEW object
        return new LoanReceipt(
                memberId,
                newBookIds
        );
    }
}