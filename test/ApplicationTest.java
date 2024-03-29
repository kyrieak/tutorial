import org.junit.Test;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

public class ApplicationTest {

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Bunny says hi.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Bunny says hi.");
    }
  
    @Test
    
    public void callIndex() {
    	running(fakeApplication(), new Runnable() {
    		public void run() {
    			Result result = callAction(controllers.routes.ref.Application.index());
    			assertThat(status(result)).isEqualTo(OK);
    			assertThat(contentType(result)).isEqualTo("text/html");
    			assertThat(charset(result)).isEqualTo("utf-8");
    			assertThat(contentAsString(result)).contains("Bunny says hi.");
    		}
    	});
    }
}
