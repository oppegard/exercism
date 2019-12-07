package romannumerals

import (
	"errors"
	"strings"
)

var arabicToRoman = map[int]string{
	1000: "M",
	900:  "CM",
	500:  "D",
	400:  "CD",
	100:  "C",
	90:   "XC",
	50:   "L",
	40:   "XL",
	10:   "X",
	9:    "IX",
	5:    "V",
	4:    "IV",
	1:    "I",
}

// Can't `range` through the keys of a map in the order they were defined,
// so use this slice to define the descending order of values to iterate over.
var descendingArabic = []int{
	1000,
	900,
	500,
	400,
	100,
	90,
	50,
	40,
	10,
	9,
	5,
	4,
	1,
}

func ToRomanNumeral(arabic int) (roman string, err error) {
	if arabic <= 0 || arabic > 3000 {
		return "", errors.New("invalid input")
	}

	for arabic > 0 {
		for _, i := range descendingArabic {
			if q, r := divmod(arabic, i); q == 0 {
				continue
			} else {
				roman += strings.Repeat(arabicToRoman[i], q)
				arabic = r
			}
		}
	}
	return
}

func divmod(numerator, denominator int) (quotient, remainder int) {
	quotient, remainder = numerator/denominator, numerator%denominator
	return
}
