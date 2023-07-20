package finalExersise;

public final class Calculator implements Calculable {

    private double real;
    private double imaginary;

    public Calculator(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    @Override
    public Calculable sum(int argReal, int argImaginary) {
        real += argReal;
        imaginary += argImaginary;
        return this;
    }

    @Override
    public Calculable multi(int argReal, int argImaginary) {
        double realResult = real*argReal - imaginary*argImaginary;
        double imagineResult = imaginary*argReal + real*argImaginary;
        real = realResult;
        imaginary = imagineResult;
        return this;
    }

    @Override
    public Calculable div(int argReal, int argImaginary) {
        double denominator = Math.pow (argReal, 2)+ Math.pow (argImaginary, 2);
        double realResult = (real*argReal + imaginary*argImaginary)/denominator;
        double imagineResult = (imaginary*argReal - real*argImaginary)/denominator;
        real = realResult;
        imaginary = imagineResult;
        return this;
    }

    @Override
    public String getResult() {

        return "" + real + " + " + imaginary + "i";
    }
}
