package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class FelineTest {
    private final Feline feline = new Feline();

    @Test
    void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetKittensWithCount() {
        assertEquals(5, feline.getKittens(5));
    }
    @Test
    void testEatMeatCallsGetFoodWithPredator() throws Exception {
        // Создаем spy объект, чтобы проверить вызов getFood
        Feline spyFeline = spy(new Feline());
        spyFeline.eatMeat();

        // Проверяем, что eatMeat вызывает getFood("Хищник")
        verify(spyFeline).getFood("Хищник");
    }
}