/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Usuario;
import uteq.sga.ScchoolarSystem.Repositorys.IUsuarioRepository;
import uteq.sga.ScchoolarSystem.Services.IUsuarioService;

/**
 *
 * @author capur
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private IUsuarioRepository userepo;

    @Override
    public List<Usuario> listarTodos() {
      return (List<Usuario>) userepo.findAll();
    }

    @Override
    public void guardar(Usuario user) {
        userepo.save(user);
    }

    @Override
    public Usuario buscaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
