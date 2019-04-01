package CodeDome;
import java.util.LinkedHashMap;

//Problem 3: Platformer

public class Platformer {

    LinkedHashMap<Integer,Integer> availablePos;

    int currentPosition;

    private Platformer(int n, int position) {
        this.currentPosition = position;
        this.availablePos = new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            this.availablePos.put(i,i);
        }
    }

    private void jumpLeft() {
        if((currentPosition - 2) >= 0){
            int deleteTile = currentPosition;
            currentPosition = currentPosition-2;
            availablePos.remove(deleteTile);
        }
    }

    private void jumpRight() {
        if((currentPosition + 2) < availablePos.size()){
            int deleteTile = currentPosition;
            currentPosition = currentPosition + 1;
            availablePos.remove(deleteTile);
        }
    }

    public LinkedHashMap<Integer,Integer> getFloor() {
        return  availablePos;
    }

    public int position() {
        return availablePos.get(currentPosition);
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.getFloor());
        System.out.println(platformer.position());

        platformer.jumpLeft();
        System.out.println(platformer.getFloor());
        System.out.println(platformer.position());

        platformer.jumpRight();
        System.out.println(platformer.getFloor());
        System.out.println(platformer.position());

        //System.out.println(platformer.getFloor());

        platformer.jumpLeft();
        System.out.println(platformer.getFloor());
        System.out.println(platformer.position());

        //System.out.println(platformer.getFloor());
    }
}
