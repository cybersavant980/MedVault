package DSA.util;

import java.util.regex.Pattern;

public final class Validation {

    private Validation() {
    }

    // =====================================================
    // Name Validation
    // =====================================================

    public static boolean isValidName(String name) {

        return name != null
                && name.matches("[A-Za-z ]{2,50}");

    }

    // =====================================================
    // Age Validation
    // =====================================================

    public static boolean isValidAge(int age) {

        return age >= 0 && age <= 120;

    }

    // =====================================================
    // Phone Number Validation
    // =====================================================

    public static boolean isValidPhone(String phone) {

        return phone != null
                && phone.matches("\\d{10}");

    }

    // =====================================================
    // Email Validation
    // =====================================================

    public static boolean isValidEmail(String email) {

        if (email == null)
            return false;

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);

    }

    // =====================================================
    // Blood Group Validation
    // =====================================================

    public static boolean isValidBloodGroup(String bloodGroup) {

        if (bloodGroup == null)
            return false;

        return bloodGroup.matches(
                "^(A|B|AB|O)[+-]$"
        );

    }

    // =====================================================
    // Empty String Validation
    // =====================================================

    public static boolean isEmpty(String value) {

        return value == null || value.trim().isEmpty();

    }

    // =====================================================
    // Positive Number Validation
    // =====================================================

    public static boolean isPositive(int number) {

        return number >= 0;

    }

}