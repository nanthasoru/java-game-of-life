import lib.grid.Grid;

public final class App {

    public static int colSize = 100;
    public static int rowSize = 100;
    public static Grid grid = new Grid(colSize, rowSize);


    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void Default() {
        int bitLower = 3;
        grid.slap(0, 4 + bitLower);
        grid.slap(0, 5 + bitLower);
        grid.slap(1, 4 + bitLower);
        grid.slap(1, 5 + bitLower);
        grid.slap(10, 4 + bitLower);
        grid.slap(10, 5 + bitLower);
        grid.slap(10, 6 + bitLower);
        grid.slap(11, 3 + bitLower);
        grid.slap(11, 7 + bitLower);
        grid.slap(12, 2 + bitLower);
        grid.slap(12, 8 + bitLower);
        grid.slap(13, 2 + bitLower);
        grid.slap(13, 8 + bitLower);
        grid.slap(14, 5 + bitLower);
        grid.slap(15, 3 + bitLower);
        grid.slap(15, 7 + bitLower);
        grid.slap(16, 4 + bitLower);
        grid.slap(16, 5 + bitLower);
        grid.slap(16, 6 + bitLower);
        grid.slap(17, 5 + bitLower);
        grid.slap(20, 2 + bitLower);
        grid.slap(20, 3 + bitLower);
        grid.slap(20, 4 + bitLower);
        grid.slap(21, 2 + bitLower);
        grid.slap(21, 3 + bitLower);
        grid.slap(21, 4 + bitLower);
        grid.slap(22, 1 + bitLower);
        grid.slap(22, 5 + bitLower);
        grid.slap(24, 0 + bitLower);
        grid.slap(24, 1 + bitLower);
        grid.slap(24, 5 + bitLower);
        grid.slap(24, 6 + bitLower);
        grid.slap(34, 2 + bitLower);
        grid.slap(34, 3 + bitLower);
        grid.slap(35, 2 + bitLower);
        grid.slap(35, 3 + bitLower);
        grid.update();
        System.out.println(grid);
    }

    public static void main(String[] args) throws Exception{
        Default();
        while (true) {
            Thread.sleep(50);
            clear();
            System.out.println(grid);
            grid.oneStep();
        }
    }
}