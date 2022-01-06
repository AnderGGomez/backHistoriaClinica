package co.edu.utp.isc.gia.historia.controladores;


import co.edu.utp.isc.gia.historia.dto.HerenciaDTO;
import co.edu.utp.isc.gia.historia.servicios.HerenciaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("herencia")
public class HerenciaController{

    @Autowired
    private HerenciaServicios herenciaServicios;

    @PostMapping
    public HerenciaDTO guardarHerencia(@RequestBody HerenciaDTO herenciaDTO){
        return herenciaServicios.saveHerencia(herenciaDTO);
    }

    @GetMapping("{id}")
    public HerenciaDTO obtenerHerencia(@PathVariable("id") Long id){
        return herenciaServicios.getHerencia(id);
    }

    @GetMapping("getAll")
    public List<HerenciaDTO> obtenerHerencias(){
        return herenciaServicios.getAllHerencia();
    }

    @DeleteMapping("{id}")
    public boolean borrarHerencia(@PathVariable("id") Long id){
        return herenciaServicios.deleteHerencia(id);
    }

    @PutMapping("{id}")
    public boolean actualizarHerencia(@PathVariable("id") Long id, @RequestBody HerenciaDTO herenciaDTO ){
        return herenciaServicios.putHerencia(id, herenciaDTO);
    }

    @GetMapping("getAll/{id}")
    public List<HerenciaDTO> obtenerHerenciabyHistoria(@PathVariable("id") Long id){
        return herenciaServicios.getHerenciaByHistoria(id);
    }

    @GetMapping("exist/{id}")
    public boolean existeHerencia(@PathVariable("id") Long id){
        return herenciaServicios.existeHerencia(id);
    }
}
