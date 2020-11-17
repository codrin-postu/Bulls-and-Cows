class Army {

    public static void createArmy() {
        Unit unitOne = new Unit("One");
        Unit unitTwo = new Unit("Two");
        Unit unitThree = new Unit("Three");
        Unit unitFour = new Unit("Three");
        Unit unitFive = new Unit("Three");
        Knight knightOne = new Knight("One");
        Knight knightTwo = new Knight("Two");
        Knight knightThree = new Knight("Three");
        General general = new General("general");
        Doctor doc = new Doctor("doc");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}