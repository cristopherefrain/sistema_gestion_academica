/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Entities.Curso;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.CursoModel;
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

    private CursoModel model;

    /**
     * Creates a new instance of CursoResource
     */
    public CursoController() {
        model = new CursoModel();
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
            model.insertar_curso(curso);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @PUT
    @Path("/modificar")
    public void modificar_curso(Curso curso) {
        try {
            model.modificar_curso(curso);
        } catch (GlobalException | NoDataException ex) {
        }
    }

    @GET
    @Path("/buscar")
    public Curso buscar_curso(@QueryParam("id") String id) {
        try {
            return model.buscar_curso(id);
        } catch (GlobalException | NoDataException ex) {
        }
        return null;
    }

    @GET
    @Path("/listar")
    public List<Curso> listar_curso(@QueryParam("id") String id) {
        try {
            return id.isBlank() ? model.listar_curso() : model.listar_curso().stream().filter(curso -> curso.getCodigo_carrera().startsWith(id)).collect(Collectors.toList());
        } catch (GlobalException | NoDataException ex) {
        }
        return new ArrayList();
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar_curso(@QueryParam("id") String id) {
        try {
            model.eliminar_curso(id);
        } catch (GlobalException | NoDataException ex) {
        }
    }
}
