/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Tipousuario;

/**
 *
 * @author capur
 */
public interface ITipoUsuarioService {
    public List<Tipousuario> listarTodos();
    public void guardar(Tipousuario user);
    public Tipousuario buscaById(Short id);
    public void eliminar(Short id);
}
