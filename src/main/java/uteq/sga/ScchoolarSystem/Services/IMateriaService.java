/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Materia;

/**
 *
 * @author capur
 */
public interface IMateriaService {
      public List<Materia> listarTodos();
    public void guardar(Materia actividad);
    public Materia buscaById(Integer id);
    public void eliminar(Integer id);
}
