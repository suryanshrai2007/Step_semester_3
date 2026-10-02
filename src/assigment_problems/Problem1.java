package assigment_problems;

import java.util.HashMap;
import java.util.Map;

abstract class WashType {
    abstract int getDurationMinutes();
    abstract double getCharge();
    abstract String getName();
}

class QuickWash extends WashType {
    int getDurationMinutes() { return 30; }
    double getCharge() { return 20.0; }
    String getName() { return "Quick"; }
}

class NormalWash extends WashType {
    int getDurationMinutes() { return 45; }
    double getCharge() { return 30.0; }
    String getName() { return "Normal"; }
}

class HeavyWash extends WashType {
    int getDurationMinutes() { return 60; }
    double getCharge() { return 45.0; }
    String getName() { return "Heavy"; }
}

class Student {
    String name;
    Student(String name) { this.name = name; }
}

class WashingMachine {
    String machineId;
    private boolean busy;

    WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
    }

    boolean isBusy() { return busy; }

    private void setBusy(boolean busy) { this.busy = busy; }

    WashCycle startWash(Student student, WashType type) {
        if (busy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return null;
        }
        setBusy(true);
        WashCycle cycle = new WashCycle(student, this, type);
        System.out.println(type.getName() + " wash started on " + machineId + " for "
                + student.name + " (" + type.getDurationMinutes() + " min). Charge: Rs."
                + String.format("%.2f", type.getCharge()));
        return cycle;
    }

    void completeCycle() {
        setBusy(false);
        System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType type;

    WashCycle(Student student, WashingMachine machine, WashType type) {
        this.student = student;
        this.machine = machine;
        this.type = type;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Map<String, WashingMachine> machines = new HashMap<>();
        machines.put("M1", new WashingMachine("M1"));
        machines.put("M2", new WashingMachine("M2"));

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = machines.get("M1");
        WashingMachine m2 = machines.get("M2");

        WashCycle c1 = m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash()); // should say busy
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}