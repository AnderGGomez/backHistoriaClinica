package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.*;
import co.edu.utp.isc.gia.historia.entidades.*;
import co.edu.utp.isc.gia.historia.repositorio.NacimientoRepositorio;
import co.edu.utp.isc.gia.historia.servicios.HistoriaServicios;
import co.edu.utp.isc.gia.historia.servicios.MedicoServicios;
import co.edu.utp.isc.gia.historia.servicios.NacimientoServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class NacimientoServiciosImpl implements NacimientoServicios {

    @Autowired
    private NacimientoRepositorio nacimientoRepositorio;

    @Autowired
    private HistoriaServicios historiaServicios;

    @Autowired
    private MedicoServicios medicoServicios;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public NacimientoDTO saveNacimiento(NacimientoDTO nacimientoDTO) {
        if(historiaServicios.existHistoria(nacimientoDTO.getHistoria().getId())){
            if(medicoServicios.existMedico(nacimientoDTO.getMedico().getId())){
                if (nacimientoRepositorio.findByHistoria_Id(nacimientoDTO.getHistoria().getId())!=null){
                    return null;
                }else{
                    NacimientoEntidad nacimientoEntidad = modelMapper.map(nacimientoDTO, NacimientoEntidad.class);
                    return modelMapper.map(nacimientoRepositorio.save(nacimientoEntidad),NacimientoDTO.class);
                }
            }else{
                return  null;
            }
        }else{
            return null;
        }

    }


    @Override
    public NacimientoDTO getNacimiento(Long id) {
        if (nacimientoRepositorio.existsById(id)){
            NacimientoEntidad nacimientoEntidad = nacimientoRepositorio.findById(id).get();
            return modelMapper.map(nacimientoEntidad, NacimientoDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<NacimientoDTO> getAllNacimientos() {
        List<NacimientoDTO> nacimientoDTOS = new ArrayList<>();
        nacimientoRepositorio.findAll().forEach(nacimientoEntidad -> nacimientoDTOS.add(
                modelMapper.map(nacimientoEntidad, NacimientoDTO.class)
        ));
        return nacimientoDTOS;
    }

    @Override
    public boolean deleteNacimiento(Long id) {
        if(nacimientoRepositorio.existsById(id)){
            nacimientoRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putNacimiento(Long id, NacimientoDTO nacimientoDTO) {
        if(nacimientoRepositorio.existsById(id)){
            if(historiaServicios.existHistoria(nacimientoDTO.getHistoria().getId())) {
                if (medicoServicios.existMedico(nacimientoDTO.getMedico().getId())) {;
                    NacimientoEntidad nacimientoEntidad = modelMapper.map(nacimientoDTO, NacimientoEntidad.class);
                    nacimientoRepositorio.save(nacimientoEntidad);
                    return true;
                }else {
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public NacimientoDTO getNacimientoByHistoria(Long id) {
        if(historiaServicios.existHistoria(id)){
            NacimientoEntidad nacimientoEntidad = nacimientoRepositorio.findByHistoria_Id(id);
            if(nacimientoEntidad == null){
                return null;
            }else{
                return modelMapper.map(nacimientoRepositorio.findByHistoria_Id(id),NacimientoDTO.class);
            }
        }else{
            return null;
        }
    }

    @Override
    public boolean existeNacimiento(Long id) {
        if(nacimientoRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }
}
