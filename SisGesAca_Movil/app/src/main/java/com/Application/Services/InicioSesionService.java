package com.Application.Services;

import com.Application.Entities.Usuario;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author wizard
 */
public class InicioSesionService extends Service {

    private static ArrayList<Usuario> usuariosList;

    public InicioSesionService() {
        super();
        usuariosList = new ArrayList();
        prepareUsuarioData();
    }

    private void prepareUsuarioData() {
        usuariosList.add(new Usuario("system", "root", "SYS-DBA"));
    }

    public Boolean iniciarSesion(Usuario usuario) {
        ArrayList<Usuario> filtrado = new ArrayList(usuariosList.stream().filter(user -> user.getCedula().equals(usuario.getCedula()) && user.getClave().equals(usuario.getClave())).collect(Collectors.toList()));
        return filtrado.size() != 0;
    }
}
