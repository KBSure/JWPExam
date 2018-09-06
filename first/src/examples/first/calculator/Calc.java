package examples.first.calculator;

/**
 * 간단한 계산기
 */
public class Calc {
    // 필드를 선언
    private int value;

    public Calc(){
        this.value = 0;
    }

    public Calc(int value){
        this.value = value;
    }

    /**
     * plusValue를 받아서 누저갛ㄴ다.
     * @param plusValue
     */
    public void plus(int plusValue){
        this.value = this.value + plusValue;
    }

    public void minus(int minusValue){
        this.value -= minusValue;
    }

    public void multiply(int multiplyValue){
        this.value *= multiplyValue;
    }

    public void divide(int divisionValue){
        this.value /= divisionValue;
    }

    public void clear(){
        this.value = 0;
    }


    /**
     * 내부 값을 반환한다.
     * @return
     */
    public int getValue(){
        return this.value;
    }
}
