// Package listops provides basic list operations.
package listops

// IntList is a slice of integers, upon which list operations can be performed.
type IntList []int
type binFunc func(int, int) int
type predFunc func(int) bool
type unaryFunc func(int) int

// Append is given two lists, adding all items in the second list to the end of the first list.
func (i IntList) Append(list IntList) (newList IntList) {
	iLen := i.Length()
	newListSize := iLen + list.Length()
	newList = make(IntList, newListSize, newListSize)

	for n, item := range i {
		newList[n] = item
	}

	for n, item := range list {
		newList[iLen+n] = item
	}
	return
}

// Concat is given a series of lists, combining all items in all lists into one flattened list.
func (i IntList) Concat(lists []IntList) IntList {
	for _, list := range lists {
		i = i.Append(list)
	}
	return i
}

// Foldl is given a function, a list, and initial accumulator, which then folds (reduces) each item into the accumulator from the left using `function(accumulator, item)`.
func (i IntList) Foldl(binFunction binFunc, acc int) int {
	for _, e := range i {
		acc = binFunction(acc, e)
	}
	return acc
}

// Foldr is given a function, a list, and an initial accumulator, which then folds (reduces) each item into the accumulator from the right using `function(item, accumulator)`.
func (i IntList) Foldr(binFunction binFunc, acc int) int {
	for _, item := range i.Reverse() {
		acc = binFunction(item, acc)
	}
	return acc
}

// Filter is given a predicate and a list, returning the list of all items for which `predicate(item)` is True.
func (i IntList) Filter(predicate predFunc) IntList {
	filtered := make(IntList, 0)
	for _, item := range i {
		if predicate(item) {
			filtered = filtered.Append(IntList{item})
		}
	}
	return filtered
}

// Length is given a list, returning the total number of items within it.
func (i IntList) Length() (length int) {
	for range i {
		length++
	}
	return
}

// Map is given a function and a list, returning the list of the results of applying `function(item)` on all items.
func (i IntList) Map(unaryFunction unaryFunc) IntList {
	mapped := make(IntList, i.Length(), i.Length())
	for n, item := range i {
		mapped[n] = unaryFunction(item)
	}
	return mapped
}

// Reverse is given a list, and returns a list with all the original items, but in reversed order.
func (i IntList) Reverse() IntList {
	iLen := i.Length()
	reversed := make(IntList, iLen, iLen)
	for n, item := range i {
		reversed[iLen-1-n] = item
	}
	return reversed
}
