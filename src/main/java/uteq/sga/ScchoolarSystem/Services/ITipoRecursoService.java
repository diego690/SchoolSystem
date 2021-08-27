/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Tiporecurso;

/**
 *
 * @author capur
 */
public interface ITipoRecursoService {
    public List<Tiporecurso> listarTodos();
    public void guardar(Tiporecurso actividad);
    public Tiporecurso buscaById(Integer id);
    public void eliminar(Integer id);
}
