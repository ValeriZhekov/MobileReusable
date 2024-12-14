package Filter;

import java.util.ArrayList;

public class NofMFilter<T> implements Filter<T>{
    ArrayList<Filter<T>> filters;
    int n;
    public NofMFilter(ArrayList<Filter<T>> filters,int n)
    {
        this.filters=filters;
        this.n=n;
    }

    @Override
    public boolean matches(T item) {
        int count=0;
        for (Filter<T> filter : filters) {
            if (filter.matches(item))
                count++;
        }
        return count>=n;
    }
}
