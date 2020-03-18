package Controllers;

import Entities.Ciclo;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.CicloModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wizard
 */
@Path("/ciclo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CicloController {

    private CicloModel model;

    /**
     * Creates a new instance of CicloResource
     */
    public CicloController() {
        model = new CicloModel();
    }

    /**
     * Retrieves representation of an instance of API.CicloController
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    public List<Ciclo> listar_ciclo(@QueryParam("id") String id) {
        try {
            return id.isBlank() ? model.listar_ciclo() : model.listar_ciclo().stream().filter(ciclo -> ciclo.getNo_ciclo().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }
}
