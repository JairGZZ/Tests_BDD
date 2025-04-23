package cucumber.posts.stepDef;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.thucydides.core.annotations.Steps;
import cucumber.PostsAPI;

public class PostsStepDef {

    @Steps
    PostsAPI postsAPI;

    @Dado("configuro el parámetro {string} con valor {string}")
    public void configurarParametroString(String parametro, String valor) {
        switch(parametro.toLowerCase()) {
            case "id":
                postsAPI.setId(Integer.parseInt(valor));
                break;
            case "user_id":
                postsAPI.setUserId(Integer.parseInt(valor));
                break;
            case "title":
                postsAPI.setTitle(valor);
                break;
            case "body":
                postsAPI.setBody(valor);
                break;
        }
    }

    @Dado("configuro el parámetro {string} con valor {int}")
    public void configurarParametroNumerico(String parametro, int valor) {
        switch(parametro.toLowerCase()) {
            case "id":
                postsAPI.setId(valor);
                break;
            case "user_id":
                postsAPI.setUserId(valor);
                break;
        }
    }

    @Cuando("realizo una solicitud GET a /posts")
    public void realizarSolicitud() {
        postsAPI.enviarSolicitud();
    }
}