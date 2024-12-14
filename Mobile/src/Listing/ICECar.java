package Listing;

public class ICECar extends Car{
    private final double engineSize;
    private final FuelType fuelType;
    public ICECar(String name,int id,String info,int year,int month,int km,int horsePower,String brand,String model,double engineSize,FuelType fuelType)
    {
        super(name, id, info, year, month, km, horsePower, brand, model);
        this.engineSize=engineSize;
        this.fuelType=fuelType;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
