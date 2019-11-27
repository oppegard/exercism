package dna

import (
	"errors"
	"strings"
)

// Histogram is a mapping from nucleotide to its count in given DNA.
type Histogram map[rune]int

// DNA is a list of nucleotides.
type DNA string

// Counts generates a histogram of valid nucleotides in the given DNA.
// Returns an error if d contains an invalid nucleotide.
func (d DNA) Counts() (h Histogram, err error) {
	h = Histogram{'A': 0, 'C': 0, 'G': 0, 'T': 0}
	var invalidNucleoutides = string(d)

	for nucleotide := range h {
		h[nucleotide] = strings.Count(string(d), string(nucleotide))
		invalidNucleoutides = strings.ReplaceAll(invalidNucleoutides, string(nucleotide), "")
	}
	if len(invalidNucleoutides) > 0 {
		err = errors.New("strand contains invalid nucleotides")
	}
	return
}
