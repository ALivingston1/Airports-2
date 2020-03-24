package Display;

import java.util.ArrayList;

public class DisplayBox {
    private String title;
    private int sections;
    private ArrayList<String> data;

    public DisplayBox(String title, int sections) {
        this.title = title;
        this.sections = sections;
    }

    public DisplayBox(String title, String ...strings) {
        this.title = title;

        for (String s: strings) {

        }
    }

    /**
     * Allows user to set title later
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getSections() {
        return sections;
    }
}
