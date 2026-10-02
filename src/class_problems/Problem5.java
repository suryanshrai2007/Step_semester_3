package week7problem5;

abstract class DeliveryNote {
    protected String trackingId;

    public DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

class ParcelNote extends DeliveryNote {
    public ParcelNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNote extends DeliveryNote {
    public LetterNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

class DeliveryLog {
    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}

public class Problem5 {
    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery()); // Parcel TRK-1 delivered

        System.out.println(p.confirmDelivery("J. Smith"));
        // Parcel TRK-1 delivered, signed by J. Smith

        DeliveryNote ref = p; // upcasting
        DeliveryLog.logAll(new DeliveryNote[]{ref, new LetterNote("TRK2")});
        // Parcel TRK-1 delivered
        // Letter TRK-2 delivered
    }
}