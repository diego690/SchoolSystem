/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Periodo;

/**
 *
 * @author capur
 */
public interface IPeriodoService {
     public List<Periodo> listarTodos();
    public void guardar(Periodo actividad);
    public Periodo buscaById(Integer id);
    public void eliminar(Integer id);
}
