package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.HistoriaDTO;
import co.edu.utp.isc.gia.historia.entidades.HistoriaEntidad;
import co.edu.utp.isc.gia.historia.repositorio.HistoriaRepositorio;
import co.edu.utp.isc.gia.historia.servicios.HistoriaServicios;
import co.edu.utp.isc.gia.historia.servicios.PacienteServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor

@Service
public class HistoriaServiciosImpl implements HistoriaServicios {

    @Autowired
    private HistoriaRepositorio historiaRepositorio;

    @Autowired
    private PacienteServicios pacienteServicios;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HistoriaDTO saveHistoria(HistoriaDTO historiaDTO) {
        /** revisar la exepcion para el caso en de Paciente_ID unique*/
        if(pacienteServicios.existPaciente(historiaDTO.getPaciente().getId())) {
            HistoriaEntidad historiaEntidad = modelMapper.map(historiaDTO, HistoriaEntidad.class);
            return modelMapper.map(historiaRepositorio.save(historiaEntidad), HistoriaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public HistoriaDTO getHistoriaByPaciente(Long user_id) {
        if(pacienteServicios.existPaciente(user_id)){
            return modelMapper.map(historiaRepositorio.findByPaciente_Id(user_id), HistoriaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public HistoriaDTO getHistoria(Long id){
        if(historiaRepositorio.existsById(id)){
            return modelMapper.map(historiaRepositorio.findById(id).get(),HistoriaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public List<HistoriaDTO> getAllHistorias() {
        List<HistoriaDTO> historiaDTOS = new ArrayList<>();
        historiaRepositorio.findAll().forEach(historiaEntidad -> historiaDTOS.add(
                modelMapper.map(historiaEntidad, HistoriaDTO.class))
        );
        return historiaDTOS;
    }

    @Override
    public boolean deleteHistoria(Long id) {
        if(historiaRepositorio.existsById(id)){
            historiaRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean putHistoria(Long id, HistoriaDTO historiaDTO) {
        if(historiaRepositorio.existsById(id)){
            HistoriaEntidad historiaEntidad = modelMapper.map(historiaDTO, HistoriaEntidad.class);
            historiaRepositorio.save(historiaEntidad);
            return true;
        }
        return false;
    }

    //More service
    @Override
    public boolean existHistoria(Long id) {
        return historiaRepositorio.existsById(id);
    }

    @Override
    public HistoriaEntidad getHistoriaEntidad(Long id) {
        if(historiaRepositorio.existsById(id)){
            return historiaRepositorio.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public boolean getHaveHistory(Long id) {
        return historiaRepositorio.existsByPaciente_Id(id);
    }

}
