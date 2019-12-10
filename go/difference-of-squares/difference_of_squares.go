// Package diffsquares computes the sum of squares.
// Algorithm credit: https://www.geeksforgeeks.org/difference-between-sum-of-the-squares-of-first-n-natural-numbers-and-square-of-sum/
package diffsquares

// SquareOfSum computes the square of the sum for the input.
func SquareOfSum(n int) int {
	sum := (n * (n + 1)) / 2
	return sum * sum
}

// SumOfSquares computes the sum of squares for the input.
func SumOfSquares(n int) int {
	return (n * (n + 1) * (2*n + 1)) / 6
}

// Difference computes the difference of the square of the sum and
// the sum of squares for the input.
func Difference(n int) int {
	return SquareOfSum(n) - SumOfSquares(n)
}
