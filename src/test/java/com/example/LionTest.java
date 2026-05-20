package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    private Feline feline;

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    void doesHaveMane_ForGivenSex_ReturnsCorrectValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "Male", "самец"})
    void constructor_WithInvalidSex_ThrowsException(String invalidSex) {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion(invalidSex, feline));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения"));
    }

    @Test
    void getFood_ReturnsFoodFromFeline() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Мясо"), lion.getFood());
    }

    @Test
    void getFood_CallsEatMeatMethod() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        verify(feline).eatMeat();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5})
    void getKittens_ReturnsCountFromFeline(int kittensCount) throws Exception {
        when(feline.getKittens()).thenReturn(kittensCount);
        Lion lion = new Lion("Самец", feline);
        assertEquals(kittensCount, lion.getKittens());
    }

    @Test
    void getKittens_CallsGetKittensMethod() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @ParameterizedTest
    @CsvSource({"Самец", "Самка"})
    void constructor_WithValidSex_CreatesLion(String sex) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertNotNull(lion);
    }
}