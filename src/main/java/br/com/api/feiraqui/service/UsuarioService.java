package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Usuario;
import br.com.api.feiraqui.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuario repository;
    private PasswordEncoder passwordEnconder;

    public UsuarioService(IUsuario repository){
        this.repository = repository;
        this.passwordEnconder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEnconder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEnconder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public boolean excluirUsuario(long id){
        repository.deleteById(id);
        return true;
    }

    public boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        boolean valid = passwordEnconder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
