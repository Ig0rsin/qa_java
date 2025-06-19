import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class FelineTest {
    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void testGetFamily() { // это у нас кошачьи, а не свинячьи. Раз - getFamily()
        assertEquals("Кошачьи", feline.getFamily());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testGetKittens(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    void testGetKittensDefault() { // метод getKittens(int kittensCount). Два
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testEatMeat() throws Exception { // жрёт мясо. А меня жрут комары!!! Три - eatMeat()
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Feline spyFeline = spy(feline);
        doReturn(expectedFood).when(spyFeline).getFood("Хищник");

        List<String> actualFood = spyFeline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

}


