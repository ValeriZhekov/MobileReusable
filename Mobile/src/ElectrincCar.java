public class ElectrincCar extends Car{
    private final int rangeKM;
    private final double batterySize;
    ElectrincCar(String name,int id,String info,int year,int month,int km,int horsePower,String brand,String model,int rangeKM,double batterySize)
    {
        super(name, id, info, year, month, km, horsePower, brand, model);
        this.rangeKM=rangeKM;
        this.batterySize=batterySize;
    }

    public int getRangeKM() {
        return rangeKM;
    }

    public double getBatterySize() {
        return batterySize;
    }
}
