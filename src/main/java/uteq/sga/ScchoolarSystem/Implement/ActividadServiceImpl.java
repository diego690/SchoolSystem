/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Actividad;
import uteq.sga.ScchoolarSystem.Repositorys.ActividadesRepository;
import uteq.sga.ScchoolarSystem.Services.ActividadService;

/**
 *
 * @author capur
 */
@Service
public class ActividadServiceImpl implements ActividadService{

    
    @Autowired
    private ActividadesRepository actividadRepo;
    
    @Override
    public List<Actividad> listarTodos() {
        return (List<Actividad>) actividadRepo.findAll();
    }

    @Override
    public void guardar(Actividad actividad) {
       actividadRepo.save(actividad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actividad buscaById(Long id) {
        return actividadRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
         actividadRepo.deleteById(id);
    }
    
}
