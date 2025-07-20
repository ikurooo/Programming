import java.util.Objects;

class Point3 {
    int x;
    int y;
    int z;

    public Point3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3 point3 = (Point3) o;
        return x == point3.x && y == point3.y && z == point3.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
