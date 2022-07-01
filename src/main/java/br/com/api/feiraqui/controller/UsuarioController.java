package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IUsuario;
import br.com.api.feiraqui.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuario dao;

    @GetMapping("/lista")
    public List<Usuario> listaUsuarios (){
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario (@RequestBody Usuario usuario){
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }
}
