package util;

/**
 * @author Miguel Flores
 * TownCell is an abstract class that helps take a census of neighboring cells
 * in its given town.
 * A TownCell is defined by the town its in, position inside the town
 * and util.State
 * <p>
 * TownCell has two abstract methods that need to be implemented
 * who() and next()
 */
public abstract class TownCell {

    protected Town town;
    protected int row;
    protected int col;

    public static final int NUM_CELL_TYPE = 5;

    //Use this static array to take census.
    public static final int[] nCensus = new int[NUM_CELL_TYPE];

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public TownCell(Town town, int row, int col) {
        this.town = town;
        this.row = row;
        this.col = col;
    }

    /**
     * Censuses all cell types in the 3 X 3 neighborhood
     *
     * @param nCensus counts of all customers
     */
    public void census(int[] nCensus) {
        // zero the counts of all customers
        nCensus[StateSwitcher.RESELLER] = 0;
        nCensus[StateSwitcher.EMPTY] = 0;
        nCensus[StateSwitcher.CASUAL] = 0;
        nCensus[StateSwitcher.OUTAGE] = 0;
        nCensus[StateSwitcher.STREAMER] = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;

                if ((r < 0 || r > town.getLength()-1) || (c < 0 || c > town.getWidth()-1))
                    continue;

                nCensus[StateSwitcher.returnValueFromState(town.grid[r][c].who())]++;
            }
        }
    }

    /**
     * Gets the identity of the cell.
     *
     * @return util.State
     */
    public abstract State who();

    /**
     * Determines the cell type in the next cycle.
     *
     * @param tNew: town of the next cycle
     * @return util.TownCell
     */
    public abstract TownCell next(Town tNew);
}
