/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Tiporecurso;
import uteq.sga.ScchoolarSystem.Repositorys.ITipoRecursoRepository;
import uteq.sga.ScchoolarSystem.Services.ITipoRecursoService;

/**
 *
 * @author capur
 */
@Service
public class TipoRecursoServiceImpl implements ITipoRecursoService{

    @Autowired
    private ITipoRecursoRepository tipoR;
    
    @Override
    public List<Tiporecurso> listarTodos() {
        return (List<Tiporecurso>) tipoR.findAll();
    }

    @Override
    public void guardar(Tiporecurso tipoRecu) {
        tipoR.save(tipoRecu);
    }

    @Override
    public Tiporecurso buscaById(Integer id) {
        return tipoR.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tipoR.deleteById(id);
    }
    
}
