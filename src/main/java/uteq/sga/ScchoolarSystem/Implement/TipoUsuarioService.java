/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Tipousuario;
import uteq.sga.ScchoolarSystem.Entity.Tipousuario_;
import uteq.sga.ScchoolarSystem.Repositorys.ITipoUsuarioRepository;
import uteq.sga.ScchoolarSystem.Services.ITipoUsuarioService;

/**
 *
 * @author capur
 */
@Service
public class TipoUsuarioService implements ITipoUsuarioService{
    
    @Autowired
    private ITipoUsuarioRepository tipouserepo; 

    @Override
    public List<Tipousuario> listarTodos() {
        return (List<Tipousuario>) tipouserepo.findAll();
    }

    @Override
    public void guardar(Tipousuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipousuario buscaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
