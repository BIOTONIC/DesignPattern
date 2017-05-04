package FactoryMethodPattern;

/**
 * Created by lovejoy on 02/05/2017.
 *
 * SimpleFactoryPattern is not good when a new toothpaste comes.
 * Because this may change the origin codes.
 * So the solution is Factory Method Pattern:
 * Just add new codes.
 * Each color of toothpaste have a concrete factory.
 */
interface PerfumeToothpaste {
    String getColor();
}

class AchanToothpaste implements PerfumeToothpaste {
    public String getColor() {
        return "pink";
    }
}

class KashiyukaToothpaste implements PerfumeToothpaste {
    public String getColor() {
        return "orange";
    }
}

class NocchiToothpaste implements PerfumeToothpaste {
    public String getColor() {
        return "blue";
    }
}

interface PerfumeToothpasteFactory {
    PerfumeToothpaste getPerfumeToothpaste();
}

class AchanToothpasteFactory implements PerfumeToothpasteFactory {
    public AchanToothpaste getPerfumeToothpaste() {
        return new AchanToothpaste();
    }
}

class KashiyukaToothpasteFactory implements PerfumeToothpasteFactory {
    public KashiyukaToothpaste getPerfumeToothpaste() {
        return new KashiyukaToothpaste();
    }
}

class NocchiToothpasteFactory implements PerfumeToothpasteFactory {
    public NocchiToothpaste getPerfumeToothpaste() {
        return new NocchiToothpaste();
    }
}

class Fan {
    public static void main(String args[]) {
        PerfumeToothpasteFactory perfumeToothpasteFactory = new KashiyukaToothpasteFactory();
        PerfumeToothpaste perfumeToothpaste = perfumeToothpasteFactory.getPerfumeToothpaste();
        System.out.println("Kashiyuka\'s toothpaste is " + perfumeToothpaste.getColor() + ".");
    }
}