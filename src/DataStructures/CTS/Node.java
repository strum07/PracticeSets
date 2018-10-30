package DataStructures.CTS;

import java.util.ArrayList;

public class Node<T> {

    String key;

    ArrayList<T> controller;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<T> getController() {
        return controller;
    }

    public void setController(ArrayList<T> controller) {
        this.controller = controller;
    }

}
