/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.ProfesorModel;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
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

    private ProfesorModel model;

    /**
     * Creates a new instance of ProfesorResource
     */
    public ProfesorController() {
        model = new ProfesorModel();
    }

    /**
     * Retrieves representation of an instance of API.ProfesorController
     *
     * @return an instance of java.lang.String
     */
}
