package backend.repository;

import backend.model.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationRepository {
    private final EntityManager entityManager;

    public LocationRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }
    public Location save(Location loc) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(loc);
            transaction.commit();
            return loc;
        } catch (Exception e) {
            System.err.println("Location save failed.");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
}
