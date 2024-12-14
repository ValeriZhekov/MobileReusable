package Listing;

import Users.Commenter;
import Users.Seller;

import java.util.ArrayList;

public class Listing<T extends Product> {
    private final int listingID;
    private final T product;
    private final Seller seller;
    private double price;
    private final String date;
    ArrayList<ListingComment> comments;
    public Listing(int listingID,T product,Seller seller,double price,String date){
        this.listingID=listingID;
        this.product=product;
        this.price=price;
        this.seller=seller;
        this.date=date;
        this.comments=new ArrayList<ListingComment>();
    }
    public void addComment(Commenter commenter, String comment)
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

    public T getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}