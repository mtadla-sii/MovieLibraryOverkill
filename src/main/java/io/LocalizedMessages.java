package io;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedMessages {

    // Statyczne pola przechowujące aktualne zlokalizowane komunikaty
    public static String PROMPT_DATES;
    public static String DISPLAY_RANDOM_MOVIE;
    public static String PROMPT_ACTOR_FIRST_NAME;
    public static String PROMPT_ACTOR_LAST_NAME;
    public static String EXIT_PROGRAM;
    public static String SELECT_START_YEAR;
    public static String SELECT_END_YEAR;
    public static String INVALID_YEAR_ORDER;
    public static String ENTER_VALID_INT;
    public static String ENTER_VALID_STRING;
    public static String SELECT_DATA_FORMAT;
    public static String INVALID_MENU_CHOICE;
    public static String SELECT_OPTION;
    public static String CHOOSE_YOUR_LANGUAGE;
    public static String INVALID_LOCALE_CHOICE;
    public static String YOUR_CHOICE;


    static {
        reload();
    }

    public static void reload() {
        PROMPT_DATES = Messages.get(Messages.KEY_PROMPT_DATES);
        DISPLAY_RANDOM_MOVIE = Messages.get(Messages.KEY_DISPLAY_RANDOM_MOVIE);
        PROMPT_ACTOR_FIRST_NAME = Messages.get(Messages.KEY_PROMPT_ACTOR_FIRST_NAME);
        PROMPT_ACTOR_LAST_NAME = Messages.get(Messages.KEY_PROMPT_ACTOR_LAST_NAME);
        EXIT_PROGRAM = Messages.get(Messages.KEY_EXIT_PROGRAM);
        SELECT_START_YEAR = Messages.get(Messages.KEY_SELECT_START_YEAR);
        SELECT_END_YEAR = Messages.get(Messages.KEY_SELECT_END_YEAR);
        INVALID_YEAR_ORDER = Messages.get(Messages.KEY_INVALID_YEAR_ORDER);
        ENTER_VALID_INT = Messages.get(Messages.KEY_ENTER_VALID_INT);
        ENTER_VALID_STRING = Messages.get(Messages.KEY_ENTER_VALID_STRING);
        SELECT_DATA_FORMAT = Messages.get(Messages.KEY_SELECT_DATA_FORMAT);
        INVALID_MENU_CHOICE = Messages.get(Messages.KEY_INVALID_MENU_CHOICE);
        SELECT_OPTION = Messages.get(Messages.KEY_SELECT_OPTION);
        CHOOSE_YOUR_LANGUAGE = Messages.get(Messages.KEY_CHOOSE_YOUR_LANGUAGE);
        INVALID_LOCALE_CHOICE = Messages.get(Messages.KEY_INVALID_LOCALE_CHOICE);
        YOUR_CHOICE = Messages.get(Messages.KEY_YOUR_CHOICE);
    }

    public static String noMoviesFoundInRange(int start, int end) {
        return String.format(Messages.get(Messages.KEY_NO_MOVIES_FOUND_IN_RANGE_TEMPLATE), start, end);
    }

    public static String invalidChoice(int choice) {
        return String.format(Messages.get(Messages.KEY_INVALID_CHOICE_TEMPLATE), choice);
    }

    public static String moviesByActorNotFound(String firstName, String lastName) {
        return String.format(Messages.get(Messages.KEY_MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE), firstName, lastName);
    }

    public static void setLocale(Locale locale) {
        Messages.setLocale(locale);
        reload();
    }

    private static class Messages {
        private static final String BASE_NAME = "messages";
        private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);
        private static final String KEY_PROMPT_DATES = "PROMPT_DATES";
        private static final String KEY_DISPLAY_RANDOM_MOVIE = "DISPLAY_RANDOM_MOVIE";
        private static final String KEY_PROMPT_ACTOR_FIRST_NAME = "PROMPT_ACTOR_FIRST_NAME";
        private static final String KEY_PROMPT_ACTOR_LAST_NAME = "PROMPT_ACTOR_LAST_NAME";
        private static final String KEY_EXIT_PROGRAM = "EXIT_PROGRAM";
        private static final String KEY_SELECT_START_YEAR = "SELECT_START_YEAR";
        private static final String KEY_SELECT_END_YEAR = "SELECT_END_YEAR";
        private static final String KEY_INVALID_YEAR_ORDER = "INVALID_YEAR_ORDER";
        private static final String KEY_ENTER_VALID_INT = "ENTER_VALID_INT";
        private static final String KEY_ENTER_VALID_STRING = "ENTER_VALID_STRING";
        private static final String KEY_SELECT_DATA_FORMAT = "SELECT_DATA_FORMAT";
        private static final String KEY_INVALID_MENU_CHOICE = "INVALID_MENU_CHOICE";
        private static final String KEY_SELECT_OPTION = "SELECT_OPTION";

        private static final String KEY_INVALID_CHOICE_TEMPLATE = "INVALID_CHOICE_TEMPLATE";
        private static final String KEY_NO_MOVIES_FOUND_IN_RANGE_TEMPLATE = "NO_MOVIES_FOUND_IN_RANGE_TEMPLATE";
        private static final String KEY_MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE = "MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE";
        private static final String KEY_CHOOSE_YOUR_LANGUAGE = "CHOOSE_YOUR_LANGUAGE";
        private static final String KEY_INVALID_LOCALE_CHOICE = "INVALID_LOCALE_CHOICE";
        private static final String KEY_YOUR_CHOICE = "YOUR_CHOICE";

        private static String get(String key) {
            return resourceBundle.getString(key);
        }

        private static void setLocale(Locale locale) {
            resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
        }
    }
}

