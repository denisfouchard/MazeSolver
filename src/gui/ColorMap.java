package gui;

import java.awt.*;
import java.util.HashMap;

public class ColorMap extends HashMap<Character, Color> {

    public ColorMap(){
        super();
        this.put('D', Color.BLUE);
        this.put('A', Color.RED);
        this.put('W', Color.BLACK);
        this.put('E', Color.WHITE);

    }
}
