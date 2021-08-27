/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Curso;

/**
 *
 * @author capur
 */
public interface ICursoService {
    public List<Curso> listarTodos();
    public void guardar(Curso actividad);
    public Curso buscaById(Integer id);
    public void eliminar(Integer id);
}
