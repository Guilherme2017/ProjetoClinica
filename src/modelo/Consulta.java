package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="consulta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta implements Serializable {
   
  @Id
  @SequenceGenerator(name="seq_consulta", sequenceName="seq_consulta_id", allocationSize=1)
  @GeneratedValue(generator="seq_consulta", strategy= GenerationType.SEQUENCE)        
    private Integer id;
  @NotNull(message="A data deve ser informada")
  @Temporal(TemporalType.DATE)
  @Column(name="data", nullable=false)
    private Calendar data;
  @NotNull(message="A data deve ser informada")
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="hora", nullable=false)
   private Calendar hora; 
  @Column(name="preconsulta", nullable=false, columnDefinition="text")
  @NotNull(message="A pre consulta nao pode ser nula")
  @NotBlank(message="A pre consulta nao pode ser em branco")
   private String preconsulta;
  @Column(name="posconsulta", nullable=false, columnDefinition="text")
  @NotNull(message="A pos consulta nao pode ser nula")
  @NotBlank(message="A pos consulta nao pode ser em branco")
   private String posconsulta;
  @NotNull(message="O medico nao pode ser nulo")
  @ManyToOne
  @JoinColumn(name="medico", referencedColumnName="id", nullable=false)
  @ForeignKey(name="fk_medico_id")
   private Medico medico;
  @NotNull(message="O paciente nao pode ser nulo")
  @ManyToOne
  @JoinColumn(name="paciente", referencedColumnName="id", nullable=false)
  @ForeignKey(name="fk_paciente_id")
   private Paciente paciente;
  @OrderBy(value = "nome")
  @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exame = new ArrayList<>();
  @OrderBy(value = "posologia")
  @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituario = new ArrayList<>();
  
    public Consulta(){
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }
    
    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }   
}
