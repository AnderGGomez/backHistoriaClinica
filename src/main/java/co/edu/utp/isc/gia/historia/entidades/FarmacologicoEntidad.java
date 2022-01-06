package co.edu.utp.isc.gia.historia.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "ANT_FARMACOLOGICO")
public class FarmacologicoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(nullable = false)
    private String  prescripcion;

    @Column(nullable = false)
    private Integer  duracion;

    @Temporal(TemporalType.DATE)
    private Date    fecha;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historia_id", nullable = false)
    private HistoriaEntidad historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoEntidad medico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "FARMACO_MEDICAMENTO",
            joinColumns = @JoinColumn(name = "farmaco_id", nullable = false, referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id", nullable = false, referencedColumnName = "ID")
    )
    List<MedicamentoEntidad> medicamentos;
}
