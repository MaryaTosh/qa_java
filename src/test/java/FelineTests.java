import com.example.Animal;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTests {
    @Mock
    Animal animal;
@Test
void GetFamilyTest() {
    Feline feline = new Feline();
    String actual = feline.getFamily();
    String expected = "Кошачьи";
    assertEquals(expected, actual);
}
@Test
    void GetKittensNoParamTest() {
    Feline feline = new Feline();
    int actual = feline.getKittens();
    int expected = 1;
    assertEquals(expected, actual);
}
@Test
    void GetKittenWithParamTest() {
    Feline feline = new Feline();
    int actual = feline.getKittens(3);
    int expected = 3;
    assertEquals(expected, actual);
}
@Test
    void EatMeatTest() throws Exception {
    Feline feline = new Feline();
    assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
}
}
