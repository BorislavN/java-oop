package encapsulation.box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length * this.width + this.length * this.height + this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * ( this.length * this.height + this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;

    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume – %.2f"
                , this.calculateSurfaceArea()
                , this.calculateLateralSurfaceArea()
                , this.calculateVolume());
    }

    private void setLength(double length) {
        this.validateValue("Length", length);

        this.length = length;
    }

    private void setWidth(double width) {
        this.validateValue("Width", width);

        this.width = width;
    }

    private void setHeight(double height) {
        this.validateValue("Height", height);

        this.height = height;
    }

    private void validateValue(String field, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", field));
        }
    }
}