package com.example.designpatterns.structural;

/**
 * The decorator design pattern falls into the structural category, that deals with the actual
 * structure of a class, whether is by inheritance, composition or both. The goal of this design
 * is to modify an objects’ functionality at runtime. This is one of the many other design
 * patterns that utilize abstract classes and interfaces with composition to get its desired result.
 */
public class Decorator {
}

abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        super("House blend");
    }

    @Override
    public double cost() {
        return 250;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        super("Dark roast");
    }

    @Override
    public double cost() {
        return 300;
    }
}


































abstract class AddOn extends Beverage {
    protected Beverage beverage;

    public AddOn(String description, Beverage bev) {
        super(description);
        this.beverage = bev;
    }

    public abstract String getDescription();
}

class Sugar extends AddOn {
    public Sugar(Beverage bev) {
        super("Sugar", bev);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 50;
    }
}

class Milk extends AddOn {
    public Milk(Beverage bev) {
        super("Milk", bev);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Milk";
    }

    @Override  public double cost() {
        return beverage.cost() + 100;
    }
}




















class CoffeeShop {
    public static void main(String[] args) {
        HouseBlend houseblend = new HouseBlend();
        System.out.println(houseblend.getDescription() + ": " + houseblend.cost());

        Milk milkAddOn = new Milk(houseblend);
        System.out.println(milkAddOn.getDescription() + ": " + milkAddOn.cost());

        Sugar sugarAddOn = new Sugar(milkAddOn);
        System.out.println(sugarAddOn.getDescription() + ": " + sugarAddOn.cost());









//        Cookie cookieAddOn = new Cookie(sugarAddOn);
//        System.out.println(cookieAddOn.getDescription() + ": " + cookieAddOn.cost());
    }
}
































abstract class OtherAddOn extends Beverage {
    protected Beverage beverage;

    public OtherAddOn(String description, Beverage bev) {
        super(description);
        this.beverage = bev;
    }

    public abstract String getDescription();
}

class Cookie extends OtherAddOn {
    public Cookie(Beverage bev) {
        super("cookie", bev);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and you get a cookie";
    }

    @Override
    public double cost() {
        return beverage.cost() + 25;
    }

}
