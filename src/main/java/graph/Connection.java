package graph;

import java.util.Objects;

public class Connection {

    protected boolean hasDirectConnection;
    protected int price;

    public Connection(boolean hasDirectConnection, int price) {
        this.hasDirectConnection = hasDirectConnection;
        this.price = price;
    }

    public boolean isHasDirectConnection() {
        return hasDirectConnection;
    }

    public int getPrice() {
        return price;
    }

    public boolean getConnection() {
        return hasDirectConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return hasDirectConnection == that.hasDirectConnection &&
                price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasDirectConnection, price);
    }
}
