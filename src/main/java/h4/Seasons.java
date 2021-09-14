package h4;

public enum Seasons {
    SPRING ("Warm"),
    SUMMER ("Warm"),
    FALL ("Cold"),
    WINTER ("Cold");

    public final String label;

    Seasons(String label) {
        this.label = label;
    }
}
