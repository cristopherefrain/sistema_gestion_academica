/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Entities.Ciclo;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.CicloModel;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

    CicloModel model;

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
    public List<Ciclo> listar_ciclo() {
        try {
            return model.listar_ciclo();
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }
}
