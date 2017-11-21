package si.fri.rso.katalog_dogodkov.bean;

import si.fri.rso.katalog_dogodkov.entity.Dogodek;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class DogodekBean {

    @PersistenceContext
    private EntityManager em;

    public List<Dogodek> getEvents() {
        Query q = em.createQuery("SELECT d FROM Dogodek d");

        return q.getResultList();
    }

    public Dogodek getEvent(int id) {
        return (Dogodek) em.find(Dogodek.class, id);
    }

    public void saveEvent(Dogodek dogodek) {
        if (dogodek != null) {
            em.getTransaction().begin();
            em.persist(dogodek);
            em.getTransaction().commit();
        }
    }

    public void updateEvent(Dogodek dogodek) {
        if (dogodek != null) {
            em.getTransaction().begin();
            em.merge(dogodek);
            em.flush();
            em.getTransaction().commit();
        }
    }

}
