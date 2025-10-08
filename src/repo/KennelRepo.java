package repo;

import model.Kennel;
import model.KennelType;

import java.util.*;

public class KennelRepo {
    private final Map<UUID, Kennel> kennelMap = new LinkedHashMap<>();

    public void addKennel(Kennel kennel) {
        Objects.requireNonNull(kennel);
        kennelMap.put(kennel.getKennelID(), kennel);
    }

    public Optional<Kennel> getKennel(UUID id) {
        return Optional.ofNullable(kennelMap.get(id));
    }

    public List<Kennel> getAllKennel() {
        return new ArrayList<>(kennelMap.values());
    }

    public Optional<Kennel> findKennelWithSpaceByType(KennelType type) {
        for (Kennel k : kennelMap.values()) {
            if (k.getType() == type && k.getPetsIDs().size() < k.getCapacity()) {
                return Optional.of(k);
            }
        }
        return Optional.empty();
    }

    public long countByKennelType(KennelType type) {
        return kennelMap.values().stream().filter(k -> k.getType() == type).count();
    }
}
