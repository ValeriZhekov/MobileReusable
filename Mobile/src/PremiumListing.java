public class PremiumListing extends Listing{
    private int priority;
    private String dateOfExpiry;
    PremiumListing(int listingID,Product product,Seller seller,double price,String date,int priority,String dateOfExpiry)
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