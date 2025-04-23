package cucumber.posts.stepDef;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

public class GeneralStepDef {

    @Entonces("debería recibir un código de estado {int}")
    public void verificarCodigoEstado(int codigoEsperado) {
        SerenityRest.then()
                .assertThat()
                .statusCode(codigoEsperado);
    }
}