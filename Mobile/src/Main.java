

import Filter.*;
import Listing.*;
import Notification.NotificationRule;
import Notification.NotificationService;
import Notification.SmsNotificationChannel;
import Notification.SmsNotifier;
import Users.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Listing<Car> makeICECarListing(Seller seller)
    { Scanner input = new Scanner(System.in);
        String brand=new String(),model=new String(),name=new String();
        int km,hp,year,id;
        double price;
        System.out.println("Name: ");
        name=input.nextLine();
        System.out.println("Brand: ");
        brand=input.nextLine();
        System.out.println("Model: ");
        model=input.nextLine();
        System.out.println("KM: ");
        km=input.nextInt();
        System.out.println("Year: ");
        year=input.nextInt();
        System.out.println("HP: ");
        hp=input.nextInt();
        System.out.println("ID: ");
        id=input.nextInt();
        System.out.println("Price: ");
        price=input.nextInt();
        ICECar car=new ICECar(name,id,"info",year,1,km,hp,brand,model,2.0,FuelType.Diesel);
        return new Listing<Car>(id,car,seller,price,"12.12.2021");
    }
    static Listing<Car> makeElectricCarListing(Seller seller)
    {Scanner input = new Scanner(System.in);
        String brand=new String(),model=new String(),name=new String();
        int km,hp,year,id,range;
        double price;
        System.out.println("Name: ");
        name=input.nextLine();
        System.out.println("Brand: ");
        brand=input.nextLine();
        System.out.println("Model: ");
        model=input.nextLine();
        System.out.println("KM: ");
        km=input.nextInt();
        System.out.println("Year: ");
        year=input.nextInt();
        System.out.println("HP: ");
        hp=input.nextInt();
        System.out.println("ID: ");
        id=input.nextInt();
        System.out.println("Price: ");
        price=input.nextInt();
        System.out.println("Range: ");
        range=input.nextInt();
        ElectrincCar car=new ElectrincCar(name,id,"info",year,1,km,hp,brand,model,range,92);
        return new Listing<Car>(id,car,seller,price,"12.12.2021");
    }

    public static void main(String[] args) {
        User kiko=new User("koko","12.12.2021","1321","koko@abv.bg","11.11.2001");
        ElectrincCar tesla3=new ElectrincCar("Tesla Model 3 base",12352,"Full service history",2019,3,125250,250,"Tesla","Model3",420,65.2);
        ICECar accord=new ICECar("Honda Accord Sport 2.0T",23512,"No problems, driven by a grandma",2013,2,222000,183,"Honda","Accord",2.0, FuelType.Petrol),
        civic=new ICECar("Honda Civic Touring 2.0",23511,"No problems, driven by a grandma",2011,1,253000,183,"Honda","Civic",2.0,FuelType.Petrol);
        Listing<Car> accordL=new Listing(12,accord,kiko,21000,"12.12.2023"),
                civicL=new Listing(123,civic,kiko,11000,"12.12.2023"),
        teslaL=new PremiumListing(231231,tesla3,kiko,45000,"12.11.2023",23,"12.11.2024");


        ExactValueFilter<Listing<Car>,String> hondaModel=new ExactValueFilter<Listing<Car>, String>(x -> x.getProduct().getModel(),"Honda");
        ExactValueFilter<Listing<Car>,String> teslaModel=new ExactValueFilter<Listing<Car>, String>(x -> x.getProduct().getModel(),"Tesla");



        ArrayList<Car> carArr=new ArrayList<Car>();
        NotificationService notificationService=new NotificationService();
        RangeFilter<Listing<Car>,Double> cheapCarsFilter=new RangeFilter<Listing<Car>,Double>(x -> x.getPrice(),0.0,10000.0);
        SmsNotificationChannel sms=new SmsNotificationChannel(new SmsNotifier(),"0899773221");
        notificationService.subscribe(new NotificationRule<Car>(cheapCarsFilter,sms));
        ListingService  carListingService=new ListingService(new ListingStorage<Car>(),notificationService);
        CarListingSearcher searcher=new CarListingSearcher();
        Scanner input = new Scanner(System.in);
        int value;
        carListingService.addListing(accordL);
        carListingService.addListing(civicL);
        carListingService.addListing(teslaL);
        while (true)
        {
            System.out.println("Add Listing<ICECar>: 1");
            System.out.println("Add Listing<ElectricCar>: 2");
            System.out.println("Filter Car Listings: 3");
           value= input.nextInt();
           input.nextLine();
           if (value==1)
           {
               carListingService.addListing(makeICECarListing(kiko));
           }
           else if (value==2){
               carListingService.addListing(makeElectricCarListing(kiko));
           }
           else if (value==3)
           {
               ArrayList<Listing<Car>> result;
               System.out.println("Give filter as a string");
               String str=input.nextLine();
               result=searcher.search(carListingService.getListingStorage().getListings(), str);
               for (int i=0; i< result.size(); i++)
               {
                   System.out.println(result.get(i).getProduct().getName());
               }
           }
        }
    }
}