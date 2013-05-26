import org.junit.Test;

import play.libs.F.Callback;
import play.mvc.Result;
import play.test.TestBrowser;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class BunnyTest {

	@Test
	public void testBunnyRoute() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				Result result = route(fakeRequest(GET, "/bunny"));
				assertThat(result).isNotNull();;
			}
		});
	}
}