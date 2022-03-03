package core;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int BASE_MOVE_VALUE = 4;
    public static final int MAX_MOVE_VALUE = 10;
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public boolean isValid() {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public void move(int moveValue) {
        if (moveValue >= BASE_MOVE_VALUE) {
            position++;
        }
    }

    public int comparePosition(int targetPosition) {
        return Integer.compare(position, targetPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
