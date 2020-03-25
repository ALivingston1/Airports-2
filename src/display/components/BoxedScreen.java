package display.components;

import java.util.ArrayList;

public class BoxedScreen extends AbstractScreen {
    private ArrayList<DisplayBox> boxes;

    public BoxedScreen() {

    }

    public BoxedScreen(String title, String ...strings) {

    }

    @Override
    public void open() {
        draw();
    }

    /**
     * Draws all of the boxes
     */
    @Override
    public void draw() {
        for (DisplayBox b: boxes) {
            b.draw();
        }
    }

    private void addBox(DisplayBox box) {
        boxes.add(box);
    }

    private void popBox(DisplayBox box) {
        boxes.remove(boxes.indexOf(box));
        box = null;
    }

    private void drawBox() {

    }
}
