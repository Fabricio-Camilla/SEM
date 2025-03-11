package sem.service;

import sem.modelo.Usuario;

public interface LoginService {

    void register(Usuario user);

    Usuario recuperar(String userName);

    void deleteAll();
}
