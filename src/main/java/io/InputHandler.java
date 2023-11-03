package io;

import common.DisplayableChoice;
import config.AvailableLocale;
import model.YearRange;
import validator.InputValidator;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public YearRange promptForYearRange() {
        while (true) {
            var startYear = promptForInt(LocalizedMessages.getMessage(MessageKey.SELECT_START_YEAR));
            var endYear = promptForInt(LocalizedMessages.getMessage(MessageKey.SELECT_END_YEAR));

            if (isValidYearOrder(startYear, endYear)) {
                return new YearRange(startYear, endYear);
            }
            System.out.println(LocalizedMessages.getMessage(MessageKey.INVALID_YEAR_ORDER));
        }
    }

    public int promptForInt(String message) {
        return promptWithValidation(message, InputValidator::isValidInt, MessageKey.ENTER_VALID_INT);
    }

    public String promptForValidString(String message) {
        return promptWithValidation(message, InputValidator::isValidString, MessageKey.ENTER_VALID_STRING);
    }

    public AvailableLocale getLocaleChoice() {
        return getChoice(AvailableLocale.class, MessageKey.PROMPT_LOCALE_CHOICE, MessageKey.INVALID_LOCALE_CHOICE);
    }

    public DataFormat getDataFormatChoice() {
        return getChoice(DataFormat.class, MessageKey.PROMPT_DATA_FORMAT_CHOICE, MessageKey.INVALID_MENU_CHOICE);
    }


    private <T> T promptWithValidation(String message, Predicate<String> validator, MessageKey errorMessageKey) {
        while (true) {
            System.out.print(message);
            var input = scanner.nextLine();

            if (validator.test(input)) {
                return (T) input;
            }

            displayError(errorMessageKey);
        }
    }
    private  <E extends Enum<E> & DisplayableChoice> E getChoice(Class<E> enumClass, MessageKey promptMessage, MessageKey invalidChoiceMessage) {
        while (true) {
            DisplayableChoiceHelper.displayChoices(enumClass, promptMessage);

            var choice = promptForInt(LocalizedMessages.getMessage(MessageKey.YOUR_CHOICE));
            var selectedOption = DisplayableChoiceHelper.fromChoice(enumClass, choice);

            if (selectedOption.isPresent()) {
                return selectedOption.get();
            }
            System.out.println(LocalizedMessages.getMessage(invalidChoiceMessage));
        }
    }
    private boolean isValidYearOrder(int start, int end) {
        return start <= end;
    }
    private void displayError(MessageKey key) {
        System.out.println(LocalizedMessages.getMessage(key));
    }
}
