package mastermindMVC.models;

import java.util.List;
import java.util.ArrayList;

public abstract class Combination {

    public static final int NUMBER_ITEMS = 4;
    protected List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<Color>();
    }

    public static int getWidth() {
        return Combination.NUMBER_ITEMS;
    }

    public Color[] getColors() {
        Color[] arrayColors = new Color[NUMBER_ITEMS];
        return this.colors.toArray(arrayColors);
    }
}

