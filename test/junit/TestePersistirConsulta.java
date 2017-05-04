package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirConsulta {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirConsulta() {
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
          Consulta c= new Consulta();
          Medico m= new Medico();
          Paciente p= new Paciente();
          c.setData(Calendar.getInstance());
          c.setHora(Calendar.getInstance());
          c.setPreconsulta("Razoalmente");
          c.setPosconsulta("Tomar medicamentos");
          c.setMedico(em.find(Medico.class, 1));
          c.setPaciente(em.find(Paciente.class,1));
          em.getTransaction().begin();
          em.persist(c);
          em.getTransaction().commit();
          
      }catch(Exception e){
          resultado= false;
          e.printStackTrace();
      }
      
      Assert.assertEquals(false,resultado);
    }
    
}
