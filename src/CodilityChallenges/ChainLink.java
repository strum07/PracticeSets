package CodilityChallenges;

enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;

    private void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    private Side longerSide() {

        ChainLink currentLink = this;

        int rightLength = 0;

        while (currentLink.right != null) {

            rightLength += 1;

            currentLink = currentLink.right;

            if (this.equals(currentLink)) return Side.NONE;
        }

        currentLink = this;

        int leftLength = 0;

        while (currentLink.left != null) {
            leftLength += 1;
            currentLink = currentLink.left;
            if (this.equals(currentLink)) return Side.NONE;
        }

        if (rightLength > leftLength) return Side.RIGHT;

        if (rightLength < leftLength) return Side.LEFT;

        return Side.NONE;
    }

    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        System.out.println(left.longerSide());
    }
}





