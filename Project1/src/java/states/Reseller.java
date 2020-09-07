package states;

import util.State;
import util.Town;
import util.TownCell;

public class Reseller extends TownCell {

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public Reseller(Town town, int row, int col) {
        super(town, row, col);
    }

    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNew) {
        return null;
    }
}