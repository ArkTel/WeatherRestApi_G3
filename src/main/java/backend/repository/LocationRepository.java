package backend.repository;

import backend.model.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> allLocation() {
        String sql = "SELECT name FROM Location";
        return entityManager.createQuery(sql, String.class)
                .getResultList();
    }
    public String findKeyByName(String name) {
        return entityManager.createQuery("SELECT key FROM Location WHERE name = :name", String.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    public boolean isContainLocationList(String name){
        List<String> locationList = allLocation();
        return allLocation().contains(name);
    }

    public Location getLocationByName(String name){
        return entityManager.createQuery("FROM Location WHERE name = :name", Location.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
