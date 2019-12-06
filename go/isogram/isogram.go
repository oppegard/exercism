// Package isogram determines if a word or phrase is an isogram.
// More info: https://en.wikipedia.org/wiki/Isogram.
package isogram

import "unicode"

// IsIsogram takes a word or phrase and determines if it's an isogram.
func IsIsogram(input string) bool {
	var state = map[rune]bool{}
	for _, r := range input {
		if r == '-' || r == ' ' {
			continue
		}
		lowercase := unicode.ToLower(r)
		if _, present := state[lowercase]; present {
			return false
		}
		state[lowercase] = true
	}
	return true
}
