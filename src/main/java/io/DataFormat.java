package io;

import common.DisplayableChoice;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DataFormat implements DisplayableChoice {
    JSON(1, "JSON"),
    XML(2, "XML");

    private final int choice;
    private final String displayName;

    DataFormat(int choice, String displayName) {
        this.choice = choice;
        this.displayName = displayName;
    }

    public int getDisplayChoice() {
        return ordinal() + 1;
    }
}
