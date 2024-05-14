/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class PercolationStats {
    // TODO independent trials on n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        Percolation test = new Percolation(n);
        for (int i = 0; i < trials; i++) {
            // TODO run trials
        }
    }

    // TODO sample mean of percolation threshold
    public double mean() {
        return 0.0;
    }

    // TODO sample standard dev of percolation threshold
    public double stddev() {
        return 0.0;
    }

    // TODO low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0.0;
    }

    // TODO high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0.0;
    }

    // TODO test client
    // TODO Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0.
    /* TODO Also, include a main() method that takes two command-line arguments n and T,
        performs T independent computational experiments (discussed above) on an n-by-n grid,
        and prints the sample mean, sample standard deviation,
        and the 95% confidence interval for the percolation threshold.
        Use StdRandom to generate random numbers; use StdStats to compute the sample mean and
        sample standard deviation.
     */
    /* TODO Now, implement the Percolation data type using the weighted quick union algorithm
        in WeightedQuickUnionUF. Answer the questions in the previous paragraph.
     */
    public static void main(String[] args) {

    }
}
