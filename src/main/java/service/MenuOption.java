package service;

import io.InputHandler;
import io.LocalizedMessages;
import service.command.*;

import java.util.Arrays;

public enum MenuOption {
    SHOW_MOVIES_BETWEEN_DATES(1, LocalizedMessages.PROMPT_DATES, new ShowMoviesBetweenDatesCommand()),
    SHOW_RANDOM_MOVIE(2, LocalizedMessages.DISPLAY_RANDOM_MOVIE, new ShowRandomMovieCommand()),
    SHOW_MOVIES_BY_ACTOR(3, LocalizedMessages.PROMPT_ACTOR_FIRST_NAME + " & " + LocalizedMessages.PROMPT_ACTOR_LAST_NAME, new ShowMoviesByActorCommand()),
    EXIT_PROGRAM(4, LocalizedMessages.EXIT_PROGRAM, new ExitProgramCommand());

    private final int optionNumber;
    private final String description;
    private final MenuCommand command;

    MenuOption(int optionNumber, String description, MenuCommand command) {
        this.optionNumber = optionNumber;
        this.description = description;
        this.command = command;
    }

    public static void displayOptions() {
        System.out.println("==============");
        Arrays.stream(values()).map(option -> option.optionNumber + ". " + option.description).forEach(System.out::println);
    }

    public static MenuOption getOptionByChoice(int choice) {
        for (var option : values()) {
            if (option.optionNumber == choice) {
                return option;
            }
        }
        throw new IllegalArgumentException(LocalizedMessages.invalidChoice(choice));
    }
    public void execute(MovieService movieService, InputHandler inputHandler) {
        this.command.execute(movieService, inputHandler);
    }
}
