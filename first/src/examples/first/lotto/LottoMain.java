package examples.first.lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        //로또볼 45개를 준비한다.
        List<LottoBall> balls = LottoBallFactory.createBalls();

        //로또머신에 넣는다.
        LottoMachine machine = new KbsMachine();
        machine.put(balls);

        //로또머신의 로또볼을 섞는다.
        machine.mix();

        //섞인 볼들 중에서 6개를 꺼낸다.
        List<LottoBall> result = machine.getBalls();

        //결과를 출력한다.
        for(LottoBall ball : result){
            System.out.print(ball.getNum() + " ");
        }
    }
}
