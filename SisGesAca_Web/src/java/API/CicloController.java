/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.CicloModel;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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

}
