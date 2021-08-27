/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.ScchoolarSystem.Entity.Curso;
import uteq.sga.ScchoolarSystem.Services.ICursoService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Curso")
public class CursoController {
    
    @Autowired
    private ICursoService curserv;
    
    @RequestMapping("/listado")
    public String page(Model model) {
        List<Curso> curso= curserv.listarTodos();
        model.addAttribute("Titulo", "Listado de Cursos");
        model.addAttribute("curso", curso);
        return "/Admin/Cursolist";
    }
    
}
