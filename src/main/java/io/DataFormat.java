package io;

public enum DataFormat {
    JSON(1, "JSON"),
    XML(2, "XML");

    private final int choice;
    private final String description;

    DataFormat(int choice, String description) {
        this.choice = choice;
        this.description = description;
    }

    public static DataFormat fromChoice(int choice) {
        for (DataFormat format : values()) {
            if (format.choice == choice) {
                return format;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }
}
