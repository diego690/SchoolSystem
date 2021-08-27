/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Tareas;
import uteq.sga.ScchoolarSystem.Repositorys.ITareaRepository;
import uteq.sga.ScchoolarSystem.Services.ITareasService;

/**
 *
 * @author capur
 */
@Service
public class TareasServiceImpl implements ITareasService{

    @Autowired
    private ITareaRepository tareaRep;
    
    @Override
    public List<Tareas> listarTodos() {
        return (List<Tareas>) tareaRep.findAll();
    }

    @Override
    public void guardar(Tareas actividad) {
        tareaRep.save(actividad);
    }

    @Override
    public Tareas buscaById(Integer id) {
        return tareaRep.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tareaRep.deleteById(id);
    }
    
}
