package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EnfermedadDTO implements Serializable {
    private Long id;
    private String nombre;
    private String tipo;
}
