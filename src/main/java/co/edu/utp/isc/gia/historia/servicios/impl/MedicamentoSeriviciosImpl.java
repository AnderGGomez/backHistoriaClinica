package co.edu.utp.isc.gia.historia.servicios.impl;

import co.edu.utp.isc.gia.historia.dto.MedicamentoDTO;
import co.edu.utp.isc.gia.historia.entidades.MedicamentoEntidad;
import co.edu.utp.isc.gia.historia.repositorio.MedicamentoRepositorio;
import co.edu.utp.isc.gia.historia.servicios.MedicamentoServicios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MedicamentoSeriviciosImpl implements MedicamentoServicios {
    @Autowired
    private MedicamentoRepositorio medicamentoRepositorio;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public MedicamentoDTO saveMedicamento(MedicamentoDTO medicamentoDTO) {
        MedicamentoEntidad medicamentoEntidad=medicamentoRepositorio.save(modelMapper.map(medicamentoDTO, MedicamentoEntidad.class));
        return modelMapper.map(medicamentoEntidad, MedicamentoDTO.class);
    }

    @Override
    public MedicamentoDTO getMedicamento(Long id) {
        if(medicamentoRepositorio.existsById(id)){
            MedicamentoEntidad medicamentoEntidad = medicamentoRepositorio.findById(id).get();
            return modelMapper.map(medicamentoEntidad, MedicamentoDTO.class);
        }
        return null;
    }

    @Override
    public List<MedicamentoDTO> getAllMedicamento() {
        List<MedicamentoDTO> medicamentoDTOS = new ArrayList<>();
        medicamentoRepositorio.findAll().forEach(medicamentoEntidad -> medicamentoDTOS.add(
                modelMapper.map(medicamentoEntidad, MedicamentoDTO.class)
        ));
        return medicamentoDTOS;
    }

    @Override
    public boolean deleteMedicamento(Long id) {
        if(medicamentoRepositorio.existsById(id)){
            medicamentoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean putMedicamento(Long id, MedicamentoDTO medicamentoDTO) {
        if(medicamentoRepositorio.existsById(id)){
            medicamentoRepositorio.save(modelMapper.map(medicamentoDTO, MedicamentoEntidad.class));
            return true;
        }
        return false;
    }
}
