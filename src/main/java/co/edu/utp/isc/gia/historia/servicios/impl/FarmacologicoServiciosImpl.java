package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.*;
import co.edu.utp.isc.gia.historia.entidades.FarmacologicoEntidad;
import co.edu.utp.isc.gia.historia.repositorio.FarmacologicoRepositorio;
import co.edu.utp.isc.gia.historia.servicios.FarmacologicoServicios;
import co.edu.utp.isc.gia.historia.servicios.HistoriaServicios;
import co.edu.utp.isc.gia.historia.servicios.MedicoServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class FarmacologicoServiciosImpl implements FarmacologicoServicios {

    @Autowired
    private FarmacologicoRepositorio farmacologicoRepositorio;

    @Autowired
    private HistoriaServicios historiaServicios;

    @Autowired
    private MedicoServicios medicoServicios;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FarmacologicoDTO saveFarmacologico(FarmacologicoDTO farmacologicoDTO) {
        if(historiaServicios.existHistoria(farmacologicoDTO.getHistoria().getId())){
            if(medicoServicios.existMedico(farmacologicoDTO.getMedico().getId())){
                FarmacologicoEntidad farmacologicoEntidad = modelMapper.map(farmacologicoDTO, FarmacologicoEntidad.class);
                return modelMapper.map(farmacologicoRepositorio.save(farmacologicoEntidad), FarmacologicoDTO.class);
            }else {
                return null;
            }
        }else{
            return null;
        }

    }


    @Override
    public FarmacologicoDTO getFarmacologico(Long id) {
        if(farmacologicoRepositorio.existsById(id)){
            FarmacologicoEntidad farmacologicoEntidad = farmacologicoRepositorio.findById(id).get();
            return modelMapper.map(farmacologicoEntidad, FarmacologicoDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<FarmacologicoDTO> getAllFarmacologico() {
        List<FarmacologicoDTO> farmacologicoDTOS = new ArrayList<>();
        farmacologicoRepositorio.findAll().forEach(farmacologicoEntidad -> farmacologicoDTOS.add(
                modelMapper.map(farmacologicoEntidad, FarmacologicoDTO.class)
        ));
        return farmacologicoDTOS;
    }

    @Override
    public boolean deleteFarmacologico(Long id) {
        if(farmacologicoRepositorio.existsById(id)){
            farmacologicoRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putFarmacologico(Long id, FarmacologicoDTO farmacologicoDTO) {
        if(farmacologicoRepositorio.existsById(id)){
            if(historiaServicios.existHistoria(farmacologicoDTO.getHistoria().getId())){
                if(medicoServicios.existMedico(farmacologicoDTO.getMedico().getId())){
                    FarmacologicoEntidad farmacologicoEntidad = modelMapper.map(farmacologicoDTO, FarmacologicoEntidad.class);
                    farmacologicoRepositorio.save(farmacologicoEntidad);
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public List<FarmacologicoDTO> getFarmacoByHistoria(Long id) {
        if(historiaServicios.existHistoria(id)){
            List<FarmacologicoDTO> farmacologicoDTOS = new ArrayList<>();
            farmacologicoRepositorio.findByHistoria_Id(id).forEach(farmacologicoEntidad -> farmacologicoDTOS.add(
                    modelMapper.map(farmacologicoEntidad, FarmacologicoDTO.class)
            ));
            return farmacologicoDTOS;
        }else{
            return null;
        }
    }

    @Override
    public boolean existeFarmaco(Long id){
        if (farmacologicoRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }

}
