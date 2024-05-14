/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;

    public Percolation(int n) {
        // IllegalArgumentException if n<=0
        if (n <= 0) throw new IllegalArgumentException("Grid must be at least 1-by-1");
        StdOut.println(n);

        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
        openSites = 0;
    }

    public void open(int row, int col) {
        checkException(row, col);
        opened[row - 1][col - 1] = true;
        ++openSites;

        // Edge case if any of top row boxes are open
        if (row == 1) qf.union(getQuickFindIndex(row, col), TOP);
        // Edge case if any bottom rows are open
        if (row == size) qf.union(getQuickFindIndex(row, col), bottom);
        // if any boxes in middle rows, check for neighbors
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
        }
    }

    private int getQuickFindIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    private void checkException(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return qf.find(TOP) == qf.find(getQuickFindIndex(row, col));
        }
        else throw new IllegalArgumentException();
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return qf.find(TOP) == qf.find(bottom);
    }
    
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Percolation test = new Percolation(n);
        PercolationVisualizer.draw(test, n);
    }
}
