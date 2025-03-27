package lib.grid;

import lib.cell.Cell;

public final class Grid {
    
    private final Row[] grid;
    private final int colSize, rowSize;
    private boolean defined;

    /* GETTERS, SETTERS, CONSTRUCTORS */

    public Grid(int colSize, int rowSize) {
        if (colSize < 1 || rowSize < 1) {
            throw new Error("NegativeColOrRowValues");
        }
        this.colSize = colSize;
        this.rowSize = rowSize;
        this.grid = new Row[colSize];
        this.build();
    }

    /* METHODS BUT THEY'RE KIND OF SETTERS TOO */

    private boolean init(int colSize) {
        if (!defined) for (int i = 0 ; i < this.colSize ; i++) {
            this.grid[i] = new Row(rowSize);
        }
        return true;
    }

    private boolean clear() {
        if (defined) for (int i = 0 ; i < this.colSize ; i++) {
            this.grid[i] = null;
        }
        return false;
    }

    private void build() {
        this.defined = defined ? clear() || init(rowSize) : init(rowSize);
    }

    /* METHODS */

    @Override
    public String toString() {
        String ret = "";
        for (Row row : this.grid) {
            ret += '\n'+row.toString();
        }
        return ret.substring(1);
    }

    public void update() {
        for (Row row : this.grid) {
            row.update();
        }
    }

    public void slap(int x, int y) {
        this.grid[y%this.colSize].slap(x%this.rowSize);
    }

    private int aliveNeighbourOf(int x, int y) {
        x = x%this.rowSize;
        y = y%this.colSize;
        int ret = this.grid[y].aliveNeighbourOf(x);

        for (int index : new int[]{y-1, y+1}) {
            if (index >= 0 && index < this.colSize) {
                ret += this.grid[index] == null ? 0 : this.grid[index].aliveNeighbourOf(x);
                ret += this.grid[index].pick(x).isAlive() ? 1 : 0;
            }
        }
        return ret;
    }

    public void oneStep() {
        for (int i = 0 ; i < colSize ; i++) {
            for (int j = 0 ; j < rowSize ; j++) {
                Cell current = this.grid[i].pick(j);
                boolean alive = current.isAlive();
                int aliveNeighbour = aliveNeighbourOf(j, i);
                if (aliveNeighbour == 2)
                    continue;
                else if (aliveNeighbour == 3) {
                    if (!alive) current.swap();
                    continue;
                } else if (alive)
                    current.swap();
            }
        }
        update();
    }
}
