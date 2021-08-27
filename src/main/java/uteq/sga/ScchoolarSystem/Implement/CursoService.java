/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Curso;
import uteq.sga.ScchoolarSystem.Repositorys.ICursoRepository;
import uteq.sga.ScchoolarSystem.Services.ICursoService;

/**
 *
 * @author capur
 */
@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository curepo;

    @Override
    public List<Curso> listarTodos() {
        return (List<Curso>) curepo.findAll();
    }

    @Override
    public void guardar(Curso actividad) {
        curepo.save(actividad);
    }

    @Override
    public Curso buscaById(Integer id) {
        return curepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        curepo.deleteById(id);
    }
    
}
