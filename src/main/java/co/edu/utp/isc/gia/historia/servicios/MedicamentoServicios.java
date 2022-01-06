package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.MedicamentoDTO;

import java.util.List;

public interface MedicamentoServicios {
    MedicamentoDTO saveMedicamento (MedicamentoDTO medicamentoDTO);

    MedicamentoDTO getMedicamento (Long id);

    List<MedicamentoDTO> getAllMedicamento();

    boolean deleteMedicamento(Long id);

    boolean putMedicamento(Long id, MedicamentoDTO medicamentoDTO);
}
