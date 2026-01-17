import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlexTest {

    @Mock
    Feline feline;

    @Test
    void GerKittenTest() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }
    @Test
    void GetPlaceOfLivingTest() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
    @Test
    void GetFriendsTest() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(List.of("Глория", "Мелман", "Марти"), alex.getFriends());
    }
}
