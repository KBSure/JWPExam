package examples.first.lotto;

import java.util.Collections;
import java.util.List;

public class KbsMachine implements LottoMachine {

    private List<LottoBall> balls;

    @Override
    public void put(List<LottoBall> balls) {
        this.balls = balls;
    }

    @Override
    public void mix() {
        Collections.shuffle(balls);
//        for(int i = 0; i < 1000; i++){
//            int index = (int)(Math.random()*45 + 1);
//            int index2 = (int)(Math.random()*45 + 1);
//            LottoBall temp = balls.get(index);
//            balls.set(index, balls.get(index2));
//            balls.set(index2, temp);
//        }
    }

    @Override
    public List<LottoBall> getBalls() {
        return balls.subList(0,6);
    }

}
