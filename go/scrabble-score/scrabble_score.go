// Package scrabble provides utilities for the game of Scrabble.
package scrabble

import (
	"strings"
	"unicode"
)

// Score takes a word and returns its Scrabble score.
func Score(word string) int {
	var score int
	for _, letter := range word {
		score += pointValueFor(letter)
	}
	return score
}

func pointValueFor(r rune) int {
	for _, lettersToPoint := range lettersToPoints {
		if strings.ContainsRune(lettersToPoint.letters, unicode.ToUpper(r)) {
			return lettersToPoint.points
		}
	}
	return 0
}

var lettersToPoints = []struct {
	letters string
	points  int
}{
	{"AEIOULNRST", 1},
	{"DG", 2},
	{"BCMP", 3},
	{"FHVWY", 4},
	{"K", 5},
	{"JX", 8},
	{"QZ", 10},
}
