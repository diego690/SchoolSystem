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
import uteq.sga.ScchoolarSystem.Entity.Periodo;
import uteq.sga.ScchoolarSystem.Services.IPeriodoService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Periodo")
public class PeriodoControlle {
    
    @Autowired
    private IPeriodoService periodoserv;
    
    @RequestMapping("/listPeriodo")
    public String page(Model model) {
        List<Periodo> period= periodoserv.listarTodos();
        model.addAttribute("Titulo", "Listado de Periodos Academicos");
        model.addAttribute("periodos", period);
        return "/Admin/periodolist";
    }
    @GetMapping("createPeriodo")
    public String crearPeriodo(Model model){
        Periodo periodo = new Periodo();
        model.addAttribute("Titulo", "Nuevo Periodo Lectivo");
        model.addAttribute("periodol", periodo);
        return "/Admin/periodoAdd";
    }
    @PostMapping("/addPeriodo")
    public String guardaPeriodo(@ModelAttribute Periodo user){
        periodoserv.guardar(user);
        System.out.println("Periodo registrado correctamente");
        return "redirect:/Periodo/listPeriodo";
    }
    @GetMapping("/editPeriodo/{id}")
    public String editarPeriodo(@PathVariable("id") Integer iduser,Model model){
        Periodo period= periodoserv.buscaById(iduser);
        model.addAttribute("Titulo", "Editar Periodo Lectivo");
        model.addAttribute("periodol", period);
        return "/Admin/periodoAdd";
    }
    @GetMapping("/deletePeriodo/{id}")
    public String deletePeriodo(@PathVariable("id") Integer id,Model model){
        periodoserv.eliminar(id);
        return "redirect:/Periodo/listPeriodo";
    }
    
}
