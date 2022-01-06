package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.FarmacologicoDTO;
import co.edu.utp.isc.gia.historia.servicios.FarmacologicoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farmacos")
public class FarmacologicoController {
    @Autowired
    private FarmacologicoServicios farmacologicoServicios;

    @PostMapping
    public FarmacologicoDTO guardarFarmaco(@RequestBody FarmacologicoDTO farmacologicoDTO){
        return farmacologicoServicios.saveFarmacologico(farmacologicoDTO);
    }

    @GetMapping("{id}")
    public FarmacologicoDTO obtenerFarmaco(@PathVariable("id") Long id){
        return farmacologicoServicios.getFarmacologico(id);
    }

    @GetMapping("getAll")
    public List<FarmacologicoDTO> obtenerFarmacos(){
        return farmacologicoServicios.getAllFarmacologico();
    }

    @DeleteMapping("{id}")
    public boolean borrarFarmaco(@PathVariable("id") Long id){
        return farmacologicoServicios.deleteFarmacologico(id);
    }

    @PutMapping("{id}")
    public boolean actualizarFarmaco(@PathVariable("id") Long id, @RequestBody FarmacologicoDTO farmacologicoDTO){
        return farmacologicoServicios.putFarmacologico(id, farmacologicoDTO);
    }

    @GetMapping("getAll/{id}")
    public List<FarmacologicoDTO> obtenerFarmacosByHistoria(@PathVariable("id") Long id){
        return farmacologicoServicios.getFarmacoByHistoria(id);
    }

    @GetMapping("exist/{id}")
    public boolean existeFarmaco(@PathVariable("id") Long id){
        return farmacologicoServicios.existeFarmaco(id);
    }


}
