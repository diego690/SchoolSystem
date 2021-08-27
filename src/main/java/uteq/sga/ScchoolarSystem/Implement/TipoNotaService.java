/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.ScchoolarSystem.Entity.Tiponotas;
import uteq.sga.ScchoolarSystem.Repositorys.ITipoNotaRepository;
import uteq.sga.ScchoolarSystem.Services.ITipoNotaService;

/**
 *
 * @author capur
 */
@Service
public class TipoNotaService implements ITipoNotaService{
    
    @Autowired
    private ITipoNotaRepository tpnotaR;

    @Override
    public List<Tiponotas> listarTodos() {
        return (List<Tiponotas>) tpnotaR.findAll();
    }

    @Override
    public void guardar(Tiponotas actividad) {
        tpnotaR.save(actividad);
    }

    @Override
    public Tiponotas buscaById(Integer id) {
        return tpnotaR.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tpnotaR.deleteById(id);
    }
    
}
