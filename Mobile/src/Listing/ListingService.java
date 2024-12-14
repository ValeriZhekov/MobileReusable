package Listing;
import Notification.*;
public class ListingService {
    private final ListingStorage<Car> listingStorage;
    private final NotificationService notificationService;

    public ListingService(ListingStorage<Car> listingStorage, NotificationService notificationService) {
        this.listingStorage = listingStorage;
        this.notificationService = notificationService;
    }

    public void addListing(Listing<Car> listing) {
        listingStorage.addListing(listing);
        notificationService.onNewListingAdded(listing);
    }
}
