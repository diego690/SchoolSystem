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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.ScchoolarSystem.Entity.Matricula;
import uteq.sga.ScchoolarSystem.Services.IMatriculaService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Matriculas")
public class MatriculaController {
    
    @Autowired
    private IMatriculaService matriserv;
    
    @RequestMapping("/listado")
    public String page(Model model) {
        List<Matricula> matriculas = matriserv.listarTodos();
        model.addAttribute("Title", "Listado de Matriculas");
        model.addAttribute("Titulo", "Listado de Matriculas");
        model.addAttribute("matricula", matriculas);
        return "/Admin/Matriculalist";
    }
    @GetMapping("/create")
    public String crearMatricula(Model model){
        Matricula matri = new Matricula();
        model.addAttribute("Title", "Nueva  Matricula");
        model.addAttribute("Titulo", "Nueva Matricula");
        model.addAttribute("matricula", matri);
        return "/Admin/matriculaAdd";
    }
    @PostMapping("/save")
    public String guardar(@ModelAttribute Matricula user){
        matriserv.guardar(user);
        System.out.println("Matricula registrada con exito");
        return "redirect:/Matriculas/listado";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id,Model model){
        Matricula matri= matriserv.buscaById(id);
         model.addAttribute("Titulo", "Nueva Matricula");
        model.addAttribute("matricula", matri);
        return "/Admin/matriculaAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        matriserv.eliminar(id);
        return "redirect:/Matriculas/listado";
    }
    
}
