package API;

import Entities.Carrera;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.CarreraModel;
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
@Path("/carrera")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarreraController {

    private CarreraModel model;

    /**
     * Creates a new instance of CarreraResource
     */
    public CarreraController() {
        model = new CarreraModel();
    }

    /**
     * Retrieves representation of an instance of API.CarreraController
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/insertar")
    public void insertar_carrera(Carrera carrera) {
        try {
            model.insertar_carrera(carrera);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @PUT
    @Path("/modificar")
    public void modificar_carrera(Carrera carrera) {
        try {
            model.modificar_carrera(carrera);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @GET
    @Path("/buscar")
    public Carrera buscar_carrera(@QueryParam("id") String id) {
        try {
            return model.buscar_carrera(id);
        } catch (GlobalException | NoDataException ex) {
        }
        return new Carrera();
    }

    @GET
    @Path("/listar")
    public List<Carrera> listar_carrera(@QueryParam("id") String id) {
        try {
            return id.isBlank()? model.listar_carrera() : model.listar_carrera().stream().filter(carrera -> carrera.getCodigo_carrera().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar_carrera(@QueryParam("id") String id) {
        try {
            model.eliminar_carrera(id);
        } catch (GlobalException | NoDataException ex) {
        }
    }
}
