package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.NacimientoDTO;
import co.edu.utp.isc.gia.historia.servicios.NacimientoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nacimiento")
public class NacimientoController {
    @Autowired
    private NacimientoServicios nacimientoServicios;

    @PostMapping
    public NacimientoDTO guardarNacimiento(@RequestBody NacimientoDTO nacimientoDTO){
        return nacimientoServicios.saveNacimiento(nacimientoDTO);
    }

    @GetMapping("{id}")
    public NacimientoDTO obtenerNacimiento(@PathVariable("id") Long id){
        return nacimientoServicios.getNacimiento(id);
    }

    @GetMapping("getAll")
    public List<NacimientoDTO> obtenerNacimientos(){
        return nacimientoServicios.getAllNacimientos();
    }

    @DeleteMapping("{id}")
    public boolean borrarNacimiento(@PathVariable("id") Long id){
        return nacimientoServicios.deleteNacimiento(id);
    }

    @PutMapping("{id}")
    public boolean actualizarNacimiento(@PathVariable("id") Long id, @RequestBody NacimientoDTO nacimientoDTO){
        return nacimientoServicios.putNacimiento(id, nacimientoDTO);
    }

    @GetMapping("getAll/{id}")
    public NacimientoDTO obtenerNacimientoByHistoria(@PathVariable("id") Long id){
        return nacimientoServicios.getNacimientoByHistoria(id);
    }

    @GetMapping("exist/{id}")
    public boolean existeNacimiento(@PathVariable("id") Long id){
        return nacimientoServicios.existeNacimiento(id);
    }
}
