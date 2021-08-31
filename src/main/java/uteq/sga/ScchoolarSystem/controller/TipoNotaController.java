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
import uteq.sga.ScchoolarSystem.Entity.Tareas;
import uteq.sga.ScchoolarSystem.Entity.Tiponotas;
import uteq.sga.ScchoolarSystem.Services.ITareasService;
import uteq.sga.ScchoolarSystem.Services.ITipoNotaService;

/**
 *@DateTimeFormat(pattern = "yyyy-MM-dd")
 * @author capur
 */
@Controller
@RequestMapping("/TipoNota")
public class TipoNotaController {
    
    @Autowired
    private ITipoNotaService tpnota;
    
    @Autowired
    private ITareasService tareserv;
    
    @RequestMapping("/listTipoNota")
    public String page(Model model) {
        List<Tiponotas> tiponotas= tpnota.listarTodos();
        model.addAttribute("Titulo", "Listado Tipo de Notas");
        model.addAttribute("tiponota", tiponotas);
        return "/Admin/tiponotalist";
    }
    @GetMapping("/createTipoNota")
    public String crearTipoNota(Model model){
        Tiponotas trecur = new Tiponotas();
        
        List<Tareas> tpus= tareserv.listarTodos();
        model.addAttribute("Titulo", "Nuevo Tipo De Nota");
        model.addAttribute("tiponota", trecur);
        model.addAttribute("tareas", tpus);
        return "/Admin/addtiponota";
    }
     @PostMapping("/addTipoNota")
    public String guardaUsuario(@ModelAttribute Tiponotas user){
        tpnota.guardar(user);
        System.out.println("Tipo Nota guardado con exito");
        return "redirect:/TipoNota/listTipoNota";
    }
    @GetMapping("/editarTipoNota/{id}")
    public String EditarTipoNota(@PathVariable("id") Integer idnota, Model model){
        Tiponotas tnotas = tpnota.buscaById(idnota);
        model.addAttribute("Titulo", "Editar Tipo de Nota");
         List<Tareas> tpus= tareserv.listarTodos();
         model.addAttribute("tiponota", tnotas);
         model.addAttribute("tarea", tpus);
         return "/Admin/addtiponota";
    }
    @GetMapping("/deleteTipoNota/{id}")
    public String deleteTnota(@PathVariable("id") Integer idtiponota, Model model){
        tpnota.eliminar(idtiponota);
        return "redirect:/TipoNota/listTipoNota";
    }
    
}
