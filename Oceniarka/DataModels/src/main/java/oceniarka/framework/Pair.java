package oceniarka.framework;

/**
 * Created by eryk on 08.12.15.
 */
public class Pair<L, R> {

    private L l;

    private R r;

    public Pair(L l, R r) {
        this.l = l;
        this.r = r;
    }

    public L getKey() {
        return l;
    }

    public R getValue() {
        return r;
    }

}
