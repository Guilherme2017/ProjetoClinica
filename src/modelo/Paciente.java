package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="paciente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente implements Serializable {
 
  @Id
  @SequenceGenerator(name="seq_paciente", sequenceName="seq_paciente_id", allocationSize=1)
  @GeneratedValue(generator="seq_paciente", strategy= GenerationType.SEQUENCE)  
   private Integer id;
  @Column(name="nome", nullable=false, length=50)
  @NotNull(message="O nome nao pode ser nulo")
  @NotBlank(message="O nome  nao pode ser em branco")
  @Length(max=50, message="O nome nao pode ter mais de {max} caracteres")
   private String nome;
  @Temporal(TemporalType.DATE)
  @Column(name="nascimento", nullable=false)
   private Calendar nascimento;
  @Column(name="telefone", nullable=false, length=20)
  @NotNull(message="O telefone nao pode ser nulo")
  @NotBlank(message="O telefone nao pode ser em branco")
  @Length(max=20, message="O telefone nao pode ter mais de {max} caracteres")
   private String telefone;
  @Column(name="sexo", nullable=false, length=1)
  @NotNull(message="O sexo nao pode ser nulo")
  @NotBlank(message="O sexo nao pode ser em branco")
  @Length(max=1, message="O sexo nao pode ter mais de {max} caracteres")
   private String sexo;
  @Column(name="historico", nullable=false, columnDefinition="text")
  @NotNull(message="O historico nao pode ser nulo")
  @NotBlank(message="O historico nao pode ser em branco")
   private String historico;
  @NotNull(message = "O peso deve ser informado")
  @Column(name ="peso", nullable = false)
   private Double peso;
  @NotNull(message = "A altura deve ser informada")
  @Column(name ="altura", nullable = false)
   private Double altura;

    public Paciente(){
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }   
}
