package ActaSpring.Packages.controllers;

import ActaSpring.Packages.entities.Infraccion;
import ActaSpring.Packages.services.InfraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/infracciones")
public class InfraccionController {

    @Autowired
    private InfraccionService infraccionService;

    // Mostrar Listado de Infracciones
    @GetMapping
    public String listarInfracciones(Model model) {
        try {
            model.addAttribute("infracciones", infraccionService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "lista-infracciones";
    }

    // Mostrar Formulario para Crear
    @GetMapping("/crear")
    public String crearInfraccion() {
        return "crear-infraccion";
    }

    // Recibir Formulario y Guardar
    @PostMapping("/guardar")
    public String guardarInfraccion(
            @RequestParam String descipInfraccion,
            @RequestParam Double importedeInfraccion) {

        try {
            Infraccion infraccion = new Infraccion();
            infraccion.setDescipInfraccion(descipInfraccion);
            infraccion.setImportedeInfraccion(importedeInfraccion);

            infraccionService.save(infraccion);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/infracciones";
    }
}