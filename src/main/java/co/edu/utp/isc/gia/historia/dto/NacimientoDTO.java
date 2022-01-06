package co.edu.utp.isc.gia.historia.dto;


import co.edu.utp.isc.gia.historia.entidades.MedicoEntidad;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NacimientoDTO implements Serializable {
    private Long id;
    private Date fechaNacimiento;
    private String tipoParto;
    private String tipoNacimiento;

    //FK
    private MedicoDTO medico;
    private HistoriaDTO historia;
    private List<EnfermedadDTO> enfermedades;
}
