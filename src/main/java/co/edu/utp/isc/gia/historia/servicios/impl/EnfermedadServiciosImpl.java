package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.EnfermedadDTO;
import co.edu.utp.isc.gia.historia.entidades.EnfermedadEntidad;
import co.edu.utp.isc.gia.historia.repositorio.EnfermedadRepositorio;
import co.edu.utp.isc.gia.historia.servicios.EnfermedadServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class EnfermedadServiciosImpl implements EnfermedadServicios {

    @Autowired
    private EnfermedadRepositorio enfermedadRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnfermedadDTO saveEnfermedad(EnfermedadDTO enfermedadDTO) {
        return modelMapper.map(
                enfermedadRepositorio.save(
                        modelMapper.map(enfermedadDTO, EnfermedadEntidad.class)
                ),EnfermedadDTO.class
        );
    }

    @Override
    public EnfermedadDTO getEnfermedad(Long id) {
        if (enfermedadRepositorio.existsById(id)){
            return modelMapper.map(enfermedadRepositorio.findById(id).get(), EnfermedadDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<EnfermedadDTO> getAllEnfermedades() {
        List<EnfermedadDTO> enfermedadDTOS = new ArrayList<>();
        enfermedadRepositorio.findAll().forEach(enfermedadEntidad ->
                enfermedadDTOS.add(
                        modelMapper.map( enfermedadEntidad, EnfermedadDTO.class )
                ));
        return enfermedadDTOS;
    }

    @Override
    public boolean deleteEnfermedad(Long id) {
        if(enfermedadRepositorio.existsById(id)){
            enfermedadRepositorio.deleteById(id);
            return true;
        }else{
            return  false;
        }
    }

    @Override
    public boolean putEnfermedad(Long id, EnfermedadDTO enfermedadDTO) {
        if(enfermedadRepositorio.existsById(id)){
            EnfermedadEntidad enfermedadEntidad = modelMapper.map(enfermedadDTO, EnfermedadEntidad.class);
            enfermedadRepositorio.save(enfermedadEntidad);
            return true;
        }
        return false;
    }
}
