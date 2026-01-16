package com.example;

import org.junit.jupiter.api.Test;
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

    @Test
    void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testFemaleLionNoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестный", feline));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения"));
    }

    @Test
    void testGetFoodReturnsCorrectFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", feline);

        assertEquals(List.of("Мясо"), lion.getFood());
    }

    @Test
    void testGetFoodCallsEatMeatMethod() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", feline);
        lion.getFood();

        verify(feline).eatMeat();
    }

    @Test
    void testGetKittensReturnsCorrectValue() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetKittensCallsFelineMethod() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        lion.getKittens();

        verify(feline).getKittens();
    }

    @Test
    void testConstructorCreatesLionSuccessfully() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertNotNull(lion);
    }

    @Test
    void constructorShouldCreateLionObject() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertNotNull(lion);
    }

    @Test
    void getKittensShouldReturnValueFromFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);

        int result = lion.getKittens();

        assertEquals(1, result);
        verify(feline).getKittens();
    }

    @Test
    void getKittensShouldReturnDifferentValueFromFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        int result = lion.getKittens();

        assertEquals(3, result);
    }
}