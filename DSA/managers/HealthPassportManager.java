package DSA.managers;
import DSA.models.HealthPassport;
import DSA.storage.FileManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class HealthPassportManager {
    private static final String FILE_NAME = "data/healthpassports.dat";
    private HashMap<String, HealthPassport> passportMap;
    public HealthPassportManager() {
        passportMap = new HashMap<>();
        loadPassports();
    }

    public boolean addPassport(HealthPassport passport) {
        if (passport == null)
            return false;
        if (passportMap.containsKey(passport.getPassportId()))
            return false;
        passportMap.put(passport.getPassportId(), passport);
        savePassports();
        return true;
    }

    public boolean updatePassport(HealthPassport passport) {
        if (passport == null)
            return false;
        if (!passportMap.containsKey(passport.getPassportId()))
            return false;
        passportMap.put(passport.getPassportId(), passport);
        savePassports();
        return true;
    }

    public boolean deletePassport(String passportId) {
        if (!passportMap.containsKey(passportId))
            return false;
        passportMap.remove(passportId);
        savePassports();
        return true;
    }

    public HealthPassport getPassport(String passportId) {
        return passportMap.get(passportId);
    }

    public List<HealthPassport> getAllPassports() {
        return new ArrayList<>(passportMap.values());
    }

    public int getPassportCount() {
        return passportMap.size();
    }

    public void savePassports() {
        FileManager.saveData(
                getAllPassports(),
                FILE_NAME
        );
    }

    @SuppressWarnings("unchecked")
    public void loadPassports() {
        List<HealthPassport> passports =
                FileManager.loadData(FILE_NAME);
        passportMap.clear();
        for (HealthPassport passport : passports) {
            passportMap.put(
                    passport.getPassportId(),
                    passport
            );
        }
    }
}