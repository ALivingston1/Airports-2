package display.components;

import java.util.ArrayList;

/**
 * This class is an addition to the abstract screen class and
 * allows the user to add display boxes to the screen.
 */
public abstract class AbstractBoxScreen extends AbstractScreen {
    public ArrayList<DisplayBox> boxes;

    /**
     * Constructor.
     * Gets a parent screen to open on when the current one is done being opened.
     * @param parent
     */
    public AbstractBoxScreen(AbstractScreen parent) {
        super(parent);
        boxes = new ArrayList<>();
    }

    /**
     * Will draw all boxes in the arraylist. Handy for just displaying
     * a sum of information if needed.
     */
    public void drawBoxes() {
        for (DisplayBox box: boxes) {
            box.draw();
        }
    }

    /**
     * Adds a displaybox to the arraylist
     * @param box
     */
    public void addBox(DisplayBox box) {
        boxes.add(box);
    }

    /**
     * Removes a box to the arraylist
     * @param box
     */
    public void popBox(DisplayBox box) {
        boxes.remove(boxes.indexOf(box));
        box = null;
    }
}
