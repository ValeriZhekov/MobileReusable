public class YearRangeSpecification implements Specification<Car>{
    private final int bot;
    private final int top;
    YearRangeSpecification(int bot , int top)
    {
        this.bot=bot;
        this.top=top;
    }

    @Override
    public boolean isSatisfied(Car item) {
        return item.getYear()>=bot && item.getYear()<=top;
    }
}