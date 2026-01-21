import com.example.Feline;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTests {
@Test
void getFamilyTest() {
    Feline feline = new Feline();
    String actual = feline.getFamily();
    String expected = "Кошачьи";
    assertEquals(expected, actual);
}
@Test
    void getKittensNoParamTest() {
    Feline feline = new Feline();
    int actual = feline.getKittens();
    int expected = 1;
    assertEquals(expected, actual);
}
@Test
    void getKittenWithParamTest() {
    Feline feline = new Feline();
    int actual = feline.getKittens(3);
    int expected = 3;
    assertEquals(expected, actual);
}
@Test
    void eatMeatTest() throws Exception {
    Feline feline = new Feline();
    assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
}
}
