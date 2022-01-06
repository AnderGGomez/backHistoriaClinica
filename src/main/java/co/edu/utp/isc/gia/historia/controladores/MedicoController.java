package co.edu.utp.isc.gia.historia.controladores;

import co.edu.utp.isc.gia.historia.dto.MedicoDTO;
import co.edu.utp.isc.gia.historia.servicios.MedicoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {
    /**
     * Controlar y end-point para el componente de Medicos
     * */
    @Autowired
    private MedicoServicios medicoServicios;

    @PostMapping
    public MedicoDTO guardarMedico(@RequestBody MedicoDTO medicoDTO){
        /**
         * Recibe un medico por medio de POST y envia la informacion a los servicios para su almacenamiento.
         *
         * @param medicoDTO es un objeto de tipo MedicoDTO recibido por medio de una peticion POST
         * @return objeto MedicoDTO en caso de un almacenamiento exitoso, o un error en caso de haber ocurrido
         *         un problema
         * */
        return medicoServicios.saveMedico(medicoDTO);
    }

    @GetMapping("{id}")
    public MedicoDTO obtenerMedico(@PathVariable("id") Long id){
        /**
         * Recibe un numero de identificacion por medio de una peticion GET y envia la informacion a los
         * servicios para su consulta.
         *
         * @param id es el id unico de cada medico.
         * @return Objeto Medico DTO en caso de una obtencion exitosa, o un error en caso de haber ocurrido
         *         un problema en su recuperacion.
         * */
        return medicoServicios.getMedico(id);
    }

    @GetMapping("getAll")
    public List<MedicoDTO> obtenerMedicos(){
        /**
         * Lista todos los medicos almacenados.
         *
         * @return una lista de objetos MedicoDTO
         * */
        return medicoServicios.getAllMedicos();
    }

    @DeleteMapping("{id}")
    public boolean deleteMedico(@PathVariable("id") Long id){
        /**
         * Recibe un numero de identificacion por medio de una peticion DELETE y envia la informacion a los
         * servicios para su eliminacion.
         *
         * @param id es el id unico de cada medico.
         * @return true:  en caso de una eliminacion exitosa
         *         false: en caso de haber ocurrido un error.
         * */
        return medicoServicios.deleteMedico(id);
    }

    @PutMapping("{id}")
    public boolean updatePaciente(@PathVariable("id") Long id, @RequestBody MedicoDTO medicoDTO){
        /**
         * Recibe un numero de identificacion  y un objeto medicoDTO por medio de una peticion PUT
         * y envia la informacion a los servicios para su eliminacion.
         *
         * @param id es el id unico de cada medico.
         * @param MedicoDTO informacion del medico.
         * @return true:  en caso de una actualizacion exitosa
         *         false: en caso de haber ocurrido un error.
         * */
        return medicoServicios.putMedico(id, medicoDTO);
    }
}
