package Controllers;

import Entities.Curso;
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
@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoController {

    private ModelTemplate<Curso, String> model;

    /**
     * Creates a new instance of CursoResource
     */
    public CursoController() {
        model = new ModelTemplate<>(Curso.class);
    }

    /**
     * Retrieves representation of an instance of API.CursoController
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/insertar")
    public void insertar_curso(Curso curso) {
        try {
            model.insertar_objeto(curso);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @PUT
    @Path("/modificar")
    public void modificar_curso(Curso curso) {
        try {
            model.modificar_objeto(curso);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @GET
    @Path("/buscar")
    public Curso buscar_curso(@QueryParam("id") String id) {
        try {
            return model.buscar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
        return new Curso();
    }

    @GET
    @Path("/listar")
    public List<Curso> listar_curso(@QueryParam("id") String id) {
        try {
            ArrayList<Curso> lista_objetos = new ArrayList(model.listar_objeto());
            return id.isBlank() ? lista_objetos : lista_objetos.stream().filter(curso -> curso.getCodigo_carrera().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar_curso(@QueryParam("id") String id) {
        try {
            model.eliminar_objeto(id);
        } catch (GlobalException | NoDataException ex) {
        }
    }
}
