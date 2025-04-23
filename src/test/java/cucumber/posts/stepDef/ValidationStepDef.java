package cucumber.posts.stepDef;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidationStepDef {

    @Entonces("el código de respuesta debe ser {int}")
    public void verificarCodigoRespuesta(int codigo) {
        SerenityRest.then().statusCode(codigo);
    }

    @Y("la respuesta debe contener el campo {string} con valor {int}")
    public void validarCampoNumerico(String campo, int valor) {
        SerenityRest.then().body(campo, Matchers.hasItem(valor));
    }

    @Y("todos los posts deben tener {string} igual a {int}")
    public void validarTodosLosCamposNumericos(String campo, int valor) {
        SerenityRest.then().body(campo, Matchers.everyItem(Matchers.equalTo(valor)));
    }

    @Y("todos los {string} deben contener {string}")
    public void validarContenidoTexto(String campo, String texto) {
        SerenityRest.then().body(campo, Matchers.everyItem(Matchers.containsStringIgnoringCase(texto)));
    }

    @Y("validar el esquema JSON de respuesta")
    public void validarEsquema() {
        File schema = new File("src/test/resources/JSON/Schema/ResponsePostSchemaValid.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }
}