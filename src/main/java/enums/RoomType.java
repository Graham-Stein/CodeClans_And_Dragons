package enums;

public enum RoomType {
    CAVERN1("Cavern 1"),
    THE_LAKE("The Lake"),
    CAVERN2("Cavern 2"),
    THE_ICE_CAVE("The Ice Cave");

    private String value;

    RoomType(String value) {this.value = value;}

    public String getValue() {
        return this.value;
    }
}
