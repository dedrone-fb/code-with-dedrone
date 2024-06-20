package com.dedrone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DedroneCollections should")
public class DedroneCollectionsTest {
    @Test
    @DisplayName("not alter an already unique collection")
    public void notAlterAlreadyUniqueCollection() {
        List<String> unique = new ArrayList<>(Arrays.asList("alpha", "beta", "gamma"));
        List<String> result = DedroneCollections.unique(unique);
        assertThat(result).isEqualTo(unique);
    }

    @Test
    @Disabled("What's up with that????")
    @DisplayName("return an empty list when given an empty list")
    public void returnEmptyListWhenGivenEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> result = DedroneCollections.unique(emptyList);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("remove consecutive duplicates from collection")
    public void removeConsecutiveDuplicates() {
        List<Integer> duplicates = new ArrayList<>(Arrays.asList(5, 5, 3, 2, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(5, 3, 2));
        List<Integer> result = DedroneCollections.unique(duplicates);
        assertThat(result).isEqualTo(expected);
    }
}
