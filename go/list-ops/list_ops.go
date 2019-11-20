package listops

type ListOps interface {
	Append(IntList) IntList
	Concat([]IntList) IntList
	Foldl(binFunc, int) int
	Foldr(binFunc, int) int
	Filter(predFunc) IntList
	Length() int
	Map(unaryFunc) IntList
	Reverse() IntList
}

type IntList []int
type binFunc func(int, int) int
type predFunc func(int) bool
type unaryFunc func(int) int

func (IntList) Append(list IntList) IntList {
	return []int{}
}

func (IntList) Concat(lists []IntList) IntList {
	return []int{}
}

func (IntList) Foldl(binFunc2 binFunc, initial int) int {
	return 0
}

func (IntList) Foldr(binFunc2 binFunc, initial int) int {
	return 0
}

func (IntList) Filter(predicate predFunc) IntList {
	return []int{}
}

func (IntList) Length() (length int) {
	return
}

func (IntList) Map(unaryFunc2 unaryFunc) IntList {
	return []int{}
}

func (IntList) Reverse() IntList {
	return []int{}
}
