package io;

public class LocalizedMessagesOld {
    public static final String PROMPT_DATES = "Enter two dates to display movie titles released between these dates.";
    public static final String DISPLAY_RANDOM_MOVIE = "Display all information about a random movie.";
    public static final String PROMPT_ACTOR_FIRST_NAME = "Enter actor's first name: ";
    public static final String PROMPT_ACTOR_LAST_NAME = "Enter actor's last name: ";
    public static final String EXIT_PROGRAM = "Exit the program.";
    public static final String SELECT_START_YEAR = "Enter the starting year: ";
    public static final String SELECT_END_YEAR = "Enter the ending year: ";
    public static final String INVALID_YEAR_ORDER = "The starting year must be less than or equal to the ending year. Please try again.";
    public static final String ENTER_VALID_INT = "Enter a valid value (integer):";
    public static final String ENTER_VALID_STRING = "Enter a valid string:";
    public static final String SELECT_DATA_FORMAT = "Choose the data loading format:\n1. JSON\n2. XML\n";
    public static final String INVALID_MENU_CHOICE  = "Invalid choice. Please try again.";
    public static final String SELECT_OPTION = "Select an option: ";
    private static final String INVALID_CHOICE_TEMPLATE = "Invalid choice: %d";
    private static final String NO_MOVIES_FOUND_IN_RANGE_TEMPLATE = "No movies found in the range of years %d - %d.";
    private static final String MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE = "No movies found with actor %s %s.";

    public static String noMoviesFoundInRange(int start, int end) {
        return String.format(NO_MOVIES_FOUND_IN_RANGE_TEMPLATE, start, end);
    }

    public static String invalidChoice(int choice) {
        return String.format(INVALID_CHOICE_TEMPLATE, choice);
    }

    public static String moviesByActorNotFound(String firstName, String lastName) {
        return String.format(MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE, firstName, lastName);
    }
}
