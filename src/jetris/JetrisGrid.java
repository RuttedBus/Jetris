package jetris;

/**
 * Created by STUDLER on 1/27/15.
 */
public class JetrisGrid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 22;
    private static final Node[] TOP_ROW = new Node[WIDTH];

    public JetrisGrid() {
        for(int i = 0; i < WIDTH; i++) {
            TOP_ROW[i] = new Node();
            Node next = TOP_ROW[i];
            for(int j = 1; j < HEIGHT; j++) {
                Node newNode = new Node();
                next.down = newNode;
                newNode.up = next;
                next = newNode;
            }
        }
        Node left, right;
        for(int i = 0; i < WIDTH - 1; i++) {
            left = TOP_ROW[i];
            right = TOP_ROW[i + 1];
            for(int j = 0; j < HEIGHT; j++) {
                left.right = right;
                right.left = left;
                left = left.down;
                right = right.down;
            }
        }
    }

    public void print() {
        for(Node left = TOP_ROW[0]; left != null; left = left.down) {
            for(Node cur = left; cur != null; cur = cur.right) {
                System.out.print(cur.toString() + " ");
            }
            System.out.println("");
        }
    }

    public class Node {

        public Node() { block = Block.EmptyBlock; }

        public boolean canMove(Direction dir) {
            boolean canMove = true;
            switch(dir) {
                case Left:
                    canMove = this.left.getBlock() != Block.StationaryBlock &&
                            this.left.getBlock() != null;
                    break;
                case Right:
                    canMove = this.right.getBlock() != Block.StationaryBlock &&
                            this.right.getBlock() != null;
                    break;
                case Up:
                    canMove = this.up.getBlock() != Block.StationaryBlock &&
                            this.up.getBlock() != null;
                    break;
                case Down:
                    canMove = this.down.getBlock() != Block.StationaryBlock &&
                            this.left.getBlock() != null;
                    break;
            }
            return canMove;

        }

        @Override
        public String toString() {
            String str = "";
            switch(this.getBlock()) {
                case EmptyBlock:
                    str = "EmptyBlock";
                    break;
                case MovableBlock:
                    str = "MovableBlock";
                    break;
                case StationaryBlock:
                    str = "StationaryBlock";
                    break;
            }
            return str;
        }

        public Block getBlock() {
            return this.block;
        }

        private Node left;
        private Node right;
        private Node up;
        private Node down;
        private Block block;
    }

    public enum Block {
        EmptyBlock,
        MovableBlock,
        StationaryBlock
    }

    public enum Direction {
        Left, Right, Up, Down
    }



}
