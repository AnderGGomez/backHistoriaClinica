package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.PacienteDTO;
import co.edu.utp.isc.gia.historia.entidades.PacienteEntidad;
import co.edu.utp.isc.gia.historia.repositorio.PacienteRepositorio;
import co.edu.utp.isc.gia.historia.servicios.PacienteServicios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiciosImpl implements PacienteServicios {
    /**
     * Se describen difernetes tipos de servicios que son prestados a la logica del negocio de un paciente
     * -almacenamiento de datos
     * -consulta de datos.
     * -eliminacion de datos.
     * -actualizacion de informacion.
     *
     * @autor Anderson Gomez Gomez*/
    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteServiciosImpl(PacienteRepositorio pacienteRepositorio, ModelMapper modelMapper){
        this.pacienteRepositorio    = pacienteRepositorio;
        this.modelMapper            = modelMapper;
    }
    @Override
    public PacienteDTO savePaciente(PacienteDTO pacienteDTO) {
        /**
         *Almacena un paciente en la base de datos.
         * @return un PacienteDTO*/
        PacienteDTO paciente = modelMapper.map(pacienteRepositorio.save(modelMapper.map(pacienteDTO, PacienteEntidad.class)), PacienteDTO.class);
        if(paciente != null){
            return  paciente;
        }else{
            return null;
        }
    }

    @Override
    public PacienteDTO getPaciente(Long id) {
        /**
         *Consulta y obtiene un paciente en la base de datos.
         * @return un PacienteDTO.*/
        if(pacienteRepositorio.existsById(id)){
            return modelMapper.map(pacienteRepositorio.findById(id).get(),PacienteDTO.class);
        }
        return null;
    }

    @Override
    public PacienteEntidad getPacienteEntidad(Long id) {
        /**
         * Consulta y obtiene un paciente en la base de datos.
         * @return un PacienteDTO.
         * */
        if(pacienteRepositorio.existsById(id)){
            return pacienteRepositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean existPaciente(Long id) {
        if(pacienteRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<PacienteDTO> getAllPaciente() {
        /**
         *Consulta y retorna todos los pacientes en la base de datos.
         * @return retorna una lista de pacienteDTO.*/
        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        pacienteRepositorio.findAll().forEach(pacienteEntidad -> pacientesDTO.add(modelMapper.map(pacienteEntidad, PacienteDTO.class)));
        return pacientesDTO;
    }

    @Override
    public boolean deletePaciente(Long id) {
        /**
         *Consulta y elimina el registro que coincida con el ID.
         * @return true si la operacion fue exitosa*/
        if(pacienteRepositorio.existsById(id)){
            PacienteEntidad pacienteEntidad=pacienteRepositorio.findById(id).get();
            pacienteRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean putPaciente(Long id, PacienteDTO pacienteDTO) {
        /**
         *Consulta y actualiza el registro que coincida con el ID.
         * @return true si la operacion fue exitosa
         * */
        if(pacienteRepositorio.existsById(id)){
            pacienteRepositorio.save(modelMapper.map(pacienteDTO, PacienteEntidad.class));
            return true;
        }
        return false;
    }


}
