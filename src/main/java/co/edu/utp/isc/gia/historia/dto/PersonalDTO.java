package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalDTO implements Serializable {
    private Long id;
    private String descripcion;
    private String estado;
    private String fecha;

    //Foreing Key
    private HistoriaDTO historia;
    private MedicoDTO medico;
    private List<EnfermedadDTO> enfermedades;
}
