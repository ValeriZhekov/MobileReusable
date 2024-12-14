package Listing;

import java.util.ArrayList;
import java.util.List;
public class ListingStorage<T extends Product> {
    private final List<Listing<T>> listings = new ArrayList<>();

    public void addListing(Listing<T> listing) {
        listings.add(listing);
    }

    public List<Listing<T>> getListings() {
        return listings;
    }
}