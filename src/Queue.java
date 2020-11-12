/**
 * Queue.java
 * This program implements QueueNodes to create a generic Queue
 * in which QueueNodes can be added to the end of the Queue,
 * the QueueNode at the front of the Queue can be either peeked
 * at or removed and returned. All QueueNodes keep track of the
 * QueueNode in front of them in line (parent) but don't care
 * who is behind them.
 * 11-12-20
 * JBH
 * @param <T>
 **/
public class Queue <T>{
    //INSTANCE-DATA
    //int size--keeps track of the size of the Queue
    private int size;
    //QueueNode firstInLine--reference to the QueueNode at the front of the Queue
    private QueueNode<T> firstInLine;
    //QueueNode lastInLine--reference to the QueueNode at the end of the Queue
    private QueueNode<T> lastInLine;

    //CONSTRUCTORS
    //Default-Constructor
    public Queue(){
        this.size = 0;
        this.firstInLine = null;
        this.lastInLine = null;
    }

    //ACCESSORS
    //public boolean isEmpty(): return true if the Queue is empty
    public boolean isEmpty(){
        return this.size == 0;
    }
    //public int size(): return the # of QueueNodes currently in the Queue
    public int size(){
        return this.size;
    }
    //public QueueNode peek(): return the QueueNode that is first in line, do not remove
    public T peek(){
        return this.firstInLine.get();
    }

    //MUTATORS
    //OVERLOADED: public void enqueue(T data): this version creates a new QueueNode with Object Data inside it
    public void enqueue(Object Data){
        QueueNode data = new QueueNode(Data);
        if(this.firstInLine == null){
            //This is the first QueueNode
            this.firstInLine = data;
        }
        else if(this.lastInLine == null){
            //Only one QueueNode present (it's the first one)
            this.lastInLine = data;
            data.setParent(this.firstInLine);
        }
        else{
            //All other cases
            data.setParent(this.lastInLine);
            this.lastInLine = data;
        }
        size++;
    }
    //OVERLOADED: public void enqueue(QueueNode data): skips the creation of QueueNode step from previous version
    public void enqueue(QueueNode data){
        if(this.firstInLine == null){
            //This is the first QueueNode
            this.firstInLine = data;
        }
        else if(this.lastInLine == null){
            //Only one QueueNode present (it's the first one)
            this.lastInLine = data;
            data.setParent(this.firstInLine);
        }
        else{
            //All other cases
            data.setParent(this.lastInLine);
            this.lastInLine = data;
        }
        size++;
    }
    //public QueueNode dequeue(): removes and returns the QueueNode that is first in line
    public T dequeue(){
        //Keep track of thing to return
        QueueNode<T> toReturn =  this.firstInLine;
        //Variable to move up through the Queue until we get to second in line
        QueueNode<T> curNode = this.lastInLine;
        //Loop that starts at the # of QueueNodes (minus 2) and loops until that number is subtracted
        //from enough to equal zero. Thus, it 'should' get the second-in-line QueueNode
        for(int i = this.size - 2; i > 0; i--){
            curNode = this.lastInLine.getParent();
        }
        //Set the instance data pointer to the former second-in-line
        this.firstInLine = curNode;
        //Set that QueueNode's parent pointer to null, there's nobody in front of it
        curNode.setParent(null);
        //Return former first-in-line QueueNode
        return toReturn.get();
    }
}
