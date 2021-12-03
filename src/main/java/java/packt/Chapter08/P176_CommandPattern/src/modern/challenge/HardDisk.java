package java.packt.Chapter08.P176_CommandPattern.src.modern.challenge;

public class HardDisk implements IODevice {

    @Override
    public void copy() {
        System.out.println("Copying ...");
    }

    @Override
    public void delete() {
        System.out.println("Deleting ...");
    }

    @Override
    public void move() {
        System.out.println("Moving ...");
    }

}
