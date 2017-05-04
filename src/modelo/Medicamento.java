package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable {
 
  @Id
  @SequenceGenerator(name="seq_medicamento", sequenceName="seq_medicamento_id", allocationSize=1)
  @GeneratedValue(generator="seq_medicamento", strategy= GenerationType.SEQUENCE)        
   private Integer id;
  @NotNull(message="O nome nao pode ser nulo")
  @NotBlank(message="O nome nao pode ser em branco")
  @Length(max=50, message="O nome nao pode ter mais de {max} caracteres")
  @Column(name="nome", length= 50, nullable=false)
   private String nome;
  @ManyToMany
  @JoinTable(name="receitar", joinColumns= @JoinColumn(name="medicamento", referencedColumnName="id", 
          nullable=false),inverseJoinColumns= @JoinColumn(name="receituario", referencedColumnName="id", nullable=false))
   private List<Receituario> receitar= new ArrayList<>();
    
    public Medicamento(){
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
    
    public List<Receituario> getReceitar() {
        return receitar;
    }

    public void setReceitar(List<Receituario> receitar) {
        this.receitar = receitar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
