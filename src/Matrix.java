/**
 * makes 2 -d chars
 * mcan put chars , erease or clear it
 * or print
 */
public class Matrix {
    private final char[][] grid;

    /**
     * making a Matrix with with rowsa and columns
     * @param rows of numb of rows
     * @param cols of num of columns
     */
    public Matrix(int rows, int cols) {
        grid = new char[rows][cols];
        clear();
    }

    /**
     * make a matrix with rows and columns
     * fill every spot with the character you choos
     * @param fill the character to fill every spot
     * @param rows number of rows
     * @param cols number of columns
     */
    public Matrix(int rows, int cols, char fill) {
        grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = fill;
            }
        }
    }

    /**
     * Put a character at the given row and column, if it’s inside the grid.
     * @param row the row index (starts at 0)
     * @param col the column index (starts at 0)
     * @param ch the character to place
     */
    public void set(int row, int col, char ch) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            grid[row][col] = ch;
        }
    }

    /**
     * gets how many rows the matrix has
     * @return number of rows
     */
    public int getRows() {
        return grid.length;
    }

    /**
     * Get how many columns the matrix has n
     * @return number of columns
     */
    public int getCols() {
        return grid[0].length;
    }

    /**
     * Clear the matrix
     */
    public void clear() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    /**
     * make a String vers of the matrix and each row on a new line
     * @return the matrix as text
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            sb.append(new String(row)).append('\n');
        }
        return sb.toString();
    }

    /**
     * Print the matrix to the screen.
     */
    public void print() {
        System.out.print(this.toString());
    }
}
