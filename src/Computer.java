public class Computer {

    protected String manufactuerer;
    protected String processor;
    protected int ramSize;
    protected int diskSize;
    protected double processorSpeed;

    public  Computer(String man, String proc, int ram, int disk, double procSpeed){
        manufactuerer = man;
        processor = proc;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;

    }

    public double computerPower() {
        return ramSize * processorSpeed;
    }

    public double getRamSize() {
        return ramSize;
    }
    public double getProcessorSpeed(){
     return processorSpeed;
    }
    public int getDiskSize(){
        return diskSize;
    }
    public String toString(){
        String result = "Manufacturer: " + manufactuerer +
                "\nCPU: " + processor +
                "\nRAM: " + ramSize + "megabytes" +
                "\nDisk: " + diskSize + "gigabytes" +
                "\nProcessor speed: " + processorSpeed + "gigahertz";
        return result;
    }
}
