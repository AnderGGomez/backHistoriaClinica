package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.CirugiaDTO;
import co.edu.utp.isc.gia.historia.servicios.CirugiaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cirugia")
public class CirugiaController {
    @Autowired
    private CirugiaServicios cirugiaServicios;

    @PostMapping
    public CirugiaDTO guardarCirugia(@RequestBody CirugiaDTO cirugiaDTO){
        return cirugiaServicios.saveCirugia(cirugiaDTO);
    }

    @GetMapping("{id}")
    public CirugiaDTO obtenerCirugia(@PathVariable("id") Long id){
        return cirugiaServicios.getCirugia(id);
    }

    @GetMapping("getAll")
    public List<CirugiaDTO> obtenerCirugias(){
        return cirugiaServicios.getAllCirugias();
    }

    @DeleteMapping("{id}")
    public boolean borrarCirugia(@PathVariable("id") Long id){
        return cirugiaServicios.deleteCirugia(id);
    }

    @PutMapping("{id}")
    public boolean actualizarCirugia(@PathVariable("id") Long id, @RequestBody CirugiaDTO cirugiaDTO){
        return  cirugiaServicios.putCirugia(id, cirugiaDTO);
    }

    @GetMapping("getAll/{id}")
    public List<CirugiaDTO> obtenerCirugiasByHistoria(@PathVariable("id") Long id){
        return cirugiaServicios.getCirugiasByHistoria(id);
    }

    @GetMapping("exist/{id}")
    public boolean existeCirugia(@PathVariable("id") Long id){
        return cirugiaServicios.existeCirugia(id);
    }
}
