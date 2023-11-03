package io;

import model.YearRange;
import config.AvailableLocale;
import validator.InputValidator;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }


    public AvailableLocale getLocaleChoice() {
        while (true) {
            System.out.println(LocalizedMessages.CHOOSE_YOUR_LANGUAGE);
            for (AvailableLocale localeOption : AvailableLocale.values()) {
                System.out.printf("%d. %s%n", localeOption.ordinal() + 1, localeOption.getDisplayName());
            }
            int choice = promptForInt(LocalizedMessages.YOUR_CHOICE);
            AvailableLocale selectedLocale = AvailableLocale.fromChoice(choice);
            if (selectedLocale != null) {
                return selectedLocale;
            }
            System.out.println(LocalizedMessages.INVALID_LOCALE_CHOICE);
        }
    }



    public YearRange promptForYearRange() {
        while (true) {
            var startYear = promptForInt(LocalizedMessages.SELECT_START_YEAR);
            var endYear = promptForInt(LocalizedMessages.SELECT_END_YEAR);

            if (startYear <= endYear) {
                return new YearRange(startYear, endYear);
            }
            System.out.println(LocalizedMessages.INVALID_YEAR_ORDER);
        }
    }

    public DataFormat getDataFormatChoice() {
        while (true) {
            int choice = promptForInt(LocalizedMessages.SELECT_DATA_FORMAT);
            var chosenFormat = DataFormat.fromChoice(choice);

            if (chosenFormat != null) {
                return chosenFormat;
            }
            System.out.println(LocalizedMessages.INVALID_MENU_CHOICE);
        }
    }

    public int promptForInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (InputValidator.isValidInt(input)) {
                return Integer.parseInt(input);
            }
            System.out.println(LocalizedMessages.ENTER_VALID_INT);
        }
    }

    public String promptForValidString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (InputValidator.isValidString( scanner.nextLine())) {
                return input;
            }
            System.out.println(LocalizedMessages.ENTER_VALID_STRING);
        }
    }
}
