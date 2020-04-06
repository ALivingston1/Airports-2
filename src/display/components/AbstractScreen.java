package display.components;

import util.UI;

/**
 * This class adds the basic variables,
 * and methods every screen should have like
 * open and close. Also can get the width and height of
 * each screen if user chooses to use these methods.
 */
public abstract class AbstractScreen {
    public int width;
    public int height;

    private AbstractScreen parent;

    /**
     * Create new screen with a parent to open back onto when the current one closes.
     * @param parent
     */
    public AbstractScreen(AbstractScreen parent) {
        this.parent = parent;
    }

    /**
     * Allows user to open the screen, should be the
     * method called after the new Screen is created.
     */
    public void open() {
        UI.clearScreen();
    }

    /**
     * Call this method when screen is ready to be closed,
     * then it will open up the parent.
     */
    public void close() {
        parent.open();
    }

    /**
     * Basic getter for the width of the screen if user sets it.
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Basic getter for the height of the screen if user sets it.
     * @return
     */
    public int getHeight() {
        return height;
    }
}
