package sugaEngine.input;

/**
 * Gives an enum value to the different key values.
 *
 * @author Sugaku
 */
public enum KeyValues {

    /**
     * The enter key maps to keycode '10'.
     */
    ENTER(10),

    /**
     * The escape key maps to keycode 27.
     */
    ESC(27),

    /**
     * The left key maps to keycode 37.
     */
    ARROW_LEFT(37),

    /**
     * The up key maps to keycode 38.
     */
    ARROW_UP(38),

    /**
     * The right key maps to keycode 39.
     */
    ARROW_RIGHT(39),

    /**
     * The down key maps to keycode 40.
     */
    ARROW_DOWN(40),

    /**
     * The 'a' key maps to keycode 65.
     */
    A(65),

    /**
     * The 'd' key maps to keycode 68.
     */
    D(68),

    /**
     * The 'i' key maps to keycode 73.
     */
    I(73),

    /**
     * The 'l' key maps to keycode 76.
     */
    L(76),

    /**
     * The 's' key maps to keycode 83.
     */
    S(83),

    /**
     * The 'w' key maps to keycode 87.
     */
    W(87);

    /**
     * The integer value of the integer value.
     */
    private final int value;

    /**
     * Creates a new KeyValue with the given value.
     *
     * @param value The value to assign to this key.
     */
    KeyValues (int value) {
        this.value = value;
    }

    /**
     * Returns the value of the key.
     *
     * @return The value associated with the key.
     */
    public int getValue () {
        return value;
    }

    /**
     * Converts the given int keycode into an enum value from KeyValues.
     *
     * @param code The code of the key pressed.
     * @return The enum value of the key if present, otherwise null.
     */
    public static KeyValues toEnum (int code) { // Might be a bit slow for input handling. Perhaps prioritize more popular keys.
        for (KeyValues k : KeyValues.values())  //  This would also be a good level for key remapping.
            if (k.getValue() == code)
                return k;
        return null;
    }
}
