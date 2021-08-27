/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Tareas;

/**
 *
 * @author capur
 */
public interface ITareasService {
    public List<Tareas> listarTodos();
    public void guardar(Tareas actividad);
    public Tareas buscaById(Integer id);
    public void eliminar(Integer id);
}
