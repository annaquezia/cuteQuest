package DAO;

import java.util.*;

import JPAUtil.JPAUtil;
import jakarta.persistence.EntityManager;
import model.Pet;

public class PetDAO {

    public Pet addPet(Pet pet) {
        EntityManager em = JPAUtil.em();
        try {
            em.getTransaction().begin();
            em.persist(pet);
            em.getTransaction().commit();
            return pet;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public boolean removePet(int id) {
        EntityManager em = JPAUtil.em();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE FROM pets WHERE id = ?1")
                    .setParameter("1", id)
                    .executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }  finally {
            em.close();
        }
    }

    public Optional<Pet> getAllPet(Integer id) {
        EntityManager em = JPAUtil.em();
        try {
            Pet found = (Pet) em.createNativeQuery("SELECT * FROM pets WHERE id = ?1", Pet.class)
                                 .setParameter("1", id)
                                 .getResultStream()
                                 .findFirst()
                                 .orElse(null);
            return Optional.ofNullable(found);
        } finally {
            em.close();
        }
    }

    public List<Pet> getKennelPets(Integer id) {
        EntityManager em = JPAUtil.em();
        try {
            return em.createNativeQuery(
                            "SELECT * FROM pets WHERE kennel_id = ?1 ORDER BY id",
                            Pet.class)
                    .setParameter("1", id)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pet> getAllPets() {
        EntityManager em = JPAUtil.em();
        try {
            return em.createNativeQuery("SELECT * FROM pets ORDER BY id", Pet.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
