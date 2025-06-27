class Vehicle
{
     int speed = 0;
     void speedUp()
     {
        speed += 5;
        System.out.println("Vehicle speeds up to " + speed + " km/h");
     }
}

class Car extends Vehicle
{
    void speedUp()
    {
        speed += 20;
        System.out.println("Car speeds up to " + speed + " km/h");
    }
}
class Bicycle extends Vehicle
{
     void speedUp()
    {
        speed += 10;
        System.out.println("Bicycle speeds up to " + speed + " km/h");
    }
}
class Main
{
    public static void main(String[] args)
    {
        Vehicle myVehicle = new Vehicle();
        Vehicle myCar = new Car();
        Vehicle myBicycle = new Bicycle();

        myVehicle.speedUp();
        myCar.speedUp();
        myBicycle.speedUp();
    }
}