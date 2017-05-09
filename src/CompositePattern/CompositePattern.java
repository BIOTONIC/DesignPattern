package CompositePattern;

import java.util.ArrayList;

/**
 * Created by lovejoy on 09/05/2017.
 * http://blog.csdn.net/lovelion/article/details/7956931
 */
abstract class Component {
    abstract void add(Component component);

    abstract void remove(Component component);

    abstract Component getChild(int i);

    abstract void searchFile();
}

class ImageFile extends Component {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void add(Component component) {
        System.out.println("None");
    }

    public void remove(Component component) {
        System.out.println("None");
    }

    public Component getChild(int i) {
        System.out.println("None");
        return null;
    }

    public void searchFile() {
        System.out.println("Search image file " + name);
    }
}

class TextFile extends Component {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void add(Component component) {
        System.out.println("None");
    }

    public void remove(Component component) {
        System.out.println("None");
    }

    public Component getChild(int i) {
        System.out.println("None");
        return null;
    }

    public void searchFile() {
        System.out.println("Search text file " + name);
    }
}

class Folder extends Component {
    private String name;

    private ArrayList<Component> componentList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Component component) {
        componentList.add(component);
    }

    public void remove(Component component) {
        componentList.remove(component);
    }

    public Component getChild(int i) {
        return componentList.get(i);
    }

    public void searchFile() {
        System.out.println("Search folder " + name);

        for (Object obj : componentList) {
            ((Component) obj).searchFile();
        }
    }
}

class Client {
    public static void main(String args[]) {
        Component folder1, folder2, image1, image2, image3, text1, text2;
        folder1 = new Folder("Document");
        folder2 = new Folder("Downloads");

        image1 = new ImageFile("achan.png");
        image2 = new ImageFile("nocchi.jpg");
        image3 = new ImageFile("kashiyuka.bmp");

        text1 = new TextFile("apply.doc");
        text2 = new TextFile("approve.txt");

        folder1.add(folder2);
        folder1.add(image1);
        folder1.add(image2);
        folder1.add(text1);
        folder2.add(image3);
        folder2.add(text2);

        folder1.searchFile();
    }
}