package display.components;

import util.UI;

public abstract class AbstractScreen {
    public int width;
    public int height;

    private AbstractScreen parent;

    public AbstractScreen(AbstractScreen parent) {
        this.parent = parent;
    }

    public void open() {
        UI.clearScreen();
    }

    public void close() {
        parent.open();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
