package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import org.assertj.core.data.Index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("second", "four", "five", "first", "three")
                .containsAnyOf("sixth", "three", "seventh")
                .doesNotContain("sixth", "seventh")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("second", "three", "four");
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).first().isEqualTo("first");
        assertThat(list).element(0).isNotNull()
                .isEqualTo("first");
        assertThat(list).last().isNotNull()
                .isEqualTo("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .hasSize(5)
                .contains("second", "four")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("seventh");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second", "three", "four", "five")
                .containsValues(0, 1, 2, 3, 4)
                .doesNotContainKey("zero")
                .doesNotContainValue(5)
                .containsEntry("three", 2);
    }
}