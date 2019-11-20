// Package raindrops converts numbers to the sounds of raindrops.
package raindrops

import "strconv"

// Convert takes a number and converts into a string that contains raindrop
// sounds corresponding to certain potential factors.
func Convert(input int) string {
	var raindrops string

	if input%3 == 0 {
		raindrops += "Pling"
	}
	if input%5 == 0 {
		raindrops += "Plang"
	}
	if input%7 == 0 {
		raindrops += "Plong"
	}
	if raindrops == "" {
		raindrops = strconv.Itoa(input)
	}
	return raindrops
}
