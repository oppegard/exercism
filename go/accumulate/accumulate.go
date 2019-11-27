package accumulate

// Converter is a type given to `Accumulate`, which is used to accumulate the result.
type Converter func(string) string

// Accumulate applies `converter` to every element of `words`, returning the result.
func Accumulate(words []string, converter Converter) []string {
	result := make([]string, len(words))
	for i, word := range words {
		result[i] = converter(word)
	}
	return result
}
