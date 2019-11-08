// Package twofer has one for you and me!
package twofer

import "fmt"

func ShareWith(name string) string {
	if len(name) == 0 {
		name = "you"
	}
	return fmt.Sprintf("One for %s, one for me.", name)
}
