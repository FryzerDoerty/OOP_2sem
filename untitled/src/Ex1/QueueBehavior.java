package Ex1;

public interface QueueBehavior {
    void  takeInQueue(Actor actor);

    void  takeOrder();
    void  giveOrders();
    void  releaseFromQueue();
}
