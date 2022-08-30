package telran.elevator.task;

import telran.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object mutex = new Object();
    int nRaces;
    int capacity;
    Elevator elevatorA;
    Elevator elevatorB;

    int capacityPerElevator;

    public Truck(int nRaces, int capacity, Elevator elevatorA, Elevator elevatorB) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevatorA = elevatorA;
        this.elevatorB = elevatorB;
        this.capacityPerElevator = capacity/2;
    }

    @Override
    public void run() {


        for (int i = 0; i < nRaces; i++) {

            synchronized (mutex) {
                elevatorA.add(capacityPerElevator);
//                elevatorB.add(capacityPerElevator);
            }
            synchronized (mutex) {
                elevatorB.add(capacityPerElevator);
            }


//			elevator.add(capacity);
        }

    }

}
