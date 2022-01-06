package co.edu.utp.isc.gia.historia.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "PACIENTE")
public class PacienteEntidad extends PersonaEntidad implements Serializable {
    /**
     * Esta clase hereda de la clase PersonaEntidad y define unos atributos que definen a un paciente
     * para la historia clinica, esta clase guarda correspondencia con la tabla pacientes de la base
     * de datos.
     * @autor Anderson Gomez Gomez
     *
     * @param estadoCivil es el estado civil de la persona los estados civiles aceptados,
     *                    por el estado colombiano son:
     *                      Soltero/a
     *                      Casado/a
     *                      Unión libre o unión de hecho
     *                      Separado/a
     *                      Divorciado/a
     *                      Viudo/a.
     *                      - Not null.
     *                      - Obligatorio.
     *                      - Default: soltero
     *                      - Max length: 15
     * @param estrato es el estrato socio-economico del paciente en colombia este estrato va desde el 1 hasta el 6
     *                , es obligatorio.
     *                      - Not Null.
     *                      - Obligatorio.
     * @param ocupacion es la actividad a la que se dedica la persona, puede ser laboral o academica.
     *                      - Not null.
     *                      - Max length: 30
     * @param etnia tipo de comunida a la que pertenece el paciente para colombia son:
     *                      Indigenas.
     *                      Negros, Palenquero, Raizales.
     *                      Gitanos.
     *                      - Not null.
     *                      - Defaul: N/A (no aplica)
     *                      - Max length: 15
     * @param discapacidad tipo de discapacidad que posea la persona.
     *                      - Not null.
     *                      - Default: N/A (no aplica).
     *                      - Max length: 20
     * @param direccion es la direccion de residencia de la persona.
     *                      - Not null.
     *                      - Max length: 50
     * @param religion religion que profesa o se identifica, obligatorio.
     *                      - Not null.
     *                      - Default: N/A
     *                      - Max length: 15
     * */

    @Column(nullable = false, length = 15)
    private String  estadoCivil;

    @Column(nullable = false)
    private Integer estrato;

    @Column(nullable = false, length = 30)
    private String  ocupacion;

    @Column(nullable = false, length = 20)
    private String  etnia;

    @Column(nullable = false, length = 20)
    private String  discapacidad;

    @Column(nullable = false, length = 20)
    private String  direccion;

    @Column(nullable = false, length = 20)
    private String  religion;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private HistoriaEntidad historia;

}
