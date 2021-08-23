package backend.repository;

import backend.model.Location;
import backend.model.WeatherDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class WeatherDateRepository {
    private final EntityManager entityManager;

    public WeatherDateRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }
    public WeatherDate save(WeatherDate weatherDate) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(weatherDate);
            transaction.commit();
            return weatherDate;
        } catch (Exception e) {
            System.err.println("Weather date save failed.");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
}
