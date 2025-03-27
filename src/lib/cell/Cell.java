package lib.cell;

public final class Cell {
    
    private boolean alive;
    private boolean nextGen;
    
    /* GETTERS, SETTERS, CONSTRUCTORS */

    public Cell(boolean isAlive) {
        this.alive = isAlive;
        this.nextGen = false;
    }

    public Cell() {
        this(false);
    }

    public boolean isAlive() {
        return alive;
    }

    public void swap() {
        this.nextGen = !alive;
    }

    public void update() {
        this.alive = this.nextGen;
    }

    /* METHODS */

    public char toChar() {
        return alive ? '⬜' : '⬛';
    }

    /* @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell cell = (Cell)obj;
            return cell.alive == this.alive && cell.nextGen == this.nextGen;
        } else {
            return false;
        }
    } */
}
