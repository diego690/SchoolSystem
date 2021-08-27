/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Materia;
import uteq.sga.ScchoolarSystem.Repositorys.IMateriaRepository;
import uteq.sga.ScchoolarSystem.Services.IMateriaService;

/**
 *
 * @author capur
 */
@Service
public class MateriaService implements IMateriaService{
    
    @Autowired
    private IMateriaRepository materepo;

    @Override
    public List<Materia> listarTodos() {
        return (List<Materia>) materepo.findAll();
    }

    @Override
    public void guardar(Materia actividad) {
        materepo.save(actividad);
    }

    @Override
    public Materia buscaById(Integer id) {
        return materepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        materepo.deleteById(id);
    }
    
}
