package lession4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static lession4.function.square;


public class TriangleTest {

    @Test
    void testSquare(){
        double result = square(5, 5, 5);
        Assertions.assertEquals(56,result);
    }

}
