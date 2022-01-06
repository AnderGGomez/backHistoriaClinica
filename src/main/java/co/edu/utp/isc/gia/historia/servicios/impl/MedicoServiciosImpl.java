package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.MedicoDTO;
import co.edu.utp.isc.gia.historia.entidades.MedicoEntidad;
import co.edu.utp.isc.gia.historia.repositorio.MedicoRepositorio;
import co.edu.utp.isc.gia.historia.servicios.MedicoServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicoServiciosImpl implements MedicoServicios {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public MedicoDTO saveMedico(MedicoDTO medicoDTO) {
        /**
         *Almacena un medico  en la base de datos.
         * @return un MedicoDTO
         * */
        return modelMapper.map(medicoRepositorio.save(modelMapper.map(medicoDTO, MedicoEntidad.class)), MedicoDTO.class);

    }

    @Override
    public MedicoDTO getMedico(Long id) {
        /**
         *Consulta y obtiene un medico en la base de datos.
         * @return un MedicoDTO.*/
        if(medicoRepositorio.existsById(id)){
            return modelMapper.map(medicoRepositorio.findById(id).get(),MedicoDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<MedicoDTO> getAllMedicos() {
        /**
         *Consulta y retorna todos los medicos en la base de datos.
         * @return retorna una lista de objetos MedicoDTO.*/
        List<MedicoDTO> pacientesDTO = new ArrayList<>();
        medicoRepositorio.findAll().forEach(pacienteEntidad -> pacientesDTO.add(modelMapper.map(pacienteEntidad, MedicoDTO.class)));
        return pacientesDTO;
    }

    @Override
    public boolean deleteMedico(Long id) {
        /**
         *Consulta y elimina el registro que coincida con el ID.
         * @return true si la operacion fue exitosa*/
        if(medicoRepositorio.existsById(id)){
            medicoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean putMedico(Long id, MedicoDTO medicoDTO) {
        /**
         *Consulta y actualiza el registro que coincida con el ID.
         * @return true si la operacion fue exitosa*/
        if(medicoRepositorio.existsById(id)){
            medicoRepositorio.save(modelMapper.map(medicoDTO, MedicoEntidad.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean existMedico(Long id) {
        return medicoRepositorio.existsById(id);
    }
}
