package vsu.shirnin.container;

public class ContainerElement {
    int data;
    ContainerElement next;

    ContainerElement() {}
    ContainerElement(int data) {
        this.data = data;
        this.next = null;
    }
}
