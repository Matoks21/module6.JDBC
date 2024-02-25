package task4;


public class PrintProjectPrices {
    private final String name;
    private final long price;

    public PrintProjectPrices(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
