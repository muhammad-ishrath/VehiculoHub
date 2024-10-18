package lk.aulakapora.vehiculohub.dto;

public class VehicleDTO {

    private String brand;
    private String model;
    private int eCapacity;
    private String tMode;
    private int qty;

    public VehicleDTO(String brand, String model, int eCapacity, String tMode, int qty, double price) {
        this.brand = brand;
        this.model = model;
        this.eCapacity = eCapacity;
        this.tMode = tMode;
        this.qty = qty;
        this.price = price;
    }


    //one of Java bean spec
    public VehicleDTO() {
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

    public int geteCapacity() {
        return eCapacity;
    }

    public void seteCapacity(int eCapacity) {
        this.eCapacity = eCapacity;
    }

    public String gettMode() {
        return tMode;
    }

    public void settMode(String tMode) {
        this.tMode = tMode;
    }

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

    private double price;


}
