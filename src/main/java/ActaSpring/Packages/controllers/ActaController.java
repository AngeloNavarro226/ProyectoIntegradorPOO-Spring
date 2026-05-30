package ActaSpring.Packages.controllers;

import ActaSpring.Packages.entities.*;
import ActaSpring.Packages.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actas")
public class ActaController {

    @Autowired
    private ActaDeConstatacionService actaService;

    @Autowired
    private AutoridadDeConstatacionService autoridadService;

    @Autowired
    private InfraccionService infraccionService;

    // Mostrar Listado
    @GetMapping
    public String listarActas(Model model) {
        try {
            model.addAttribute("actas", actaService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "lista-actas";
    }

    // Mostrar Formulario
    @GetMapping("/crear")
    public String crearActa(Model model) {
        try {
            model.addAttribute("autoridades", autoridadService.findAll());
            model.addAttribute("infracciones", infraccionService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "crear-acta";
    }

    // Recibir Formulario y Guardar
    @PostMapping("/guardar")
    public String guardarActa(
            @RequestParam String fecha, @RequestParam String hora,
            @RequestParam(value = "fechaVencimiento", required = false) String fechaVencimiento,
            @RequestParam String lugar,
            @RequestParam String infractorNombre, @RequestParam String infractorApellido,
            @RequestParam String infractorDni,
            @RequestParam(required = false) String infractorDomicilio,
            @RequestParam(required = false) String infractorVtoLicencia,
            @RequestParam(required = false, defaultValue = "0") int infractorPuntos,
            @RequestParam String vehiculoDominio,
            @RequestParam(required = false) String vehiculoColor,
            @RequestParam(required = false, defaultValue = "0") int vehiculoAnio,
            @RequestParam Long autoridadId, @RequestParam Long infraccionId,
            @RequestParam String infraccionRuta) {

        try {
            ActaDeConstatacion acta = new ActaDeConstatacion();
            acta.setFechaDeLabrado(fecha);
            acta.setHoraDeLabrado(hora);
            acta.setFechaVtoPagoVolun(fechaVencimiento);
            acta.setLugarDeConstatacion(lugar);

            // Vehículo
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setDominio(vehiculoDominio);
            vehiculo.setColor(vehiculoColor);
            vehiculo.setAnioPatentamiento(vehiculoAnio);
            acta.setVehiculo(vehiculo);


            // Autoridad
            AutoridadDeConstatacion autoridad = autoridadService.findById(autoridadId);
            acta.setAutoridadConstatacion(autoridad);

            // Ruta
            Ruta ruta = new Ruta();
            ruta.setNombreRuta(infraccionRuta);
            acta.setRuta(ruta);

            // Infracción
            Infraccion infraccion = infraccionService.findById(infraccionId);
            acta.addInfraccion(infraccion);

            // Conductor
            Conductor conductor = new Conductor();
            conductor.setNombre(infractorNombre);
            conductor.setApellido(infractorApellido);
            conductor.setDni(Integer.parseInt(infractorDni));
            conductor.setDomicilio(infractorDomicilio);

            // Licencia
            Licencias licencia = new Licencias();
            licencia.setConductor(conductor);
            licencia.setFechaDeVto(infractorVtoLicencia);
            licencia.setPuntosInicialesLicencia(infractorPuntos);
            acta.setLicencia(licencia);

            actaService.save(acta);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/actas";
    }


    // Mostrar Detalle de un Acta
    @GetMapping("/detalle/{id}")
    public String detalleActa(@PathVariable Long id, Model model) {
        try {
            ActaDeConstatacion acta = actaService.findById(id);
            model.addAttribute("acta", acta);


            double total = 0;
            for (Infraccion inf : acta.getInfraccion()) {
                total += inf.getImportedeInfraccion();
            }
            model.addAttribute("totalMonto", total);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "detalle-acta";
    }
}