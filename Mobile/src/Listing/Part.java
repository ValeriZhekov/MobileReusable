package Listing;

import java.util.ArrayList;

public class Part extends Product{
    private PartType partType;
    private ArrayList<Car> cars;
    private String partBrand;
    public Part(String name,int id,String info,PartType partType,ArrayList<Car> cars,String partBrand)
    {
        super(name,id,info);
        this.partType=partType;
        this.partBrand=partBrand;
        this.cars=cars;
    }
    public ArrayList<Car> getCars() {
        return cars;
    }

    public PartType getPartType() {
        return partType;
    }

    public String getPartBrand() {
        return partBrand;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setPartBrand(String partBrand) {
        this.partBrand = partBrand;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }
}
