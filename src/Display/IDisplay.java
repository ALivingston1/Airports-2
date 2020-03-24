package Display;

import java.util.Scanner;

public interface IDisplay {
    public void open();

    public void draw(String ...strings);

    int getInt();

    String getString();
}
