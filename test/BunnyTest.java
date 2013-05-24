import org.junit.Test;
import play.mvc.Result;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class BunnyTest {

    @Test
    public void testFooRoute() {
        Result result = route(fakeRequest(GET, "/bunny"));
        assertThat(result).isNotNull();
    }

}