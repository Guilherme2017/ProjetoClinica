package junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Medicamento;
import modelo.Receituario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirReceitar {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirReceitar() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Projeto_ClinicaPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste() {
        boolean resultado = false;
        try {
            Medicamento me = em.find(Medicamento.class, 1);
            Receituario r= em.find(Receituario.class,1);
            r.getReceitar().add(me);
            em.getTransaction().begin();
            em.persist(me);
            em.getTransaction().commit();

        } catch (Exception e) {
            resultado = false;
            e.printStackTrace();
        }

        Assert.assertEquals(false, resultado);
    }
    
}
