import java.util.ArrayList;

public class Listing {
    private final int listingID;
    private final Product product;
    private final Seller seller;
    private double price;
    private final String date;
    ArrayList<ListingComment> comments;
    public Listing(int listingID,Product product,Seller seller,double price,String date){
        this.listingID=listingID;
        this.product=product;
        this.price=price;
        this.seller=seller;
        this.date=date;
        this.comments=new ArrayList<ListingComment>();
    }
    public void addComment(Commenter commenter,String comment)
    {
        comments.add(new ListingComment(commenter,comment));
    }
    public void removeComment(int i)
    {
        comments.remove(i);
    }

    public ArrayList<ListingComment> getComments() {
        return comments;
    }

    public int getListingID() {
        return listingID;
    }

    public double getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}