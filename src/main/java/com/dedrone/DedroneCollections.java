package com.dedrone;

import java.util.Collection;
import java.util.Iterator;

public class DedroneCollections {

    private DedroneCollections() {}

    /**
     * Removes duplicate elements from the given collection.
     *
     * @param <C>        the type of collection
     * @param <T>        the type of elements in the collection
     * @param collection the collection from which to remove duplicates
     * @return the collection with duplicate elements removed
     */
    public static <C extends Collection<T>, T> C unique(C collection) {
        Iterator<T> iterator = collection.iterator();
        T previous = iterator.next();

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.equals(previous)) {
                iterator.remove();
            }
            previous = current;
        }
        return collection;
    }
}
