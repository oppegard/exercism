// Package leap provides functions regarding leap years.
package leap

// IsLeapYear answers whether a given year is a leap year.
func IsLeapYear(year int) bool {
	if year%400 == 0 {
		return true
	}

	if year%4 == 0 && year%100 != 0 {
		return true
	}

	return false
}
