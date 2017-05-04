package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Especialidade;
import modelo.Medico;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirMedico {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedico() {
    }
    
    @Before
    public void setUp() {
        emf= Persistence.createEntityManagerFactory("Projeto_ClinicaPU");
        em= emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
      boolean resultado= false;
      try{
          Medico m= new Medico();
          Especialidade es= new Especialidade();
          m.setCrm("Cardiologista");
          m.setNome("Jose");
          m.setNascimento(Calendar.getInstance());
          m.setTelefone("(54)99665-6700");
          m.setSexo("M");
          m.setHistorico("Paciente em recuperacao");
          m.setPeso(70.8);
          m.setAltura(1.76);
          m.setEspecialidade(em.find(Especialidade.class, 1));
          em.getTransaction().begin();
          em.persist(m);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    } 
    
}
