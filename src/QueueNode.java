/**
 * Jack Hughes
 * QueueNode.java
 * This is a generic datatype node class--it keeps track of some data, a parent node.
 * 11-12-20
 * JBH
 * @param <T>
 */
public class QueueNode <T> {
    //Generic datatype
    private T t;
    //Parent node
    protected QueueNode parent;

    //CONSTRUCTORS
    //Constructor--default (set to null)
    public QueueNode() {
        this.t = null;
        this.parent = null;
    }

    //Constructor--just data
    public QueueNode(T t) {
        this.t = t;
        this.parent = null;
    }

    //Constructor--data and parent/child nodes
    public QueueNode(T t, QueueNode p) {
        this.t = t;
        this.parent = p;
    }

    //ACCESSORS
    //Accessor--Stored data
    public T get() {
        return this.t;
    }

    //Accessor--Parent node
    public QueueNode getParent() {
        return this.parent;
    }

    //MUTATORS
    //Mutator--Stored data
    public void set(T t) {
        this.t = t;
    }

    //Mutator--Parent node
    public void setParent(QueueNode p) {
        this.parent = p;
    }

    //OVERRIDES OF DEFAULT METHODS
    //.toString()--returns datatype's toString
    @Override
    public String toString() {
        if (this.t == null) {
            return null;
        }
        return this.t.toString();
    }

    //.equals()--returns if this datatype equals other node's datatype
    public boolean equals(QueueNode n) {
        return this.t.equals(n.get());
    }
}