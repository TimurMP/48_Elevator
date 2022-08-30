package telran.elevator.task;

import telran.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object mutex = new Object();
    int nRaces;
    int capacity;
    Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (mutex) {
                elevator.add(capacity);
            }
//			elevator.add(capacity);
        }

    }

}
