package Controllers;

import Entities.Profesor;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ModelTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wizard
 */
@Path("/profesor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfesorController {

    private ModelTemplate<Profesor, String> model;

    /**
     * Creates a new instance of ProfesorResource
     */
    public ProfesorController() {
        model = new ModelTemplate<>(Profesor.class);
    }

    /**
     * Retrieves representation of an instance of API.ProfesorController
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/insertar")
    public void insertar_profesor(Profesor profesor) {
        try {
            model.insertar_objeto(profesor);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @PUT
    @Path("/modificar")
    public void modificar_profesor(Profesor profesor) {
        try {
            model.modificar_objeto(profesor);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @GET
    @Path("/buscar")
    public Profesor buscar_profesor(@QueryParam("id") String id) {
        try {
            return model.buscar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
        return new Profesor();
    }

    @GET
    @Path("/listar")
    public List<Profesor> listar_profesor(@QueryParam("id") String id) {
        try {
            ArrayList<Profesor> lista_objetos = new ArrayList(model.listar_objeto());
            return id.isBlank() ? lista_objetos : lista_objetos.stream().filter(profesor -> profesor.getCedula_profesor().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar_profesor(@QueryParam("id") String id) {
        try {
            model.eliminar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
    }
}
