package model;

public class CarModel {
    private String car_name;
    private String car_brand;
    private String car_makeyear;
    private byte[] carImage;

    public CarModel() {}

    public CarModel(String car_name, String car_brand, String car_makeyear, byte[] carImage) {
        this.car_name = car_name;
        this.car_brand = car_brand;
        this.car_makeyear = car_makeyear;
        this.carImage = carImage;
    }

    public String getCarName() {
        return car_name;
    }

    public void setCarName(String car_name) {
        this.car_name = car_name;
    }

    public String getCarBrand() {
        return car_brand;
    }

    public void setCarBrand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCarMakeyear() {
        return car_makeyear;
    }

    public void setCarMakeyear(String car_makeyear) {
        this.car_makeyear = car_makeyear;
    }

    public byte[] getCarImage() {
        return carImage;
    }

    public void setCarImage(byte[] carImage) {
        this.carImage = carImage;
    }
}
