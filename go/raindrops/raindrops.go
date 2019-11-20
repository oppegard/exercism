// Package raindrops converts numbers to the sounds of raindrops.
package raindrops

import "strconv"

// Convert takes a number and converts into a string that contains raindrop
// sounds corresponding to certain potential factors.
func Convert(input int) string {
	var raindrops string

	for _, translation := range translations {
		if input%translation.number == 0 {
			raindrops += translation.raindrop
		}
	}

	if raindrops == "" {
		raindrops = strconv.Itoa(input)
	}

	return raindrops
}

var translations = []struct {
	number   int
	raindrop string
}{
	{3, "Pling"},
	{5, "Plang"},
	{7, "Plong"},
}
