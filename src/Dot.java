import java.util.Objects;

/**
 * Created by makiknight on 24/01/17.
 */
public class Dot {

    private int abs;
    private int ord;

    /**
     * @param abs : abscissa of the dot
     * @param ord : ordinate of the dot
     */
    public Dot(int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
    }

    public static void main(String[] args) {
        Dot dot1 = new Dot(-25, 87);
        System.out.println(dot1.toString());
        Dot dot2 = new Dot(-500, 378);
        System.out.println(dot2.toString());
        Dot dot3 = dot1.shorterPath(dot2);

        System.out.println(dot1.shorterPath(dot2).toString());
        //System.out.println(dot3.shorterPath(dot2).toString());
        System.out.println(dot1.forecastEnergy(dot2));
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return getAbs() == dot.getAbs() &&
                getOrd() == dot.getOrd();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbs(), getOrd());
    }

    @Override
    public String toString() {
        return "Dot{" +
                "abs=" + abs +
                ", ord=" + ord +
                '}';
    }

    /**
     * @param dot : the final point you want to reach
     * @return the next nearest point from your location to the point you want to reach
     */
    public Dot shorterPath(Dot dot) {
        //Create the return point
        Dot target = new Dot(abs, ord);

        //Check if abscissa and ordinate of the point is lesser or not that final point
        boolean diffAbs = abs < dot.getAbs();
        boolean diffOrd = ord < dot.getOrd();

        if (abs == dot.getAbs() && ord == dot.getOrd()) {
            //We are arrived
            target = dot;
        } else {
            //Same abscissa but not the same ordinate
            if (abs == dot.getAbs() && ord != dot.getOrd()) {
                if (!diffOrd) {
                    target = new Dot(abs, ord + 1);
                } else {
                    target = new Dot(abs, ord - 1);
                }
            } else {
                //Same ordinate but not the same abscissa
                if (abs != dot.getAbs() && ord == dot.getOrd()) {
                    if (diffAbs) {
                        target = new Dot(abs + 1, ord);
                    } else {
                        target = new Dot(abs - 1, ord);
                    }
                } else {
                    //Both abscissa and ordinate are different
                    if (diffOrd && diffAbs) {
                        target = new Dot(abs + 1, ord + 1);
                    } else {
                        if (diffOrd && !diffAbs) {
                            target = new Dot(abs - 1, ord + 1);
                        } else {
                            if (!diffOrd && diffAbs) {
                                target = new Dot(abs + 1, ord - 1);
                            } else {
                                target = new Dot(abs - 1, ord - 1);
                            }
                        }
                    }
                }
            }
        }
        return target;
    }

    /**
     * @param dot : the final dot you want to know how much ernegy you need to reach
     * @return the forecast energy
     */
    public int forecastEnergy(Dot dot) {
        if (this.equals(dot)) {
            return 0;
        } else {
            return 1 + this.shorterPath(dot).forecastEnergy(dot);
        }
    }
}
