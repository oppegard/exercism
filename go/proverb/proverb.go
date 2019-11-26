// Package proverb generates a wide range of pithy proverbs (currently one).
package proverb

import "fmt"

// Proverb returns the "For Want of a Nail" proverb.
func Proverb(rhyme []string) (result []string) {
	numWords := len(rhyme)
	result = make([]string, numWords)

	for i := 0; i < numWords-1; i++ {
		result[i] = fmt.Sprintf("For want of a %s the %s was lost.", rhyme[i], rhyme[i+1])
	}
	if numWords > 0 {
		result[numWords-1] = fmt.Sprintf("And all for the want of a %s.", rhyme[0])
	}
	return
}
