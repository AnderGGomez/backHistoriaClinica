package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.MedicamentoDTO;
import co.edu.utp.isc.gia.historia.servicios.MedicamentoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicamento")
public class MedicamentoController {
    @Autowired
    private MedicamentoServicios medicamentoServicios;

    @PostMapping
    public MedicamentoDTO guardarMedicamento(@RequestBody MedicamentoDTO medicamentoDTO){
        return medicamentoServicios.saveMedicamento(medicamentoDTO);
    }

    @GetMapping("{id}")
    public  MedicamentoDTO obtenerMedicamento(@PathVariable("id") Long id){
        return medicamentoServicios.getMedicamento(id);
    }

    @GetMapping("getAll")
    public List<MedicamentoDTO> obtenerMedicamentos(){
        return  medicamentoServicios.getAllMedicamento();
    }

    @DeleteMapping("{id}")
    public boolean borrarMedicamento(@PathVariable("id") Long id){
        return medicamentoServicios.deleteMedicamento(id);
    }

    @PutMapping("{id}")
    public boolean actualizarMedicamento(@PathVariable("id") Long id, @RequestBody MedicamentoDTO medicamentoDTO){
        return medicamentoServicios.putMedicamento(id, medicamentoDTO);
    }

}
