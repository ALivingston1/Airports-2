package display.components;

import java.util.ArrayList;

public abstract class AbstractBoxScreen extends AbstractScreen {
    public ArrayList<DisplayBox> boxes;

    public AbstractBoxScreen(AbstractScreen parent) {
        super(parent);
        boxes = new ArrayList<>();
    }

    public void drawBoxes() {
        for (DisplayBox box: boxes) {
            box.draw();
        }
    }

    public void addBox(DisplayBox box) {
        boxes.add(box);
    }

    public void popBox(DisplayBox box) {
        boxes.remove(boxes.indexOf(box));
        box = null;
    }

    @Override
    public void open() {
        super.open();
    }
}
