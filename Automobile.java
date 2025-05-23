public class Automobile {

    public static class Main{
        public static void main(String[] args) {
            //Creating instances of all objects created for vehicles
            Automobile myAuto = new Automobile();
            Toyota myToyota = new Toyota();
            Toyota.Corolla myCorolla = new Toyota.Corolla();
            Toyota.Tundra myTundra = new Toyota.Tundra();
            Toyota.Highlander myHighlander = new Toyota.Highlander();

            // Demonstrating the use of Wrapper classes
            myAuto.setEstablishedYear(2022); // Integer Wrapper class
            myToyota.setPrice(25000); // Double (Wrapper class)
            myCorolla.setSlogan("White");
            myTundra.setType(String.valueOf('T'));



            //To ensure all setters and getters are being used:
            System.out.println("Toyota Price: " + myToyota.getPrice());
            System.out.println("Corolla Slogan: " + myCorolla.getSlogan());
            System.out.println("Tundra Type: " + myTundra.getType());
            System.out.println("Corolla Fuel Efficiency: " + myCorolla.showFuelEfficiency());



            //Static binding (non-override methods)
            System.out.println("Established Year: " + myAuto.getEstablishedYear());

            Automobile myVehicle = myCorolla; // Upcasting
            myVehicle.sound(); // Calls Corolla's sound method

            myVehicle = myToyota; // Changing reference
            myVehicle.sound(); // Calls Toyota's sound method

            myVehicle = myTundra; // Changing reference
            myVehicle.sound(); // Calls Tundra's sound method

            myVehicle = myHighlander; // Changing reference
            myVehicle.sound(); // Calls Highlander's sound method

            // Demonstrating inner/nested class usage
            Toyota.Highlander.ThirdRowConfiguration thirdRowConfig = myHighlander.configureThirdRow( 8);
            System.out.println(thirdRowConfig);


        }
    }


    //creating instance variables using Wrapper classes
    private static Integer establishedYear;
    private Double price;
    private String slogan;
    private Character type;


    //getters and setters:

    //This constructor getEstablishedYear gets establishedYear returning it.
    public Integer getEstablishedYear() {
        return establishedYear;
    }

    //This constructor has a method called setEstablishedYear that is defined by a method used to set a new object called establishedYear.
    public void setEstablishedYear(Integer establishedYear) {
        Automobile.establishedYear = establishedYear;
    }

    // from here down we have created setters and getters for each instance wrapped using the same format/idea
    public Double getPrice() {

        return price;
    }

    //polymorphism demonstrating method overloading in this example Integer gets converted to Double
    public void setPrice(Integer price) {
        this.price = Double.valueOf(price);
    }

    public String getSlogan() {

        return slogan;
    }

    public void setSlogan(String slogan) {

        this.slogan = slogan;
    }

    public Character getType() {

        return type;
    }
    public void setType(String type) {
        this.type = type.charAt(0);
    }

    public void sound (){
        System.out.println("Automobile sound: Vroom!");
    }
}

    class Toyota extends Automobile {

        Toyota() {
            setEstablishedYear(1937);
            setPrice(0); // need to change these from 0.0 to just 0
            setSlogan("Lets go Places");
            setType("na"); // need to change T to na

        }

        public void sound (){
            System.out.println("Automobile sound: BEEP!");
        }

        static class Corolla extends Toyota {
            Corolla() {
                setEstablishedYear(2023);
                setPrice(21700);
                setSlogan("not override");
                setType(String.valueOf('c'));
            }
            //Creating a method in Corolla class not creating in other classes

            public void sound() {
                System.out.println("Corolla sound: Whir!");
            }

            //Unique method in Corolla class
            public String showFuelEfficiency() {
                return "Corolla fuel efficiency: 30 MPG";
            }

        }

        static class Tundra extends Toyota {
            Tundra() {
                setEstablishedYear(2023);
                setPrice(38965);
                setSlogan("not override");
                setType(String.valueOf('t'));
            }

            public void sound() {
                System.out.println("Corolla sound: sqrt!");
            }
        }

        static class Highlander extends Toyota {
            Highlander() {
                setEstablishedYear(2023);
                setPrice(36620);
                setSlogan("not override");
                setType(String.valueOf('s'));
            }

            public void sound() {
                System.out.println("Corolla sound: RRRRRRR!");
            }


            //Nested class ThirdRowConfiguration creates int seatCount object if input is 7 or 8
            static class ThirdRowConfiguration {
                private int seatCount;

                //Constructor method checks if seatCount is 7 or 8 and creates object seatCount
                ThirdRowConfiguration(int seatCount) {
                    if (seatCount == 7 || seatCount == 8) {
                        this.seatCount = seatCount;
                    } else {
                        throw new IllegalArgumentException("Seat count must be 7 or 8");
                    }
                }

                //Getter method returns seatCount
                public int getSeatCount() {
                    return seatCount;
                }

                //Setter method used to change the number of seats later after object has been created
                public void setSeatCount(int seatCount) {
                    if (seatCount == 7 || seatCount == 8) {
                        this.seatCount = seatCount;
                    } else {
                        throw new IllegalArgumentException("Seat count must be 7 or 8");
                    }
                }

                public String toString() {
                    return "Third-row configuration:" + seatCount + "seats";
                }
            }

            public ThirdRowConfiguration configureThirdRow(int seatCount) {
                return new ThirdRowConfiguration(seatCount);
            }

        }

    }


