package Ex1;

import java.awt.*;
import java.util.List;

public interface MarketBehavior {
    void  acceptToMarket(Actor actor);
    void  releaseFromMarket(List<Actor> actorList);
    void update();

}
