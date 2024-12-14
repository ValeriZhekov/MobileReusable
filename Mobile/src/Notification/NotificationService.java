package Notification;
import Filter.*;
import java.util.ArrayList;
import java.util.List;
import Listing.*;
public class NotificationService {
    private final List<NotificationRule<Car>> notificationRules = new ArrayList<>();

    public void subscribe(NotificationRule<Car> notificationRule) {
        notificationRules.add(notificationRule);
    }

    public void onNewListingAdded(Listing<Car> listing) {
        for (NotificationRule<Car> notificationRule : notificationRules) {

            if (notificationRule.filter().matches(listing)) {
                String message = listing.getProduct().getBrand() + " "
                        + listing.getProduct().getModel() +
                        " for " + listing.getPrice();
                notificationRule.channel().notify(
                        "New car found for you!",
                        message
                );
            }
        }
    }
}
