package Filter;
import Listing.*;

import java.util.ArrayList;
import java.util.Stack;

public class CarListingSearcher implements Searcher<Car>{
    private final QueryParser queryParser;
    public CarListingSearcher() {
        this.queryParser = new QueryParser();
    }
    private class LiteralFilter<T> implements Filter<Listing<Car>> {
        private final T literalValue;

        public LiteralFilter(T literalValue) {
            this.literalValue = literalValue;
        }

        public T getLiteralValue() {
            return literalValue;
        }

        @Override
        public boolean matches(Listing<Car> item) {
            return false;
        }
    }
    private class PlaceholderFilter implements Filter<Listing<Car>> {
        private final String fieldName;

        public PlaceholderFilter(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldName() {
            return fieldName;
        }

        @Override
        public boolean matches(Listing<Car> item) {
            return false;
        }
    }
    private Filter<Listing<Car>> buildFilterFromPolishNotation(ArrayList<String> polishNotation) {
        Stack<Filter<Listing<Car>>> filterStack = new Stack<>();

        for (String token : polishNotation) {
            if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) { // field name
                filterStack.push(new PlaceholderFilter(token));
            } else if (token.matches("'[^']*'")) { // String literal
                String value = token.substring(1, token.length() - 1); // Remove quotes
                filterStack.push(new LiteralFilter<String>(value));
            } else if (token.matches("\\d+")) { // Integer literal
                int value = Integer.parseInt(token);
                filterStack.push(new LiteralFilter<Integer>(value));
            } else if (token.equals("&")) { // AND operator
                Filter<Listing<Car>> right = filterStack.pop();
                Filter<Listing<Car>> left = filterStack.pop();
                ArrayList<Filter<Listing<Car>>> andFilters = new ArrayList<>();
                andFilters.add(left);
                andFilters.add(right);
                filterStack.push(new AndFilter<Listing<Car>>(andFilters));
            } else if (token.equals("|")) { // OR operator
                Filter<Listing<Car>> right = filterStack.pop();
                Filter<Listing<Car>> left = filterStack.pop();
                ArrayList<Filter<Listing<Car>>> orFilters = new ArrayList<>();
                orFilters.add(left);
                orFilters.add(right);
                filterStack.push(new OrFilter<Listing<Car>>(orFilters));
            } else if (token.equals("=")) { // EQUAL operator
                Filter<Listing<Car>> valueFilter = filterStack.pop();
                Filter<Listing<Car>> fieldFilter = filterStack.pop();

                if (valueFilter instanceof LiteralFilter<?> && fieldFilter instanceof PlaceholderFilter) {
                    String fieldName = ((PlaceholderFilter) fieldFilter).getFieldName();
                    if (fieldName.equals("model")) {
                        filterStack.push(new ExactValueFilter<Listing<Car>, String>(l -> l.getProduct().getModel(),
                                ((LiteralFilter<String>) valueFilter).getLiteralValue()));
                    } else if (fieldName.equals("brand")) {
                        filterStack.push(new ExactValueFilter<Listing<Car>, String>(l -> l.getProduct().getBrand(),
                                ((LiteralFilter<String>) valueFilter).getLiteralValue()));
                    } else if (fieldName.equals("year")) {
                        filterStack.push(new ExactValueFilter<Listing<Car>, Integer>(l -> l.getProduct().getYear(),
                                ((LiteralFilter<Integer>) valueFilter).getLiteralValue()));
                    } else if (fieldName.equals("km")) {
                        filterStack.push(new ExactValueFilter<Listing<Car>, Integer>(l -> l.getProduct().getKm(),
                                ((LiteralFilter<Integer>) valueFilter).getLiteralValue()));
                    }

                }
                else {
                    throw new IllegalArgumentException("Invalid query structure.");
                }
            }
            else if (token.equals("<"))
            {
                Filter<Listing<Car>> valueFilter = filterStack.pop();
                Filter<Listing<Car>> fieldFilter = filterStack.pop();

                if (valueFilter instanceof LiteralFilter<?> && fieldFilter instanceof PlaceholderFilter) {
                    String fieldName = ((PlaceholderFilter) fieldFilter).getFieldName();
                     if (fieldName.equals("year")) {
                        filterStack.push(new RangeFilter<Listing<Car>, Integer>(l -> l.getProduct().getYear(),
                                Integer.MIN_VALUE,((LiteralFilter<Integer>) valueFilter).getLiteralValue()));
                    } else if (fieldName.equals("km")) {
                         filterStack.push(new RangeFilter<Listing<Car>, Integer>(l -> l.getProduct().getKm(),
                                 Integer.MIN_VALUE,((LiteralFilter<Integer>) valueFilter).getLiteralValue()));
                    }

                }
                else {
                    throw new IllegalArgumentException("Invalid query structure.");
                }

            }
            else if (token.equals(">"))
            {
                Filter<Listing<Car>> valueFilter = filterStack.pop();
                Filter<Listing<Car>> fieldFilter = filterStack.pop();

                if (valueFilter instanceof LiteralFilter<?> && fieldFilter instanceof PlaceholderFilter) {
                    String fieldName = ((PlaceholderFilter) fieldFilter).getFieldName();
                    if (fieldName.equals("year")) {
                        filterStack.push(new RangeFilter<Listing<Car>, Integer>(l -> l.getProduct().getYear(),
                                ((LiteralFilter<Integer>) valueFilter).getLiteralValue(),Integer.MAX_VALUE));
                    } else if (fieldName.equals("km")) {
                        filterStack.push(new RangeFilter<Listing<Car>, Integer>(l -> l.getProduct().getKm(),
                                ((LiteralFilter<Integer>) valueFilter).getLiteralValue(),Integer.MAX_VALUE));
                    }

                }
                else {
                    throw new IllegalArgumentException("Invalid query structure.");
                }

            }
        }

        if (filterStack.size() != 1) {
            throw new IllegalArgumentException("Malformed query.");
        }

        return filterStack.pop();
    }
        @Override
        public ArrayList<Listing<Car>> search(ArrayList<Listing<Car>> listings, String query) {
            // Parse the query into Polish Notation
            ArrayList<String> polishNotation = queryParser.toPolishNotation(query);

            // Build the combined filter
            Filter<Listing<Car>> combinedFilter = buildFilterFromPolishNotation(polishNotation);

            // Apply the filter to the listings
            ArrayList<Listing<Car>> results = new ArrayList<>();
            for (Listing<Car> listing : listings) {
                if (combinedFilter.matches(listing)) {
                    results.add(listing);
                }
            }

            return results;
        }
}
