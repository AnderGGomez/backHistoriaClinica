package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.HistoriaDTO;
import co.edu.utp.isc.gia.historia.servicios.HistoriaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historia")
public class HistoriaController {
    @Autowired
    private HistoriaServicios historiaServicio;

    @PostMapping()
    public HistoriaDTO crearHistoria(@RequestBody HistoriaDTO historiaDTO){
        return historiaServicio.saveHistoria(historiaDTO);
    }

    @GetMapping("{id}")
    public HistoriaDTO obtenerHistoria(@PathVariable("id") Long id){
        return historiaServicio.getHistoria(id);
    }

    @GetMapping("getAll")
    public List<HistoriaDTO> obtenerHistorias(){
        return historiaServicio.getAllHistorias();
    }
    @DeleteMapping("{id}")
    public boolean borrarHistoria(@PathVariable("id") Long id){
        return historiaServicio.deleteHistoria(id);
    }

    @PutMapping("{id}")
    public boolean actualizarHistoria(@PathVariable("id") Long id, @RequestBody HistoriaDTO historiaDTO){
        return historiaServicio.putHistoria(id, historiaDTO);
    }

    @GetMapping("getAll/{id}")
    public HistoriaDTO obtenerByPaciente(@PathVariable("id") Long id){
        return historiaServicio.getHistoriaByPaciente(id);
    }

    @GetMapping("paciente/{id}")
    public boolean haveHistory(@PathVariable("id") Long id){
        return historiaServicio.getHaveHistory(id);
    }

    @GetMapping("exist/{id}")
    public boolean existHistory (@PathVariable("id") Long id){
        return historiaServicio.existHistoria(id);
    }
}
