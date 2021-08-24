package backend.repository;

import backend.model.WeatherData;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class WeatherDataRepository {
    private final EntityManager entityManager;

    public WeatherDataRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }
    public WeatherData save(WeatherData weatherData) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(weatherData);
            transaction.commit();
            return weatherData;
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
