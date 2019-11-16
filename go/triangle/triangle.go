// Package triangle provides utilities to determine kinds of triangles.
package triangle

import "math"

// Kind is a string representation of a triangle type
type Kind string

// Types of triangles
const (
	NaT = "not a triangle"
	Equ = "equilateral"
	Iso = "isosceles"
	Sca = "scalene"
)

// KindFromSides determines the kind of triangle, given three sides.
func KindFromSides(a, b, c float64) Kind {
	var k Kind

	if notTriangle(a, b, c) {
		k = NaT
	} else if a == b && b == c {
		k = Equ
	} else if a == b || a == c || b == c {
		k = Iso
	} else {
		k = Sca
	}
	return k
}

func notTriangle(a, b, c float64) bool {
	for _, side := range []float64{a, b, c} {
		if !validSide(side) {
			return true
		}
	}
	return inequalTriangle(a, b, c)
}

var invalidSideCheckers = []func(float64) bool{
	math.IsNaN,
	func(f float64) bool { return math.IsInf(f, 0) },
	func(f float64) bool { return f <= 0 },
}

func validSide(side float64) bool {
	for _, invalidSideChecker := range invalidSideCheckers {
		if invalidSideChecker(side) {
			return false
		}
	}
	return true
}

func inequalTriangle(a float64, b float64, c float64) bool {
	if (a+b < c) || (a+c < b) || (b+c < a) {
		return true
	}
	return false
}
