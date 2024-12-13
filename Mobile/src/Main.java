import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User kiko=new User("koko","12.12.2021","1321","koko@abv.bg","11.11.2001"),
        nik=new User("nik","10.12.2022","aaa123","nik@abv.bg","09.09.2001");
        Dealer topKoli=new Dealer("topKoli","12.08.2011","topKoli@abv.bg","12323","Sofia");
        ElectrincCar tesla3=new ElectrincCar("Tesla Model 3 base",12352,"Full service history",2019,3,125250,250,"Tesla","Model 3",420,65.2);
        ICECar hondaCivic1=new ICECar("Honda Civic Sport 1.5T",23512,"No problems, driven by a grandma",2013,2,222000,183,"Honda","Civic",1.5,FuelType.Petrol),
        hondaCivic2=new ICECar("Honda Civic Touring 2.0",23511,"No problems, driven by a grandma",2011,1,253000,183,"Honda","Civic",1.5,FuelType.Petrol);
        Listing<Car> honda1=new Listing(12,hondaCivic1,kiko,21000,"12.12.2023"),
                honda2=new Listing(123,hondaCivic2,kiko,11000,"12.12.2023"),
        tesla=new PremiumListing(231231,tesla3,nik,45000,"12.11.2023",23,"12.11.2024");
        ArrayList<Car> cars=new ArrayList<>(),filtered;
        cars.add(hondaCivic1);
        cars.add(tesla3);
        cars.add(hondaCivic2);
        honda1.addComment(nik,"Mn zle civic-a");

        ExactValueFilter<Listing<Car>,String> hondaModel=new ExactValueFilter<Listing<Car>, String>(x -> x.getProduct().getModel(),"Honda");
        ExactValueFilter<Listing<Car>,String> teslaModel=new ExactValueFilter<Listing<Car>, String>(x -> x.getProduct().getModel(),"Tesla");


    }
}