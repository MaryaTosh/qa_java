import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ParametrizedTestsForAll {
    @Mock
    Feline feline;

    private static Stream<Arguments> provideEatPositive1() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideEatPositive1")
    void DoesHaveManeTest(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideEatPositive1")
    void GetFoodTest(String sex) throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
    private static Stream<Arguments> provideEatPositive() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }
    @ParameterizedTest
    @MethodSource("provideEatPositive")
    void GetFoodPositiveTest(String animalKind, List<String> expected) throws Exception {
        Animal animal = new Animal(); // или твой класс, где лежит getFood
        List<String> actual = animal.getFood(animalKind);
        assertEquals(expected, actual);
    }
    private static Stream<Arguments> provideEatNegative() {
        return Stream.of(
                Arguments.of("Пу-пу-пу"),
                Arguments.of("")
        );
    }
    @ParameterizedTest
    @MethodSource("provideEatNegative")
    void GetFoodNegativeTest(String animalKind) {
        Animal animal = new Animal();

        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood(animalKind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}