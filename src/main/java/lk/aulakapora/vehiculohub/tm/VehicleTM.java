package lk.aulakapora.vehiculohub.tm;


import java.io.Serializable;

public class VehicleTM implements Serializable {

    private int id;
    private String brand;
    private String model;



    private int engineCapacity;
    private String transmissionMode;

    public VehicleTM(int id, String brand, String model, int engineCapacity, String transmissionMode, int qty, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.transmissionMode = transmissionMode;
        this.qty = qty;
        this.price = price;
    }

    public VehicleTM() {
    }

    private int qty;

    private double price;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmissionMode() {
        return transmissionMode;
    }

    public void setTransmissionMode(String transmissionMode) {
        this.transmissionMode = transmissionMode;
    }

    @Override
    public String toString() {
        return "VehicleTM{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", transmissionMode='" + transmissionMode + '\'' +
                ", Qty=" + qty +
                ", price=" + price +
                '}';
    }
}
