/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.AlumnoModel;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
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

    private AlumnoModel model;

    /**
     * Creates a new instance of AlumnoController
     */
    public AlumnoController() {
        model = new AlumnoModel();
    }

    /**
     * Retrieves representation of an instance of API.AlumnoController
     *
     * @return an instance of java.lang.String
     */

}
