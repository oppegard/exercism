// Package scrabble provides utilities for the game of Scrabble.
package scrabble

import (
	"strings"
	"unicode"
)

var lettersToPoints = map[string]int{
	"AEIOULNRST": 1,
	"DG":         2,
	"BCMP":       3,
	"FHVWY":      4,
	"K":          5,
	"JX":         8,
	"QZ":         10,
}

// Score takes a word and returns its Scrabble score.
func Score(word string) (score int) {
	for _, letter := range word {
		score += pointValueFor(letter)
	}
	return
}

func pointValueFor(r rune) int {
	for letters, pointValue := range lettersToPoints {
		if strings.ContainsRune(letters, unicode.ToUpper(r)) {
			return pointValue
		}
	}
	return 0
}
