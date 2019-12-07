package strain

type Ints []int
type Lists [][]int
type Strings []string

func (i Ints) Keep(predicate func(int) bool) Ints {
	if i == nil {
		return nil
	}
	var result = make(Ints, 0, len(i))
	for _, n := range i {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}

func (i Ints) Discard(predicate func(int) bool) Ints {
	return i.Keep(func(i int) bool {
		return !predicate(i)
	})
}

func (l Lists) Keep(predicate func(l []int) bool) Lists {
	if l == nil {
		return nil
	}
	var result = make(Lists, 0, len(l))
	for _, n := range l {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}

func (s Strings) Keep(predicate func(s string) bool) Strings {
	if s == nil {
		return nil
	}
	var result = make(Strings, 0, len(s))
	for _, n := range s {
		if predicate(n) {
			result = append(result, n)
		}
	}
	return result
}
