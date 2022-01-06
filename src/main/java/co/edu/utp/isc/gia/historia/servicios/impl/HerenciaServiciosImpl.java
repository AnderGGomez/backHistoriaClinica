package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.HerenciaDTO;
import co.edu.utp.isc.gia.historia.entidades.HerenciaEntidad;
import co.edu.utp.isc.gia.historia.entidades.HistoriaEntidad;
import co.edu.utp.isc.gia.historia.repositorio.HerenciaRepositorio;
import co.edu.utp.isc.gia.historia.servicios.EnfermedadServicios;
import co.edu.utp.isc.gia.historia.servicios.HerenciaServicios;
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
public class HerenciaServiciosImpl implements HerenciaServicios {

    @Autowired
    private HerenciaRepositorio herenciaRepositorio;

    @Autowired
    private HistoriaServicios historiaServicio;

    @Autowired
    private MedicoServicios medicoServicios;

    @Autowired
    private EnfermedadServicios enfermedadServicios;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HerenciaDTO saveHerencia(HerenciaDTO herenciaDTO) {
        if(historiaServicio.existHistoria(herenciaDTO.getHistoria().getId())){
            if(medicoServicios.existMedico(herenciaDTO.getMedico().getId())){
                HerenciaEntidad herenciaEntidad = modelMapper.map(herenciaDTO, HerenciaEntidad.class);
                return modelMapper.map(herenciaRepositorio.save(herenciaEntidad), HerenciaDTO.class);
            }else{
                return null;
            }
        }else
        {
            return null;
        }
    }

    @Override
    public HerenciaDTO getHerencia(Long id){
        if(herenciaRepositorio.existsById(id)){
            HerenciaEntidad herenciaEntidad = herenciaRepositorio.findById(id).get();
            return modelMapper.map(herenciaEntidad,HerenciaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<HerenciaDTO> getHerenciaByHistoria(Long id /* id historia*/) {
        if(historiaServicio.existHistoria(id)){
            List<HerenciaDTO> herenciaDTOS = new ArrayList<>();
            herenciaRepositorio.findByHistoria_Id(id).forEach(herenciaEntidad -> herenciaDTOS.add(
                    modelMapper.map(herenciaEntidad, HerenciaDTO.class)
            ));
            return herenciaDTOS;
        }else{
            return null;
        }
    }

    @Override
    public List<HerenciaDTO> getAllHerencia() {
        List<HerenciaDTO> herenciaDTOS = new ArrayList<>();
        herenciaRepositorio.findAll().forEach(herenciaEntidad -> herenciaDTOS.add(
                modelMapper.map(herenciaEntidad, HerenciaDTO.class)
                )
        );
        return herenciaDTOS;
    }

    @Override
    public boolean deleteHerencia(Long id) {
        if(herenciaRepositorio.existsById(id)){
            herenciaRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putHerencia(Long id, HerenciaDTO herenciaDTO) {
        if(herenciaRepositorio.existsById(id)){
            if(historiaServicio.existHistoria(herenciaDTO.getHistoria().getId())) {
                if (medicoServicios.existMedico(herenciaDTO.getMedico().getId())) {
                    HerenciaEntidad herenciaEntidad = modelMapper.map(herenciaDTO, HerenciaEntidad.class);
                    herenciaRepositorio.save(herenciaEntidad);
                    return true;
                }else{
                    return false;
                }
            }else {
                return false;
            }


        }else{
            return false;
        }
    }

    @Override
    public boolean existeHerencia(long id) {
        if(herenciaRepositorio.existsById(id)){
            return true;
        }else{
            return false;
        }
    }
}
