public class Laptop {

    private static String logo = "Apple";

    private String model;
    private int ramSize;
    // private String processor;

    //protected Processor processor;
    private String processor;

    Laptop(String model, int ramSize, String processor) {
        this.model = model;
        this.ramSize = ramSize;
        this.processor = processor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = this.processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void displayInfo() {
        System.out.println("Logo: " + logo);
        System.out.println("Model: " + model);
        System.out.println("RAM Size: " + ramSize + "GB");

    }

}