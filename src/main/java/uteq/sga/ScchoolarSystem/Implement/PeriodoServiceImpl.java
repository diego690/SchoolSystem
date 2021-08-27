/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Periodo;
import uteq.sga.ScchoolarSystem.Repositorys.IPeriodoRepository;
import uteq.sga.ScchoolarSystem.Services.IPeriodoService;

/**
 *
 * @author capur
 */
@Service
public class PeriodoServiceImpl implements IPeriodoService{
    
    @Autowired
    private IPeriodoRepository periodR;

    @Override
    public List<Periodo> listarTodos() {
        return (List<Periodo>) periodR.findAll();
    }

    @Override
    public void guardar(Periodo actividad) {
        periodR.save(actividad);
    }

    @Override
    public Periodo buscaById(Integer id) {
        return periodR.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
       periodR.deleteById(id);
    }
    
}
