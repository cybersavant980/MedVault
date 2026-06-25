package DSA.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // =====================================================
    // Save Object List
    // =====================================================

    public static <T> boolean saveData(List<T> data, String fileName) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            outputStream.writeObject(data);
            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
    }

    // =====================================================
    // Load Object List
    // =====================================================

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(file))) {

            return (List<T>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
            return new ArrayList<>();

        }
    }

    // =====================================================
    // Delete Data File
    // =====================================================

    public static boolean deleteFile(String fileName) {

        File file = new File(fileName);

        if (file.exists()) {
            return file.delete();
        }

        return false;
    }

    // =====================================================
    // Check File Exists
    // =====================================================

    public static boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }

}