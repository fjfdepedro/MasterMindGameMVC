package mastermindMVC.utils;

import mastermindMVC.models.Color;

import java.util.ArrayList;

public class ValidatorCombination {

    String combinationColors;
    int numberItems;

    public ValidatorCombination(String textWithProposedColors, int number_items) {
        combinationColors = textWithProposedColors;
        numberItems       = number_items;
    }

    public boolean checkValidColor () {
        ArrayList<Boolean> items_validation_color = new ArrayList<Boolean>();
        for (int i = 0; i < combinationColors.length(); i++){
            char c = combinationColors.charAt(i);
            items_validation_color.add(Color.containsColor(c));
        }
        if (items_validation_color.contains(Boolean.FALSE)){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkRepeatedColor () {
        for (int i = 0; i < combinationColors.length(); i++) {
            for (int j = i + 1; j < combinationColors.length(); j++) {
                if (combinationColors.charAt(i) == (combinationColors.charAt(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkNumberItemsColorIsOk () {
        return numberItems == combinationColors.length();
    }
}

