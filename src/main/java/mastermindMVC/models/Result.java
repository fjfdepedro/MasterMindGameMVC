package mastermindMVC.models;


public class Result {
    private int deads;
    private int damaged;

    public Result(int deads, int damaged){
        this.damaged = damaged;
        this.deads = deads;
    }

    public int getDeads() {
        return this.deads;
    }

    public int getDamaged() {
        return this.damaged;
    }

    public boolean isWinner(){
        return deads == Combination.NUMBER_ITEMS;
    }
}