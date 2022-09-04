package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isNumberOfVerticesSix() {
        Box box = new Box(8, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void isNumberExist() {
        Box box = new Box(5, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 1);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(8, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void isAreaDefault() {
        Box box = new Box(2, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void isArea() {
        Box box = new Box(8, 2);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(24);
    }
}