package vsu.shirnin.container;

/**
 * Allows to store any number of objects, presented as a linear singly linked list.
 * @author Andrew Shirnin
 * @version 1.0
 */
public class Container {
    private ContainerElement head;

    /**
     * Class constructor
     */
    public Container() {
        this.head = null;
    }

    /**
     * Adds a number to the beginning of the list
     * @param data item data
     */
    public void addToBeg (int data) {
        ContainerElement firstElement = new ContainerElement(data);
        ContainerElement exHead = this.head;
        head = firstElement;
        firstElement.next = exHead;
    }

    /**
     * Adds a number to the end of the list
     * @param data item data
     */
    public void push (int data) {
        ContainerElement newElement = new ContainerElement(data);
        if (this.head == null) {
            this.head = newElement;
        } else {
            ContainerElement tail = this.head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newElement;
        }
    }

    /**
     * Inserts a number after the entered index
     * @param after the index after which the number will be inserted
     * @param data inserted item data
     */
    public void insert(int after, int data) {
        if (after < 1 || after > this.length()) {
          throw new IllegalArgumentException("No element found with this index");
        }
        int position = 0;
        ContainerElement temp = this.head;
        while (temp != null) {
            position++;
            if (after == position) {
                ContainerElement insertElement = new ContainerElement(data);
                ContainerElement nextElement = temp.next;
                temp.next = insertElement;
                insertElement.next = nextElement;
            }
            temp = temp.next;
        }
    }

    /**
     * Removes an element
     * @param index the index of the item to remove
     */
    public void delete (int index) {
        if (index < 1 || index > this.length()) {
            throw new IllegalArgumentException("No element found with this index");
        }
        if (index == 1) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                this.head = this.head.next;
            }
        } else if (index == this.length()) {
            ContainerElement temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        } else if (index > 1 && index < this.length()) {
            int position = 0;
            ContainerElement temp = this.head;
            while (temp != null) {
                position++;
                if (index == position + 1) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * Removes the last element
     * @return last item data
     */
    public int pop() {
        if (this.head == null) {
            throw new NullPointerException("Empty container");
        }
        if (this.head.next == null) {
            int lastElement = head.data;
            this.head = null;
            return lastElement;
        } else {
            ContainerElement temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int lastElement = temp.next.data;
            temp.next = null;
            return lastElement;
        }
    }

    /**
     * Extract data and removes an item
     * @param index the index of the item
     * @return deleted item data
     */
    public int extract(int index) {
        if (index < 1 || index > this.length()) {
            throw new IllegalArgumentException("No element found with this index");
        }
        int extractData;
        if (index == 1) {
            extractData = this.head.data;
            if (this.head.next == null) {
                this.head = null;
            } else {
                this.head = this.head.next;
            }
        } else if (index == this.length()) {
            ContainerElement temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            extractData = temp.next.data;
            temp.next = null;
        } else {
            int position = 1;
            ContainerElement temp = this.head;
            while (temp != null && position + 1 != index) {
                position++;
                temp = temp.next;
            }
            extractData = temp.next.data;
            temp.next = temp.next.next;
        }
        return extractData;
    }

    /**
     * Displays the elements of the container
     * @return container element string
     */
    public String show() {
        String strList = "";
        if (this.head == null) {
            strList += "Empty container :(";
        } else {
            ContainerElement temp = this.head;
            strList += "[ ";
            while (temp != null) {
                strList += temp.data + " ";
                temp = temp.next;
            }
            strList += "]";
        }
        return strList;
    }

    /**
     * @return container length
     */
    public int length() {
        int count = 0;
        ContainerElement temp = this.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * @return false if container is empty
     */
    public boolean notEmpty() {
        return this.head != null;
    }
}
