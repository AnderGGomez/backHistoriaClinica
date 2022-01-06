package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CirugiaDTO implements Serializable {
    private Long    id;
    private Date    fechaProcedimiento;
    private String  procedimiento;
    private String  descripcion;
    private Date    fechaCreacion;

    //FK
    private HistoriaDTO    historia;
    private MedicoDTO    medico;
}
