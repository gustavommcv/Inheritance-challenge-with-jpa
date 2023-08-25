package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("inheritanceWithJpa");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.em = emf.createEntityManager();
        this.classe = classe;
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> insert(E e) {
        em.persist(e);
        return this;
    }

    public E searchById(Object id) {
        return em.find(classe, id);
    }

    public void close() {
        em.close();
    }
}
