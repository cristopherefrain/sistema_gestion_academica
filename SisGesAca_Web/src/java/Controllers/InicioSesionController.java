package Controllers;

import Entities.Usuario;
import Models.InicioSesionModel;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wizard
 */
@Path("/iniciosesion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InicioSesionController {

    @Context
    private HttpServletRequest request;
    private InicioSesionModel model;

    /**
     * Creates a new instance of InicioSesionController
     */
    public InicioSesionController() {
        model = new InicioSesionModel();
    }

    /**
     * Retrieves representation of an instance of API.InicioSesionController
     *
     * @return an instance of java.lang.String
     */
    @PUT
    @Path("/ingresar")
    public Boolean iniciarSesion(Usuario usuario) {
        Boolean valor = model.iniciarSesion(usuario);
        if (valor) {
            request.getSession(true).setAttribute("USER", usuario);
        }
        return valor;
    }

    @PUT
    @Path("/salir")
    public Boolean cerrarSesion() {
        request.getSession(true).invalidate();
        return true;
    }
}
