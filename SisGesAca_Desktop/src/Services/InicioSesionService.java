package Services;

import Entities.Usuario;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author wizard
 */
public class InicioSesionService extends Service {

    private static ArrayList<Usuario> lista_usuarios;

    public InicioSesionService() {
        lista_usuarios = new ArrayList();
        lista_usuarios.add(new Usuario("system", "root", "SYS-DBA"));
    }

    public Boolean iniciarSesion(Usuario usuario) {
        ArrayList<Usuario> filtrado = new ArrayList(lista_usuarios.stream().filter(user -> user.getCedula().equals(usuario.getCedula()) && user.getClave().equals(usuario.getClave())).collect(Collectors.toList()));
        return filtrado.size() != 0;
    }
}
