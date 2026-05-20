package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelineTest {
    private final Feline feline = new Feline();

    @Test
    void eatMeatReturnsPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void eatMeatCallsGetFood() throws Exception {
        Feline spy = spy(feline);
        spy.eatMeat();
        verify(spy).getFood("Хищник");
    }

    @Test
    void getFamilyReturnsFelidae() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void getKittensWithCountReturnsCount(int count) {
        assertEquals(count, feline.getKittens(count));
    }

    @Test
    void getFoodForHerbivoreReturnsCorrectFood() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), feline.getFood("Травоядное"));
    }

    @Test
    void getFoodForPredatorReturnsCorrectFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    void getFoodThrowsExceptionForUnknownKind() {
        Exception exception = assertThrows(Exception.class, () ->
                feline.getFood("Неизвестный"));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
    }

    @Test
    void felineIsPredator() {
        assertInstanceOf(Predator.class, feline);
    }

    @Test
    void felineIsAnimal() {
        assertInstanceOf(Animal.class, feline);
    }
}