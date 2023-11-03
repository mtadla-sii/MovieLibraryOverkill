package config;

import java.util.Locale;

public enum AvailableLocale {
    ENGLISH("English", Locale.ENGLISH),
    POLISH("Polski", new Locale("pl", "PL"));

    private final String displayName;
    private final Locale locale;

    AvailableLocale(String displayName, Locale locale) {
        this.displayName = displayName;
        this.locale = locale;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Locale getLocale() {
        return locale;
    }

    public static AvailableLocale fromChoice(int choice) {
        for (AvailableLocale localeOption : values()) {
            if (localeOption.ordinal() + 1 == choice) {
                return localeOption;
            }
        }
        return null;
    }
}
