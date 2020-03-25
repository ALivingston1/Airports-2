package display.components;

public class BoxedScreen extends DisplayBox implements IScreen {
    private DisplayBox box;

    public BoxedScreen(String title, int sections) {
        super(title, sections);
    }

    public BoxedScreen(String title, String ...strings) {
        super(title, strings);
    }

    @Override
    public void open() {
        draw();
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    private void draw(String ...strings) {

    }

    private void drawBox() {

    }
}
