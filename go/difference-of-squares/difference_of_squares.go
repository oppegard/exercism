// Package diffsquares provides functions to compute squares of sums, sums of
// squares, and difference between the square of the sum and the sum of the
// squares of the first N natural numbers.
// Algorithm credit: https://www.geeksforgeeks.org/difference-between-sum-of-the-squares-of-first-n-natural-numbers-and-square-of-sum/
package diffsquares

// SquareOfSum computes the square of the sum for the first N natural numbers.
func SquareOfSum(n int) int {
	sum := (n * (n + 1)) / 2
	return sum * sum
}

// SumOfSquares computes the sum of squares for the input for the first N natural numbers.
func SumOfSquares(n int) int {
	return (n * (n + 1) * (2*n + 1)) / 6
}

// Difference computes the difference of the square of the sum and
// the sum of squares for the first N natural numbers.
func Difference(n int) int {
	return SquareOfSum(n) - SumOfSquares(n)
}
