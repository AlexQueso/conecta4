package conecta4.types;

import java.io.Serializable;

public enum Color implements Serializable {
    R,
    Y,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
}
