package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    private Feline feline;

    @Test
    void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFoodReturnsCorrectValue() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
    }

    @Test
    void testGetFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));

        cat.getFood();

        verify(feline).eatMeat();
    }

    @Test
    void testConstructor() {
        Cat cat = new Cat(feline);
        assertNotNull(cat);
    }
}
