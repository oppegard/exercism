package romannumerals

import (
	"errors"
	"strings"
)

type arabicToRoman struct {
	arabic int
	roman  string
}

var mappings = []arabicToRoman{
	{1000, "M"},
	{900, "CM"},
	{500, "D"},
	{400, "CD"},
	{100, "C"},
	{90, "XC"},
	{50, "L"},
	{40, "XL"},
	{10, "X"},
	{9, "IX"},
	{5, "V"},
	{4, "IV"},
	{1, "I"},
}

func ToRomanNumeral(input int) (result string, err error) {
	if input <= 0 || input > 3000 {
		return "", errors.New("invalid input")
	}

	for _, mapping := range mappings {
		if quotient := input / mapping.arabic; quotient != 0 {
			result += strings.Repeat(mapping.roman, quotient)
			input = input % mapping.arabic
		}
	}
	return
}
