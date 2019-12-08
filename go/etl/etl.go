package etl

import (
	"strings"
)

func Transform(m map[int][]string) map[string]int {
	var result = make(map[string]int)
	for point, letters := range m {
		for _, letter := range letters {
			lc := strings.ToLower(letter)
			result[lc] = point
		}
	}
	return result
}
