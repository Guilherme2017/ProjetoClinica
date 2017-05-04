package junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Especialidade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirEspecialidade {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirEspecialidade() {
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
          Especialidade es= new Especialidade();
          es.setDescricao("pediatra");
          em.getTransaction().begin();
          em.persist(es);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    }   
}
