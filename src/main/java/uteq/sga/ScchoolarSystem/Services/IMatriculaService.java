/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Matricula;

/**
 *
 * @author capur
 */
public interface IMatriculaService {
     public List<Matricula> listarTodos();
    public void guardar(Matricula actividad);
    public Matricula buscaById(Integer id);
    public void eliminar(Integer id);
}
