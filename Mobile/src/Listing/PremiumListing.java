package Listing;

import Users.Seller;

public class PremiumListing<T extends Product> extends Listing<T> {
    private int priority;
    private String dateOfExpiry;
    public PremiumListing(int listingID, T product, Seller seller, double price, String date, int priority, String dateOfExpiry)
    {
        super(listingID, product, seller, price, date);
        this.dateOfExpiry=dateOfExpiry;
        this.priority=priority;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
