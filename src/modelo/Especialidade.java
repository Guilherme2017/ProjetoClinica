package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="especialidade")
public class Especialidade implements Serializable {
    
  @Id
  @SequenceGenerator(name="seq_especialidade", sequenceName="seq_especialidade_id", allocationSize=1)
  @GeneratedValue(generator="seq_especialidade", strategy= GenerationType.SEQUENCE)        
    private Integer id;
  @Column(name="descricao", nullable=false, length=50)
  @NotNull(message="A descricao nao pode ser nula")
  @NotBlank(message="A descricao  nao pode ser em branco")
  @Length(max=50, message="A descricao nao pode ter mais de {max} caracteres")
    private String descricao;
    
    public Especialidade(){
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Especialidade other = (Especialidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }   
}
