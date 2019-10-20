package mastermindMVC.models;

public enum Color {
    RED('r'), BLUE('b'), YELLOW('y'), GREEN('g'), ORANGE('o'), PURPLE('p');

    public char value;

    Color(char color) {
        this.value = color;
    }

    public char getColor(){
        return value;
    }

    static String allInitials() {
        String result = "";
        for (Color color : Color.values()) {
            result += color.value;
        }
        return result;
    }

    public static Color getColor(char color){
        for (Color c : Color.values()) {
            if (c.value == color) {
                return c;
            }
        }
        return null;
    }

    public static boolean containsColor(char test) {

        for (Color c : Color.values()) {
            if (c.value == test) {
                return true;
            }
        }
        return false;
    }

}

