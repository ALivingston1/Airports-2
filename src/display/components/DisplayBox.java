package display.components;

import java.util.ArrayList;
import util.UI;

public class DisplayBox implements IDisplay {
    private String title;
    private int sections;
    private ArrayList<String> data;

    public DisplayBox(String title, int sections) {
        this.title = title;
        this.sections = sections;
    }

    public DisplayBox(String title, String ...strings) {
        this.title = title;
        sections = strings.length;

        for (String s: strings) {
            addData(s);
        }
    }

    /**
     * Allows user to set title later
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets title
     * @return String title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets Number of Sections in box
     * @return int sections
     */
    public int getNumSections() {
        return sections;
    }

    /**
     * Allows user to add data later
     * @param string
     */
    public void addData(String string) {
        data.add(string);
    }

    /**
     * Allows user to remove data later
     * @param string
     */
    public void popData(String string) {
        data.remove(string);
    }

    @Override
    public void draw() {
        System.out.print("-".repeat(UI.getMaxStringLen(data)));
    }
}
