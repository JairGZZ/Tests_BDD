package cucumber;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import cucumber.utils.Constantes;

public class PostsAPI {
    private RequestSpecification request;

    public PostsAPI() {
        request = SerenityRest.given();
    }

    @Step("Configurar id del post: {0}")
    public void setId(int id) {
        request.queryParam("id", id);
    }

    @Step("Configurar user_id: {0}")
    public void setUserId(int userId) {
        request.queryParam("user_id", userId);
    }

    @Step("Configurar título: '{0}'")
    public void setTitle(String title) {
        request.queryParam("title", title);
    }

    @Step("Configurar cuerpo: '{0}'")
    public void setBody(String body) {
        request.queryParam("body", body);
    }

    @Step("Enviar solicitud GET a /posts")
    public void enviarSolicitud() {
        request.when().get(Constantes.BASE_URL + "/public/v2/posts");
    }
}