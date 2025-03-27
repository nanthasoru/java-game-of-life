package lib.grid;

import lib.cell.*;

public final class Row {
    
    private final Cell[] row;
    private boolean defined;
    public final int length;

    /* GETTERS, SETTERS, CONSTRUCTORS */

    Row(int length) {
        this.row = new Cell[length];
        this.length = this.row.length;
        defined = init();
    }

    /* METHODS BUT THEY'RE SOME KIND OF SETTERS */

    boolean init() {
        if (!defined) for (int i = 0 ; i < this.length ; i++) {
            this.row[i] = new Cell();
        }
        return true;
    }

    boolean clear() {
        if (defined) for (int i = 0 ; i < this.length ; i++) {
            this.row[i] = null;
        }
        return false;
    }

    /* METHODS */

    @Override
    public String toString() {
        String ret = "";
        for (Cell cell : row) {
            ret += cell.toChar();
        }
        return ret;
    }

    void update() {
        for (Cell cell : this.row) {
            cell.update();
        }
    }

    void slap(int x) {
        this.row[x].swap();
    }

    Cell pick(int x) {
        return this.row[x];
    }

    int aliveNeighbourOf(int x) {
        int ret = 0;
        if (x-1 >= 0) ret += row[x-1] == null ? 0 : row[x-1].isAlive() ? 1 : 0;
        if (x+1 >= 0 && x+1 < length) ret += row[x+1] == null ? 0 : row[x+1].isAlive() ? 1 : 0;
        return ret;
    }
}
