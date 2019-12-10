package protein

import "errors"

var ErrStop = errors.New("STOP")
var ErrInvalidBase = errors.New("INVALID_BASE")

var CodonToProtein = map[string]string{
	"AUG": "Methionine",
	"UUU": "Phenylalanine",
	"UUC": "Phenylalanine",
	"UUA": "Leucine",
	"UUG": "Leucine",
	"UCU": "Serine",
	"UCC": "Serine",
	"UCA": "Serine",
	"UCG": "Serine",
	"UAU": "Tyrosine",
	"UAC": "Tyrosine",
	"UGU": "Cysteine",
	"UGC": "Cysteine",
	"UGG": "Tryptophan",
	"UAA": "STOP",
	"UAG": "STOP",
	"UGA": "STOP",
}

func FromCodon(input string) (string, error) {
	if protein, present := CodonToProtein[input]; present {
		if protein == "STOP" {
			return "", ErrStop
		} else {
			return protein, nil
		}
	}
	return "", ErrInvalidBase
}
