package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Consulta;
import modelo.Receituario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirReceituario {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirReceituario() {
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
          Receituario r= new Receituario();
          r.setPosologia("Tomar 2 vezes ao dia de 12 em 12 horas");
          r.setValidade(Calendar.getInstance());
          r.setConsulta(em.find(Consulta.class,1));
          em.getTransaction().begin();
          em.persist(r);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    } 
    
}
