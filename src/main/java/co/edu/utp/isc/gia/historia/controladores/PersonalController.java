package co.edu.utp.isc.gia.historia.controladores;


import co.edu.utp.isc.gia.historia.dto.CirugiaDTO;
import co.edu.utp.isc.gia.historia.dto.PersonalDTO;
import co.edu.utp.isc.gia.historia.servicios.PersonalServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personal")
public class PersonalController {
    @Autowired
    private PersonalServicios personalServicios;

    @PostMapping
    public PersonalDTO guardarPersonal(@RequestBody PersonalDTO personalDTO){
        return personalServicios.savePersonal(personalDTO);
    }

    @GetMapping("{id}")
    public PersonalDTO obtenerPersonal(@PathVariable("id") Long id){
        return personalServicios.getPersonal(id);
    }

    @GetMapping("getAll")
    public List<PersonalDTO> obtenerPersonales(){
        return personalServicios.getAllPersonal();
    }

    @DeleteMapping("{id}")
    public boolean borrarPersonal(@PathVariable("id") Long id){
        return personalServicios.deletePersonal(id);
    }


    @PutMapping("{id}")
    public boolean actualizarPersonal(@PathVariable("id") Long id, @RequestBody PersonalDTO personalDTO){
        return personalServicios.putPersonal(id, personalDTO);
    }

    @GetMapping("getAll/{id}")
    public List<PersonalDTO> obtenerPersonalByHistoria(@PathVariable("id") Long id){
        return personalServicios.getPersonalByHistoria(id);
    }

    @GetMapping("exist/{id}")
    public boolean existePersonal(@PathVariable("id") Long id){
        return personalServicios.existePersonal(id);
    }
}
