package com.example.designpatterns.behavioral;

/**
 * A behavioral design pattern focuses on how classes and objects communicate with each other. The main
 * focus of the command pattern is to inculcate a higher degree of loose coupling between involved
 * parties (read: classes).
 *
 * Accent pe LOOSE COUPLING. Pot schimba foarte usor logica unei anumite comenzi, atat la nivel de
 * comanda (ConcreteCommand), cat si la nivel de executie/receiver (prin adaugarea unui alt Receiver
 * si adaugarea unei alte comenzi concrete ce va chema noul Receiver). Astfel, adaugarea de logica
 * noua va avea un efect minim asupra codului nostru high-level (cel de client).
 *
 * In mod alternativ, codul de client ar depinde direct de Chef si am fi afectati mereu cand vrem sa
 * schimbam logica actiunilor facute de acesta.
 */

class Chef { // Receiver
    public void cookPasta() {
        System.out.println("Chef is cooking Chicken Alfredo…");
    }

    public void bakeCake() {
        System.out.println("Chef is baking Chocolate Fudge Cake…");
    }
}



























public interface Command {
    void execute();
}

class ConcreteCommand1 implements Command {
    private Chef chef;
    private String food;

    public ConcreteCommand1(Chef chef, String food) {
        this.chef = chef;
        this.food = food;
    }

    @Override
    public void execute() {
        if (this.food.equals("Pasta")) {
            this.chef.cookPasta();
        } else {
            this.chef.bakeCake();
        }
    }
}


















class Waiter { // Invoker
    private Command command;

    public Waiter(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}


















class Client {
    public static void main(String[] args) {
        Chef chef = new Chef();

        Waiter waiter = new Waiter(new ConcreteCommand1(chef, "Pasta"));
        waiter.execute();

        waiter.setCommand(new ConcreteCommand1(chef, "Cake"));
        waiter.execute();
    }
}
