package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.*;
import co.edu.utp.isc.gia.historia.entidades.*;
import co.edu.utp.isc.gia.historia.repositorio.PersonalRepositorio;
import co.edu.utp.isc.gia.historia.servicios.HistoriaServicios;
import co.edu.utp.isc.gia.historia.servicios.MedicoServicios;
import co.edu.utp.isc.gia.historia.servicios.PersonalServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service

public class PersonalServiciosImpl implements PersonalServicios {

    @Autowired
    private PersonalRepositorio personalRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HistoriaServicios historiaServicios;

    @Autowired
    private MedicoServicios medicoServicios;

    @Override
    public PersonalDTO savePersonal(PersonalDTO personalDTO) {
        if(historiaServicios.existHistoria(personalDTO.getHistoria().getId())){
            if(medicoServicios.existMedico(personalDTO.getMedico().getId())){

                /*List<EnfermedadEntidad> enfermedadEntidads = new ArrayList<>();
                personalDTO.getEnfermedades().forEach(enfermedadDTO -> enfermedadEntidads.add(
                        modelMapper.map(enfermedadDTO, EnfermedadEntidad.class)
                ));*/

                PersonalEntidad personalEntidad = modelMapper.map(personalDTO, PersonalEntidad.class);

                return modelMapper.map(personalRepositorio.save(personalEntidad),PersonalDTO.class);
            }else{
                return  null;
            }
        }else{
            return null;
        }

    }


    @Override
    public PersonalDTO getPersonal(Long id) {
        if(personalRepositorio.existsById(id)){
            return modelMapper.map(personalRepositorio.findById(id).get(),PersonalDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<PersonalDTO> getAllPersonal() {
        List<PersonalDTO> personalDTOS = new ArrayList<>();
        personalRepositorio.findAll().forEach(personalEntidad -> personalDTOS.add(
                modelMapper.map(personalEntidad, PersonalDTO.class)
        ));

        return personalDTOS;
    }

    @Override
    public boolean deletePersonal(Long id) {
        if(personalRepositorio.existsById(id)){
            personalRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putPersonal(Long id, PersonalDTO personalDTO) {
        if (personalRepositorio.existsById(id)){
            if(historiaServicios.existHistoria(personalDTO.getHistoria().getId())){
                if(medicoServicios.existMedico(personalDTO.getMedico().getId())){
                    PersonalEntidad personalEntidad = modelMapper.map(personalDTO, PersonalEntidad.class);
                    personalRepositorio.save(personalEntidad);
                    return true;
                }else{
                    return  false;
                }
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public List<PersonalDTO> getPersonalByHistoria(Long id) {
        if(historiaServicios.existHistoria(id)){
            List<PersonalDTO> personalDTOS = new ArrayList<>();
            personalRepositorio.findByHistoria_Id(id).forEach(personalEntidad -> personalDTOS.add(
                    modelMapper.map(personalEntidad, PersonalDTO.class)
            ));
            return personalDTOS;
        }else{
            return null;
        }
    }

    @Override
    public boolean existePersonal(Long id) {
        if (personalRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }
}
