import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

class CatTest {
    @Mock
    private Feline feline; // допустим, кыс-кыс!

    @InjectMocks
    private Cat cat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.cat = new Cat(this.feline);
    }

    @Test
    void testGetSound() {
        Assertions.assertEquals("Мяу", cat.getSound()); // мяукает под дверью и бесит. Раз - getSound()
    }

    @Test
    void testGetFood() throws Exception { // сметану и цветок в горшке. Два - getFood()
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        Assertions.assertEquals(expectedFood, actualFood);
    }
}

