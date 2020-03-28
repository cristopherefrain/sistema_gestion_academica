package Controllers;

import Entities.Alumno;
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
@Path("/alumno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoController {

    private ModelTemplate<Alumno, String> model;

    /**
     * Creates a new instance of AlumnoController
     */
    public AlumnoController() {
        model = new ModelTemplate<>(Alumno.class);
    }

    /**
     * Retrieves representation of an instance of API.AlumnoController
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/insertar")
    public void insertar_alumno(Alumno alumno) {
        try {
            model.insertar_objeto(alumno);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @PUT
    @Path("/modificar")
    public void modificar_alumno(Alumno alumno) {
        try {
            model.modificar_objeto(alumno);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @GET
    @Path("/buscar")
    public Alumno buscar_alumno(@QueryParam("id") String id) {
        try {
            return model.buscar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
        return new Alumno();
    }

    @GET
    @Path("/listar")
    public List<Alumno> listar_alumno(@QueryParam("id") String id) {
        try {
            ArrayList<Alumno> lista_objetos = new ArrayList(model.listar_objeto());
            return id.isBlank() ? lista_objetos : lista_objetos.stream().filter(alumno -> alumno.getCedula_alumno().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar_alumno(@QueryParam("id") String id) {
        try {
            model.eliminar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
    }
}
