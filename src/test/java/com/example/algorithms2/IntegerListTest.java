package com.example.algorithms2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegerListTest {
    private final IntegerList out = new IntegerListImpl();

    private static Stream<Arguments> paramsForTest() {
        return Stream.of(
                Arguments.of(0, 15),
                Arguments.of(1, 1),
                Arguments.of(2, 67),
                Arguments.of(3, 198)
        );
    }

    @BeforeEach
    public void init() {
        out.add(0, 111);
        out.add(1, 222);
        out.add(2, 333);
        out.add(3, 444);
        out.add(4, 555);
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void shouldReturnInteger(int index, Integer item) {
        assertTrue(out.size() == 5);
        assertEquals(out.add(index, item), item);
        assertEquals(out.remove(index), item);

        assertEquals(out.add(item), item);
        assertEquals(out.remove(item), item);


        assertEquals(out.set(index, item), item);

        assertEquals(out.indexOf(item), index);
        assertEquals(out.lastIndexOf(item), index);

//        out.add(index, item);
        assertEquals(out.get(index), item);
        assertEquals(out.contains(item), true);

    }
}
