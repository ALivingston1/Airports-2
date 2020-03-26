package display.components;

import java.util.Queue;

public abstract class AbstractScreen {
    public int width;
    public int height;

    public abstract void open();

    public int getWidth() {
        return width;
    };

    public int getHeight() {
        return height;
    };
}
