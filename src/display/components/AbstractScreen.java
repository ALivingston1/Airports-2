package display.components;

abstract class AbstractScreen implements IDisplay {
    public int width;
    public int height;

    public abstract void open();

    public int getWidth() {
        return width;
    };

    public int getHeight() {
        return width;
    };
}
