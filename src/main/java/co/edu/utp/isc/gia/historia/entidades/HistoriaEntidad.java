package co.edu.utp.isc.gia.historia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HISTORIA_CLINICA")
public class HistoriaEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15)
    private String eps;

    //Foreing Key
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private PacienteEntidad paciente;

    @OneToMany(mappedBy = "historia", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<HerenciaEntidad> herencia;

    @OneToMany(mappedBy = "historia", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<NacimientoEntidad> nacimiento;

    @OneToMany(mappedBy = "historia", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<FarmacologicoEntidad> farmacologico;

    @OneToMany(mappedBy = "historia", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CirugiaEntidad> cirugia;
}
