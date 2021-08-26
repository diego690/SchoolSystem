/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Actividad;

/**
 *
 * @author capur
 */
public interface ActividadService {
    public List<Actividad> listarTodos();
    public void guardar(Actividad actividad);
    public Actividad buscaById(Long id);
    public void eliminar(Long id);
}
