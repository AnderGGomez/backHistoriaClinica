package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.PacienteDTO;
import co.edu.utp.isc.gia.historia.servicios.PacienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")

public class PacienteController {
    /**
     * Controlador y end-point para el componente de Pacientes
     * @autor Anderson Gomez Gomez.
     * */
    @Autowired
    private PacienteServicios pacienteServicios;

    @PostMapping
    public PacienteDTO guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
        /**
         * Recibe un paciente por medio de POST y envia la informacion a los servicios para su almacenamiento.
         *
         * @param pacienteDTO es un objeto de tipo PacienteDTO recibido por medio de una peticion POST
         * @return pacienteDTO en caso de un almacenamiento exitoso, o un error en caso de haber ocurrido
         *         un problema
         * */
        return pacienteServicios.savePaciente(pacienteDTO);
    }

    @GetMapping("{id}")
    public PacienteDTO obtenerPaciente(@PathVariable("id") Long id){
        /**
         * Recibe un numero de identificacion por medio de una peticion GET y envia la informacion a los
         * servicios para su consulta.
         *
         * @param id es el id unico de cada paciente.
         * @return pacienteDTO en caso de una obtencion exitosa, o un error en caso de haber ocurrido
         *         un problema en su recuperacion.
         * */
        return pacienteServicios.getPaciente(id);
    }

    @GetMapping("getAll")
    public List<PacienteDTO> obtenerPacientes(){
        /**
         * Lista todos los pacientes almacenados.
         *
         * @return una lista de pacientesDTO
         * */
        return pacienteServicios.getAllPaciente();
    }

    @DeleteMapping("{id}")
    public boolean deletePaciente(@PathVariable("id") Long id){
        /**
         * Recibe un numero de identificacion por medio de una peticion DELETE y envia la informacion a los
         * servicios para su eliminacion.
         *
         * @param id es el id unico de cada paciente.
         * @return true:  en caso de una eliminacion exitosa
         *         false: en caso de haber ocurrido un error.
         * */
        return pacienteServicios.deletePaciente(id);
    }

    @PutMapping("{id}")
    public boolean updatePaciente(@PathVariable("id") Long id, @RequestBody PacienteDTO pacienteDTO){
        /**
         * Recibe un numero de identificacion  y un objeto pacienteDTO por medio de una peticion PUT
         * y envia la informacion a los servicios para su eliminacion.
         *
         * @param id es el id unico de cada paciente.
         * @param pacienteDTO informacion del paciente.
         * @return true:  en caso de una actualizacion exitosa
         *         false: en caso de haber ocurrido un error.
         * */
        return pacienteServicios.putPaciente(id, pacienteDTO);
    }
}
