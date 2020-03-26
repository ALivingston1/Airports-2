package Display.components;

import java.util.ArrayList;
import util.UI;

public class DisplayBox implements display.components.IDisplayComponent {
    private String title;
    private int sections;
    private ArrayList<String> data;

    public DisplayBox(String title, int sections) {
        this.title = title;
        this.sections = sections;
        data = new ArrayList<>();
    }

    public DisplayBox(String title, String ...strings) {
        this.title = title;
        sections = strings.length;
        data = new ArrayList<>();

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
        sections++;
    }

    /**
     * Getter for data in box
     * @return ArrayList<String></String>
     */
    public ArrayList<String> getData() {
        return data;
    }

    /**
     * Allows user to remove data later
     * @param string
     */
    public void popData(String string) {
        data.remove(string);
        sections--;
    }

    @Override
    public void draw() {
        int len = UI.getMaxStringLen(data);
        if (len < title.length()) {
            len = title.length();
        }

        System.out.println("-".repeat(len + 4));
        System.out.println("|" + " ".repeat(((len + 2) - title.length()) / 2) + title + " ".repeat(((len + 2) - title.length()) / 2) + "|");
        System.out.println("-".repeat(len + 4));

        if (sections > 0) {
            for (int i = 0; i < sections; i++) {
                System.out.println("|" + " ".repeat(((len + 3) - data.get(i).length()) / 2) + data.get(i) + " ".repeat(((len + 2) - data.get(i).length()) / 2) + "|");
            }
            System.out.println("-".repeat(len + 4));
        }
    }
}
