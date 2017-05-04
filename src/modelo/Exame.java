package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="exame")
public class Exame implements Serializable {
  
  @Id
  @SequenceGenerator(name = "seq_exame", sequenceName = "seq_exame_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
   private Integer id;
  @Column(name="nome", nullable=false, length=50)
  @NotNull(message="O nome nao pode ser nulo")
  @NotBlank(message="O nome  nao pode ser em branco")
  @Length(max=50, message="O nome nao pode ter mais de {max} caracteres")  
   private String nome;
  @Column(name="descricao", nullable=false, length=50)
  @NotNull(message="A descricao nao pode ser nula")
  @NotBlank(message="A descricao  nao pode ser em branco")
  @Length(max=50, message="A descricao nao pode ter mais de {max} caracteres")
   private String descricao;
  @NotNull(message="A consultta nao pode ser nula")
  @ManyToOne
  @JoinColumn(name="consulta", referencedColumnName="id", nullable=false)
  @ForeignKey(name="fk_consulta_id")
   private Consulta consulta;
   
    public Exame(){
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Exame other = (Exame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 
}
