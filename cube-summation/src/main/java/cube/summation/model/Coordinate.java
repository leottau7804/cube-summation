package cube.summation.model;

/**
 * 3D coordinate
 *
 * @author sergioleottau
 */
public class Coordinate {

    /**
     * X axis
     */
    private int x;
    /**
     * Y axis
     */
    private int y;
    /**
     * Z axis
     */
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}