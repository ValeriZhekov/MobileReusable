import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filter<T> {
    private final Specification<T> specification;
    Filter(Specification<T> spec)
    {
        this.specification=spec;
    }
    public ArrayList<T> filter(ArrayList<T> elements)
    {
        return elements.stream().filter(specification::isSatisfied).collect(Collectors.toCollection(ArrayList<T>::new));
    }
}
