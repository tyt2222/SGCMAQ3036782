package framework.dao;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        TipoUsuario usuario = new TipoUsuario(13);

        usuario.setModuloAdministrativo("M");
        usuario.setModuloAgendamento("M");
        usuario.setModuloAtendimento("M");

        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();

        // INSERIR
        // tipoUsuarioDAO.insert(usuario);
        // ATUALIZAR
        // usuario.setModuloAdministrativo("N");
        // usuario.setModuloAgendamento("N");
        // usuario.setModuloAtendimento("N");
        // tipoUsuarioDAO.update(usuario);
        // DELETAR
        // tipoUsuarioDAO.delete(usuario);
        // LISTAR TODOS
        ArrayList<TipoUsuario> listaUsuarios = tipoUsuarioDAO.getAll();

        System.out.println(listaUsuarios);

        // BUSCAR ID 1951
        usuario = tipoUsuarioDAO.getUnique(1951);

        System.out.println(usuario);

        // BUSCAR ID 13
        usuario = tipoUsuarioDAO.getUnique(13);

        System.out.println(usuario);
    }
}
