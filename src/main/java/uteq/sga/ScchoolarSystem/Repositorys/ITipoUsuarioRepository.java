/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uteq.sga.ScchoolarSystem.Entity.Tipousuario;

/**
 *
 * @author capur
 */
@Repository
public interface ITipoUsuarioRepository extends CrudRepository<Tipousuario, Short>{
    
}
