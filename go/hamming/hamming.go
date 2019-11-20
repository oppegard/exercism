// Package hamming calculates Hamming distance
package hamming

import (
	"errors"
	"unicode/utf8"
)

// Distance calculates the Hamming distance of two strings
func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		return 0, errors.New("length mismatch")
	}

	var distance int
	for i, aRune := range a {
		bRune, _ := utf8.DecodeRuneInString(b[i:])
		if aRune != bRune {
			distance++
		}
	}
	return distance, nil
}
