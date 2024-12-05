public class PriceRangeSpecification implements Specification<Listing>{
    private final double bot;
    private final double top;

    public PriceRangeSpecification(double bot,double top)
    {
        this.bot=bot;
        this.top=top;
    }
    @Override
    public boolean isSatisfied(Listing item) {
        return item.getPrice()>=bot && item.getPrice()<=top;
    }
}
