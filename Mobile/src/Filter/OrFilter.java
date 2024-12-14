package Filter;

import java.util.ArrayList;

public class OrFilter<T> implements Filter<T> {
    ArrayList<Filter<T>> filters;
    OrFilter(ArrayList<Filter<T>> filters)
    {
        this.filters=filters;
    }
    @Override
    public boolean matches(T item) {
        boolean result=false;
        for (int i=0; i<filters.size(); i++)
        {
            if (filters.get(i).matches(item))
            {
                result=true;
                break;
            }
        }
        return result;
    }
}
