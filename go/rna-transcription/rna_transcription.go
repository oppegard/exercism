// Package strand processes DNA strands.
package strand

// ToRNA transcribes a DNA sequence to its RNA complement.
func ToRNA(dna string) string {
	var rna string
	for _, nucleotide := range dna {
		rna += string(dnaToRna[nucleotide])
	}
	return rna
}

var dnaToRna = map[rune]rune{
	'G': 'C',
	'C': 'G',
	'T': 'A',
	'A': 'U',
}
