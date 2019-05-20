package com.richemont.dms.catalog;

/**
 * Three upper case alpha numeric letters starting with a letter.
 */
public class Trigram {
    private final String value;

    public Trigram(String value) {
        validate(value);
        this.value = value;
    }

    public static void validate(String value) throws IllegalArgumentException {
        if (value == null || value.length() != 3) {
            throw new IllegalArgumentException("Trigram must not be null and must contain exactly three characters");
        }
        if (!isAlpha(value.charAt(0))) {
            throw new IllegalArgumentException("First character must be uppercase A-Z");
        }
        if (!isAlphaNumeric(value.charAt(1)) || !isAlphaNumeric(value.charAt(2))) {
            throw new IllegalArgumentException("All characters must be upper case alpha numeric");
        }
    }

    public String getValue() {
        return value;
    }

    // Test if upper case letter
    private static boolean isAlpha(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isNumeric(c);
    }

    // -- Object

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trigram trigram = (Trigram) o;

        return value != null ? value.equals(trigram.value) : trigram.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value;
    }
}
