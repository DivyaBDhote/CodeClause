class Classroom {
    private int numRows;
    private int numColumns;
    private boolean[][] seats;

    public Classroom(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.seats = new boolean[numRows][numColumns];
    }

    public boolean isSeatAvailable(int row, int column) {
        if (row < 0 || row >= numRows || column < 0 || column >= numColumns) {
            System.out.println("Invalid seat coordinates.");
            return false;
        }
        return !seats[row][column];
    }

    public void occupySeat(int row, int column) {
        if (row < 0 || row >= numRows || column < 0 || column >= numColumns) {
            System.out.println("Invalid seat coordinates.");
            return;
        }

        if (seats[row][column]) {
            System.out.println("Seat is already occupied.");
        } else {
            seats[row][column] = true;
            System.out.println("Seat at row " + (row + 1) + ", column " + (column + 1) + " has been occupied.");
        }
    }

    public void displaySeatingArrangement() {
        System.out.println("Exam Seating Arrangement:");
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                System.out.print(seats[row][column] ? "X " : "O ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numRows = 5; // Number of rows in the classroom
        int numColumns = 5; // Number of columns in the classroom

        Classroom classroom = new Classroom(numRows, numColumns);

        // Example: Occupying some seats
        classroom.occupySeat(0, 1);
        classroom.occupySeat(2, 3);
        classroom.occupySeat(4, 2);
        classroom.occupySeat(3, 0);

        // Display the seating arrangement
        classroom.displaySeatingArrangement();
    }
}
    
}
