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
        tipouserepo.save(user);
    }

    @Override
    public Tipousuario buscaById(Short id) {
        return tipouserepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Short id) {
        tipouserepo.deleteById(id);
    }

   
    
}
