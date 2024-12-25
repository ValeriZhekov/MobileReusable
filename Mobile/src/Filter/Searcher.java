package Filter;

import Listing.*;
import java.util.ArrayList;
import java.util.List;

public interface Searcher<T extends Product> {
    ArrayList<Listing<T>> search(ArrayList<Listing<T>> listings, String query);
}
