package co.edu.utp.isc.gia.historia.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PacienteDTO extends PersonaDTO implements Serializable {
    /**
     * Esta clase hereda de la clase PersonaDTO y define unos atributos que definen a un paciente
     * para la historia clinica.
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
     *                    es obligatorio.
     * @param estrato es el estrato socio-economico del paciente en colombia este estrato va desde el 1 hasta el 6
     *                , es obligatorio.
     * @param ocupacion es la actividad a la que se dedica la persona, puede ser laboral o academica, es obligatorio.
     * @param etnia tipo de comunida a la que pertenece el paciente para colombia son:
     *                      Indigenas.
     *                      Negros, Palenquero, Raizales.
     *                      Gitanos.
     *              es obligatorio.
     * @param discapacidad tipo de discapacidad que posea la persona, es obligatorio,
     *                     en caso de no tener especifique <<ninguna>>.
     * @param direccion es la direccion de residencia de la persona, obligatorio.
     * @param religion religion que profesa o se identifica, obligatorio, especifique <<ninguna>>
     *                 en caso de no profesar alguna.
     * */
    private String  estadoCivil;
    private Integer estrato;
    private String  ocupacion;
    private String  etnia;
    private String  discapacidad;
    private String  direccion;
    private String  religion;
}
