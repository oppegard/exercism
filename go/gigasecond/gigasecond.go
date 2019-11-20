// Package gigasecond provides a worldview of gigaseconds.
package gigasecond

import "time"

const gigasecond time.Duration = 1e9 * time.Second

// AddGigasecond takes a Time and returns a Time with a gigasecond added to it.
func AddGigasecond(t time.Time) time.Time {
	return t.Add(gigasecond)
}
