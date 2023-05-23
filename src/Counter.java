// ID:313547085

/**
 * The main class for Counter.
 * This is a program that defines a Counter, adds and subtracts a number from the current count
 * and gets the value of the current count.
 *
 * @author Dor Levy
 */
public class Counter {

    private int currentCount;

    /**
     * This method is a constructor of the Counter class.
     * The method Defines the class members.
     *
     * @param currentCount this is the current count
     */
    public Counter(int currentCount) {
        this.currentCount = currentCount;
    }

    /**
     * The increase method gets a number and adds it to the current count.
     *
     * @param number This is an integer
     */
    public void increase(int number) {
        this.currentCount = this.currentCount + number;
    }

    /**
     * The decrease method gets a number and subtracts it from the current count.
     *
     * @param number This is an integer
     */
    public void decrease(int number) {
        this.currentCount = this.currentCount - number;
    }

    /**
     * The getValue method returns the current count.
     *
     * @return int This returns the current count.
     */
    public int getValue() {
        return this.currentCount;
    }
}