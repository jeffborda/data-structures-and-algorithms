package graph;

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
}
