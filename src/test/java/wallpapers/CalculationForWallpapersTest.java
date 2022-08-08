package wallpapers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculationForWallpapersTest {


    @Test
    public void testImmutableCollections() {

        List<String> fruits = Arrays.asList(new String[]{"1", "2", "3"});

        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("4");
            fruits.remove(1);
        });

        assertEquals(3, fruits.size());

    }
}
