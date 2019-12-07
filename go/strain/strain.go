package strain

type Ints []int
type Lists [][]int
type Strings []string

func (i Ints) Keep(predicate func(int) bool) (result Ints) {
	if i == nil {
		return nil
	}
	result = make(Ints, 0, len(i))
	for _, n := range i {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}

func (i Ints) Discard(predicate func(int) bool) (result Ints) {
	if i == nil {
		return nil
	}
	result = make(Ints, 0, len(i))
	for _, n := range i {
		if !predicate(n) {
			result = append(result, n)
		}
	}
	return result
}

func (l Lists) Keep(predicate func(l []int) bool) (result Lists) {
	if l == nil {
		return nil
	}
	result = make(Lists, 0, len(l))
	for _, n := range l {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}

func (s Strings) Keep(predicate func(s string) bool) (result Strings) {
	if s == nil {
		return nil
	}
	result = make(Strings, 0, len(s))
	for _, n := range s {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}
