package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class FarmacologicoDTO implements Serializable {
    private Long    id;
    private String  prescripcion;
    private Integer duracion;
    private Date    fecha;

    //Fk
    private HistoriaDTO    historia;
    private MedicoDTO    medico;
    private List<MedicamentoDTO> medicamentos;
}
