/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Services;

import java.util.List;
import uteq.sga.ScchoolarSystem.Entity.Usuario;

/**
 *
 * @author capur
 */
public interface IUsuarioService {
    public List<Usuario> listarTodos();
    public void guardar(Usuario user);
    public Usuario buscaById(Long id);
    public void eliminar(Long id);
}
