package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Consulta;
import modelo.Exame;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirExame {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirExame() {
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
          Exame ex= new Exame();
          Consulta c= new Consulta();
          ex.setNome("Ultrassonografia");
          ex.setDescricao("Ultrassonografia do pulmão");
          ex.setConsulta(em.find(Consulta.class, 1));
          em.getTransaction().begin();
          em.persist(ex);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    }
    
}
