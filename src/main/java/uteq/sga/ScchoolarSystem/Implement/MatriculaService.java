/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Matricula;
import uteq.sga.ScchoolarSystem.Repositorys.IMatriculaRepository;
import uteq.sga.ScchoolarSystem.Services.IMatriculaService;

/**
 *
 * @author capur
 */
@Service
public class MatriculaService implements IMatriculaService{
    
    @Autowired
    private IMatriculaRepository matrepo;

    @Override
    public List<Matricula> listarTodos() {
        return (List<Matricula>) matrepo.findAll();
    }

    @Override
    public void guardar(Matricula actividad) {
        matrepo.save(actividad);
    }

    @Override
    public Matricula buscaById(Integer id) {
       return matrepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        matrepo.deleteById(id);
    }
    
}
