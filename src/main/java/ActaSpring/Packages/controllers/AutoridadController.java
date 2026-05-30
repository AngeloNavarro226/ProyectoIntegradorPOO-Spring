package ActaSpring.Packages.controllers;

import ActaSpring.Packages.entities.AutoridadDeConstatacion;
import ActaSpring.Packages.services.AutoridadDeConstatacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autoridades")
public class AutoridadController {

    @Autowired
    private AutoridadDeConstatacionService autoridadService;

    // Mostrar Listado de Autoridades
    @GetMapping
    public String listarAutoridades(Model model) {
        try {
            model.addAttribute("autoridades", autoridadService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "lista-autoridades";
    }

    // Mostrar Formulario para Crear
    @GetMapping("/crear")
    public String crearAutoridad() {
        return "crear-autoridad";
    }

    // Recibir Formulario y Guardar
    @PostMapping("/guardar")
    public String guardarAutoridad(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String dni,
            @RequestParam String genero,
            @RequestParam int idPlaca,
            @RequestParam int idLegajo) {

        try {
            AutoridadDeConstatacion autoridad = new AutoridadDeConstatacion();
            // Atributos heredados de Persona
            autoridad.setNombre(nombre);
            autoridad.setApellido(apellido);
            autoridad.setDni(Integer.parseInt(dni));
            autoridad.setGenero(genero);

            // Atributos propios de Autoridad
            autoridad.setIdPlaca(idPlaca);
            autoridad.setIdLegajo(idLegajo);

            autoridadService.save(autoridad);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/autoridades";
    }
}