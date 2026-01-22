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
public class ParametrizedTestsLion {
    @Mock
    Feline feline;

    private static Stream<Arguments> provideEatPositiveLion() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideEatPositiveLion")
    void doesHaveManeTest(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideEatPositiveLion")
    void getFoodTest(String sex) throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}