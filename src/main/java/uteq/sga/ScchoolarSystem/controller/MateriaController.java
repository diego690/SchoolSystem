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
import uteq.sga.ScchoolarSystem.Entity.Materia;
import uteq.sga.ScchoolarSystem.Services.IMateriaService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Materias")
public class MateriaController {
    
    @Autowired
    private IMateriaService mateserv;
    
    @RequestMapping("/listado")
    public String page(Model model) {
        List<Materia> materia= mateserv.listarTodos();
        model.addAttribute("Titulo", "Listado de Materias");
        model.addAttribute("Title", "Listado de Materias");
        model.addAttribute("materias", materia);
        return "/Admin/Materialist";
    }
    @GetMapping("/create")
    public String create(Model model){
        Materia mater=new Materia();
         model.addAttribute("Titulo", "Nueva Materia");
        model.addAttribute("Title", "Nueva Materia");
        model.addAttribute("materias", mater);
        return "/Admin/MateriaAdd";
    }
    @PostMapping("/save")
    public String guardar(@ModelAttribute Materia user){
        mateserv.guardar(user);
        System.out.println("Materia Guardada exitosamente");
        return "redirect:/Materias/listado";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Materia mt= mateserv.buscaById(id);
        model.addAttribute("Titulo", "Nueva Materia");
        model.addAttribute("Title", "Nueva Materia");
        model.addAttribute("materias", mt);
        return "/Admin/MateriaAdd";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        mateserv.eliminar(id);
        return "redirect:/Materias/listado";
    }
    
}
