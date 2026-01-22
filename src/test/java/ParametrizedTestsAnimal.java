import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedTestsAnimal {


    private static Stream<Arguments> provideEatPositive() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }
    @ParameterizedTest
    @MethodSource("provideEatPositive")
    void getFoodPositiveTest(String animalKind, List<String> expected) throws Exception {
        Animal animal = new Animal();
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
    void getFoodNegativeTest(String animalKind) {
        Animal animal = new Animal();

        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood(animalKind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}
