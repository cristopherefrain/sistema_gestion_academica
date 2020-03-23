package Services;

import Entities.Usuario;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author wizard
 */
public final class InicioSesionService extends Service {

    private static ArrayList<Usuario> lista_usuarios;

    public InicioSesionService() {
        super();
        initData();
    }

    private void initData() {
        lista_usuarios = new ArrayList();
        lista_usuarios.add(new Usuario("system", "root", "SYS-DBA"));
    }

    public Boolean iniciarSesion(final Usuario usuario) {
        ArrayList<Usuario> filtrado = new ArrayList(lista_usuarios.stream().filter(user -> user.getCedula().equals(usuario.getCedula()) && user.getClave().equals(usuario.getClave())).collect(Collectors.toList()));
        return !filtrado.isEmpty();
    }
}
