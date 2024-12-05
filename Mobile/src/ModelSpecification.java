public class ModelSpecification implements Specification<Car>{
    private final String model;
    public ModelSpecification(String model)
    {
        this.model=model;
    }

    @Override
    public boolean isSatisfied(Car car) {
        return car.getModel().equals(this.model);
    }
}
