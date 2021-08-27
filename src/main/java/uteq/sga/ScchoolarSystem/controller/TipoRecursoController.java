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
import uteq.sga.ScchoolarSystem.Entity.Tiporecurso;
import uteq.sga.ScchoolarSystem.Services.ITipoRecursoService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/TipoRecurso")
public class TipoRecursoController {
    
    @Autowired
    private ITipoRecursoService tiprec;
    
    @RequestMapping("/listaTipoRecursos")
    public String page(Model model) {
        List<Tiporecurso> tr= tiprec.listarTodos();
        model.addAttribute("tRecursos", "Lista de Recursos");
        model.addAttribute("tiporecursos", tr);
        return "/Admin/tiporecursolist";
    }
    @GetMapping("/createTipoRecurso")
    public String crearTipoRecurso(Model model){
        Tiporecurso trecur = new Tiporecurso();
        
        List<Tiporecurso> tpus= tiprec.listarTodos();
        model.addAttribute("Titulo", "Nuevo Recurso");
        model.addAttribute("tiporecurso", trecur);
        return "/Admin/addtiporecurso";
    }
    @PostMapping("/addTipoRecurso")
    public String guardaUsuario(@ModelAttribute Tiporecurso user){
        tiprec.guardar(user);
        System.out.println("Recurso guardado con exito");
        return "redirect:/TipoRecurso/listaTipoRecursos";
    }
     @GetMapping("/editTipoRecurso/{id}")
    public String EditarTRecurso(@PathVariable("id") Integer iduser, Model model){
        Tiporecurso tuser = tiprec.buscaById(iduser);
        model.addAttribute("Titulo", "Editar Tipo de Recurso");
        model.addAttribute("tiporecurso", tuser);
         return "/Admin/addtiporecurso";
    }
    @GetMapping("/deleteTRecurso/{id}")
    public String deleteUser(@PathVariable("id") Integer idtipou, Model model){
    tiprec.eliminar(idtipou);
       return "redirect:/TipoRecurso/listaTipoRecursos";
    }
    
}
