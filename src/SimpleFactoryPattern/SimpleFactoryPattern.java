package SimpleFactoryPattern;

/**
 * Created by lovejoy on 02/05/2017.
 *
 * Perfume is a Japan female music group.
 * There are three members in this group:
 * Achan, Kashiyuka and Nocchi.
 * Once they three made a business endorsement for a toothpaste.
 * They three represent three different colors of toothpaste.
 */
interface PerfumeToothpaste {
    String getName();

    String getColor();
}

class AchanToothpaste implements PerfumeToothpaste {
    public String getName() {
        return "Achan";
    }

    public String getColor() {
        return "pink";
    }
}

class KashiyukaToothpaste implements PerfumeToothpaste {
    public String getName() {
        return "Kashiyuka";
    }

    public String getColor() {
        return "orange";
    }
}

class NocchiToothpaste implements PerfumeToothpaste {
    public String getName() {
        return "Nocchi";
    }

    public String getColor() {
        return "blue";
    }
}

/*
 * Notice that getToothpaste() method is static.
 */
class ToothpasteFactory {
    public static PerfumeToothpaste getToothpaste(String name) {
        PerfumeToothpaste perfumeToothpaste = null;
        if (name.equalsIgnoreCase("Achan")) {
            perfumeToothpaste = new AchanToothpaste();
        } else if (name.equalsIgnoreCase("Kashiyuka")) {
            perfumeToothpaste = new KashiyukaToothpaste();
        } else if (name.equalsIgnoreCase("Nocchi")) {
            perfumeToothpaste = new NocchiToothpaste();
        }
        return perfumeToothpaste;
    }
}

/*
 * One Perfume fan wants to buy achan's toothpaste,
 * he can tell the factory what he wants.
 */
class Fan {
    public static void main(String args[]) {
        PerfumeToothpaste perfumeToothpaste;
        perfumeToothpaste = ToothpasteFactory.getToothpaste("Achan");
        System.out.println(perfumeToothpaste.getName() + "\'s toothpaste is " + perfumeToothpaste.getColor() + ".");
    }
}