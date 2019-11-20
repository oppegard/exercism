// Package scrabble provides utilities for the game of Scrabble.
package scrabble

import (
	"strings"
	"unicode"
)

// Score takes a word and returns its Scrabble score.
func Score(word string) (score int) {
	for _, letter := range word {
		score += pointValueFor(letter)
	}
	return
}

func pointValueFor(r rune) (points int) {
	for _, lettersToPoint := range lettersToPoints {
		if strings.ContainsRune(lettersToPoint.letters, unicode.ToUpper(r)) {
			points = lettersToPoint.points
			break
		}
	}
	return
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
