package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.CirugiaDTO;
import co.edu.utp.isc.gia.historia.entidades.CirugiaEntidad;
import co.edu.utp.isc.gia.historia.repositorio.CirugiaRepositorio;
import co.edu.utp.isc.gia.historia.servicios.CirugiaServicios;
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
public class CirugiaServiciosImpl implements CirugiaServicios {
    @Autowired
    private CirugiaRepositorio cirugiaRepositorio;

    @Autowired
    private HistoriaServicios historiaServicios;

    @Autowired
    private MedicoServicios medicoServicios;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CirugiaDTO saveCirugia(CirugiaDTO cirugiaDTO) {
        if(historiaServicios.existHistoria(cirugiaDTO.getHistoria().getId())){
            if(medicoServicios.existMedico(cirugiaDTO.getMedico().getId())){

                CirugiaEntidad cirugiaEntidad = modelMapper.map(cirugiaDTO, CirugiaEntidad.class);

                return modelMapper.map(cirugiaRepositorio.save(cirugiaEntidad),CirugiaDTO.class);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public CirugiaDTO getCirugia(Long id) {
        if(cirugiaRepositorio.existsById(id)){
            return modelMapper.map(cirugiaRepositorio.findById(id).get(),CirugiaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<CirugiaDTO> getAllCirugias() {
        List<CirugiaDTO> cirugiaDTOS = new ArrayList<>();
        cirugiaRepositorio.findAll().forEach(cirugiaEntidad -> cirugiaDTOS.add(
                modelMapper.map(cirugiaEntidad,CirugiaDTO.class)
        ));
        return cirugiaDTOS;
    }

    @Override
    public boolean deleteCirugia(Long id) {
        if(cirugiaRepositorio.existsById(id)){
            cirugiaRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putCirugia(Long id, CirugiaDTO cirugiaDTO) {
        if(cirugiaRepositorio.existsById(id)){
            if(historiaServicios.existHistoria(cirugiaDTO.getHistoria().getId())){
                if(medicoServicios.existMedico(cirugiaDTO.getMedico().getId())){

                    CirugiaEntidad cirugiaEntidad = modelMapper.map(cirugiaDTO, CirugiaEntidad.class);
                    cirugiaRepositorio.save(cirugiaEntidad);
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
    public List<CirugiaDTO> getCirugiasByHistoria(Long id) {
        if(historiaServicios.existHistoria(id)){
            List<CirugiaDTO> cirugiaDTOS = new ArrayList<>();
            cirugiaRepositorio.findByHistoria_Id(id).forEach(cirugiaEntidad -> cirugiaDTOS.add(
                    modelMapper.map(cirugiaEntidad, CirugiaDTO.class)
            ));
            return cirugiaDTOS;
        }
        return null;
    }

    @Override
    public boolean existeCirugia(Long id) {
        if(cirugiaRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }
}
