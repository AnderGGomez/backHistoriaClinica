package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.EnfermedadDTO;
import co.edu.utp.isc.gia.historia.servicios.EnfermedadServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enfermedad")
public class EnfermedadController {

    @Autowired
    private EnfermedadServicios enfermedadServicios;

    @PostMapping
    public EnfermedadDTO guardarEnfermedad(@RequestBody EnfermedadDTO enfermedadDTO){
        return enfermedadServicios.saveEnfermedad(enfermedadDTO);
    }

    @GetMapping("{id}")
    public EnfermedadDTO obtenerEnfermedad(@PathVariable("id") Long id){
        return enfermedadServicios.getEnfermedad(id);
    }

    @GetMapping("getAll")
    public List<EnfermedadDTO> obtenerEnfermedades(){
        return enfermedadServicios.getAllEnfermedades();
    }

    @DeleteMapping("{id}")
    public boolean borrarEnfermedad(@PathVariable("id") Long id){
        return enfermedadServicios.deleteEnfermedad(id);
    }

    @PutMapping("{id}")
    public  boolean actualizarEnfermedad(@PathVariable("id") Long id, @RequestBody EnfermedadDTO enfermedadDTO){
        return enfermedadServicios.putEnfermedad(id, enfermedadDTO);
    }

}
