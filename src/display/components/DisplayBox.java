package display.components;

import java.util.ArrayList;
import util.UI;

/**
 * Helper component for part of a screen.
 * Fancier display class for boxed information
 * Includes a title, and sections (rows) of information.
 * Can add, remove, and set the title and each section.
 */
public class DisplayBox implements IDisplayComponent {
    public ArrayList<String> data;

    /**
     * Constructor
     * Has to include title
     * @param title
     */
    public DisplayBox(String title) {
        data = new ArrayList<>();
        data.add(title);
    }

    /**
     * Constructor
     * Has to include a title and the data within it.
     * (Allows for displaybox creation without any additional
     * work done)
     * @param title
     * @param strings
     */
    public DisplayBox(String title, String ...strings) {
        data = new ArrayList<>();
        data.add(title);

        for (String s: strings) {
            addData(s);
        }
    }

    /**
     * Allows user to set title later
     * @param title
     */
    public void setTitle(String title) {
        data.set(0, title);
    }

    /**
     * Gets title
     * @return String title
     */
    public String getTitle() {
        return data.get(0);
    }

    /**
     * Gets Number of Sections in box, includes title box
     * @return int sections
     */
    public int getNumSections() {
        return data.size();
    }

    /**
     * Allows user to add data later
     * @param string
     */
    public void addData(String string) {
        data.add(string);
    }

    /**
     * Allows user to add integer to the data as well
     * @param i
     */
    public void addData(int i) {
        data.add(Integer.toString(i));
    }

    /**
     * Sets the data for specified section.
     * Title is index of 0, and sections
     * are everything above. Throws NullPointerException
     * if the section index does not exist.
     * @param section
     * @param data
     */
    public void setData(int section, String data) throws NullPointerException{
        if (section <= data.length() && section >= 0) {
            if (section == 0) {
                setTitle(data);
            } else {
                this.data.set(section, data);
            }
        } else {
            throw new NullPointerException("Section " + section + " does not exist.");
        }
    }

    /**
     * Allows user to remove data later
     * @param string
     */
    public void popData(String string) {
        data.remove(string);
    }

    /**
     * Actually draws the displaybox
     * If the box has only a title, won't
     * draw the sections.
     */
    @Override
    public void draw() {
        int len = UI.getMaxStringLen(data);
        String title = data.get(0);
        if (len < title.length()) {
            len = title.length();
        }

        System.out.println("-".repeat(len + 4));
        System.out.println("|" + " ".repeat(((len + 2) - title.length()) / 2) + title + " ".repeat(((len + 2) - title.length()) / 2) + "|");
        System.out.println("-".repeat(len + 4));

        if (data.size() > 1) {
            for (int i = 1; i < data.size(); i++) {
                System.out.println("|" + " ".repeat(((len + 3) - data.get(i).length()) / 2) + data.get(i) + " ".repeat(((len + 2) - data.get(i).length()) / 2) + "|");
            }
            System.out.println("-".repeat(len + 4));
        }
    }
}
