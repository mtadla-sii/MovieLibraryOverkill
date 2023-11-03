package main;

import config.AppConfig;
import dataloader.JsonDataLoader;
import dataloader.MovieLibraryLoader;
import dataloader.XmlDataLoader;
import io.DataFormat;
import io.InputHandler;
import model.MovieLibrary;
import config.AvailableLocale;
import service.MenuOption;
import service.MovieService;
import io.LocalizedMessages;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    private static final AppConfig appConfig = AppConfig.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputHandler inputHandler = new InputHandler(scanner);

    public static void main(String[] args) {
        setApplicationLocale();
        MovieLibraryLoader movieLibraryLoader = selectDataLoader();
        MovieLibrary movieLibrary = loadData(movieLibraryLoader);
        MovieService movieService = new MovieService(movieLibrary);
        mainMenuLoop(movieService);
    }
    private static void setApplicationLocale() {
        AvailableLocale selectedLocale = inputHandler.getLocaleChoice();
        LocalizedMessages.setLocale(selectedLocale.getLocale());
    }
    private static MovieLibraryLoader selectDataLoader() {
        DataFormat formatChoice = inputHandler.getDataFormatChoice();

        return switch (formatChoice) {
            case JSON -> new JsonDataLoader(appConfig.getJsonPath());
            case XML -> new XmlDataLoader(appConfig.getXmlPath());
        };
    }

    private static MovieLibrary loadData(MovieLibraryLoader movieLibraryLoader) {
        try {
            return movieLibraryLoader.loadMovieLibrary();
        } catch (IOException e) {
            System.out.println("Error while loading data: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    private static void mainMenuLoop(MovieService movieService) {
        while (true) {
            MenuOption.displayOptions();
            int choice = inputHandler.promptForInt(LocalizedMessages.SELECT_OPTION);

            if (choice < 1 || choice > MenuOption.values().length) {
                System.out.println(LocalizedMessages.INVALID_MENU_CHOICE);
                continue;
            }

            MenuOption.getOptionByChoice(choice).execute(movieService, inputHandler);
        }
    }
}
