package Listing;

public abstract class Car extends Product {
    protected final int year;
    protected final int month;
    private int km;
    protected final int horsePower;
    protected final String brand;
    protected final String model;
    Car(String name,int id,String info,int year,int month,int km,int horsePower,String brand,String model)
    {
        super(name, id, info);
        this.year=year;
        this.month=month;
        this.brand=brand;
        this.km=km;
        this.horsePower=horsePower;
        this.model=model;
    }

    public int getYear() {
        return year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getKm() {
        return km;
    }

    public int getMonth() {
        return month;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
