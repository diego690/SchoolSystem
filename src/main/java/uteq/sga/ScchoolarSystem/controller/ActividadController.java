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
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.ScchoolarSystem.Entity.Actividad;
import uteq.sga.ScchoolarSystem.Services.ActividadService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin")
public class ActividadController {
    
    @Autowired
    private ActividadService activiSer;
    
    @RequestMapping("/listaActividad")
    public String page(Model model) {
        List<Actividad> listaActividad = activiSer.listarTodos();
        model.addAttribute("actividades", "Listado de Actividades");
        model.addAttribute("actividad", listaActividad);
        return "/Admin/Actividades";
    }
    
    @GetMapping("/Create")
    public String crear(Model model){
        model.addAttribute("Create", "Crear Actividad");
        return "/Admin/ActividadAdd";
    }
}
