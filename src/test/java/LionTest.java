import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class LionTest {

    @Mock
    private Feline feline;

    @Mock
    private Lion lion;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(this.feline, "Самец");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testLionCreation(String sex) throws Exception {
        Lion lion = new Lion(this.feline, sex);
        boolean expectedHasMane = "Самец".equals(sex);
        Assertions.assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void testLionCreationWithInvalidSex() { // Мэ, Жо или ЛГБТ. Раз
        Exception exception = Assertions.assertThrows(Exception.class, () -> new Lion(feline, "Неизвестный"));
        Assertions.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() { // метод getKittens(int kittensCount). Два
        int expectedKittensCount = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);

        int actualKittensCount = lion.getKittens();
        Assertions.assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    void testGetFood() throws Exception { // кого нашёл в палатке, тот и завтрак. Три - getFood()
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        Assertions.assertEquals(expectedFood, actualFood);
    }
}
