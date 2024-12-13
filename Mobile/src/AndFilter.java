import java.util.ArrayList;

public class AndFilter<T> implements Filter<T>{
    ArrayList<Filter<T>> filters;
    AndFilter(ArrayList<Filter<T>> filters)
    {
        this.filters=filters;
    }
    @Override
    public boolean matches(T item) {
        boolean result=true;
        for (int i=0; i<filters.size(); i++)
        {
            if (!filters.get(i).matches(item))
            {
                result=false;
                break;
            }
        }
        return result;
    }
}
