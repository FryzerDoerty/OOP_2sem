package Ex1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior{
    private final List<Actor> queue;

    public Market() {
        this.queue = new ArrayList<>();
    }


    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName()+" пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        for (Actor actor: actorList){
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        queue.add(actor);
    }

    @Override
    public void takeOrder() {
        for (Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor: queue){
            if(actor.isMakeOrder()){
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorList = new ArrayList<>();
        for (Actor actor: queue){
            if(actor.isTakeOrder()){
                actorList.add(actor);
                System.out.println(actor.getName() + " готов выходить");
            }
        }
        releaseFromMarket(actorList);
    }
}
