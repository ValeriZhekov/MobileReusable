package Notification;

import java.util.List;
import Filter.Filter;
import Listing.*;
public record NotificationRule<T extends  Product>(Filter<Listing<T>> filter,
                               NotificationChannel channel)
{}
