//Problem 3: Platformer

import java.util.ArrayList;

public class test {

    ArrayList<Integer> floor;

    int currentPosition;

    private test(int n, int position) {
        this.currentPosition = position;
        this.floor = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            this.floor.add(i,i);
        }
    }

    private void jumpLeft() {
        if((currentPosition - 2) >= 0){
            int deleteTile = currentPosition;
            currentPosition = currentPosition-2;
            floor.remove(deleteTile);
        }
    }

    private void jumpRight() {
        if((currentPosition + 2) < floor.size()){
            int deleteTile = currentPosition;
            currentPosition = currentPosition + 1;
            floor.remove(deleteTile);
        }
    }

    public ArrayList<Integer> getFloor() {
        return floor;
    }

    public int position() {
        return floor.get(currentPosition);
    }

    public static void main(String[] args) {
        test platformer = new test(6, 3);

        System.out.println(platformer.position());

        platformer.jumpLeft();
        System.out.println(platformer.position());

        platformer.jumpRight();
        System.out.println(platformer.position());

        System.out.println(platformer.getFloor());

        platformer.jumpLeft();
        System.out.println(platformer.position());

        System.out.println(platformer.getFloor());
    }
}
