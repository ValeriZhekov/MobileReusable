import java.util.ArrayList;

public class OrSpecification<T> implements Specification<T>{
    private final ArrayList<Specification<T>> specs;
    public OrSpecification(ArrayList<Specification<T>> specs)
    {
        this.specs=specs;
    }
    @Override
    public boolean isSatisfied(T item) {
        for (int i=0; i< specs.size(); i++)
        {
            if (specs.get(i).isSatisfied(item))
                return true;
        }
        return false;
    }
}