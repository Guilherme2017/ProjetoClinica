package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Paciente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirPaciente {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPaciente() {    
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
          Paciente p= new Paciente();
          p.setNome("Guilherme de Oliveira");
          p.setNascimento(Calendar.getInstance());
          p.setTelefone("(54)99673-9513");
          p.setSexo("M");
          p.setHistorico("bem de saude");
          p.setPeso(65.0);
          p.setAltura(1.78);
          em.getTransaction().begin();
          em.persist(p);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    }   
    
}
