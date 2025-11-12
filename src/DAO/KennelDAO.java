package DAO;

import JPAUtil.JPAUtil;
import jakarta.persistence.EntityManager;
import model.Kennel;
import model.KennelType;

import java.util.*;

public class KennelDAO {
    public void addKennel(Kennel kennel) {
        Objects.requireNonNull(kennel);
        EntityManager em = JPAUtil.em();
        try {
            em.getTransaction().begin();
            em.persist(kennel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Optional<Kennel> getKennel(Integer id) {
        EntityManager em = JPAUtil.em();
        try {
            Kennel k = em.find(Kennel.class, id);
            return Optional.ofNullable(k);
        } finally {
            em.close();
        }
    }

    public List<Kennel> getAllKennel() {
        EntityManager em = JPAUtil.em();
        try {
            return em.createNativeQuery("SELECT * FROM kennels ORDER BY id", Kennel.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Optional<Kennel> findKennelWithSpaceByType(KennelType type) {
        EntityManager em = JPAUtil.em();
        try {
            List<Kennel> result = em.createNativeQuery(
                            "SELECT * " +
                                    "FROM kennels k " +
                                    "WHERE k.type = ?1 " +
                                    "  AND k.capacity > (SELECT COUNT(*) FROM pets p WHERE p.kennel_id = k.id) " +
                                    "ORDER BY k.id " +
                                    "LIMIT 1",
                            Kennel.class)
                    .setParameter("1", type.name())
                    .getResultList();

            return result.stream().findFirst();
        } finally {
            em.close();
        }
    }

    public long countByKennelType(KennelType type) {
        EntityManager em = JPAUtil.em();
        try {
            Number n = (Number) em.createNativeQuery(
                            "SELECT COUNT(*) FROM kennels WHERE type = ?")
                    .setParameter("1", type.name())
                    .getSingleResult();
            return n.longValue();
        } finally {
            em.close();
        }
    }
}
