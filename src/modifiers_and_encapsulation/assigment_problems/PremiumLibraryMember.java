class PremiumLibraryMember extends LibraryMember {

    private int loyaltyPoints;

    public PremiumLibraryMember() {
        loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        loyaltyPoints += points;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}