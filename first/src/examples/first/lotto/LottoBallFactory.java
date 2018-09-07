package examples.first.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {
    private List<LottoBall> balls;
    private LottoBallFactory(){
    }

    public static List<LottoBall> createBalls(){
        List<LottoBall> balls = new ArrayList<>();
        for(int i = 1; i <= 45; i++){
            balls.add(new LottoBall(i));
        }
        return balls;
    }
}
