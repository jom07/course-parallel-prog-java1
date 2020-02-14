/**
 * Two threads chopping vegetables.
 */

class VegetableChopper extends Thread {

    public static boolean chopping = true;
    public int vegetableCount = 0;

    public VegetableChopper(String name) {
        this.setName(name);
    }

    public void run() {
        while (chopping) {
            System.out.println(this.getName() + " chopped a vegetable!");
            vegetableCount++;
        }
    }
}

public class ExecutionSchedulingDemo {
    public static void main(String args[]) throws InterruptedException {
        VegetableChopper barron = new VegetableChopper("Barron");
        VegetableChopper olivia = new VegetableChopper("Olivia");

        // Barron start chopping.
        barron.start();
        // Olivia start chopping.
        olivia.start();
        // continue chopping for 1 second.
        Thread.sleep(1000);
        // stop chopping.
        VegetableChopper.chopping = false;

        barron.join();
        olivia.join();
        System.out.format("Barron chopped %d vegetables.\n", barron.vegetableCount);
        System.out.format("Olivia chopped %d vegetables.\n", olivia.vegetableCount);
    }
}