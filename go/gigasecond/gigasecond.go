// Package gigasecond provides a worldview of gigaseconds.
package gigasecond

// import path for the time package from the standard library
import "time"

// AddGigasecond takes a Time and returns a Time with a gigasecond added to it.
func AddGigasecond(t time.Time) time.Time {
	return t.Add(gigasecond)
}

const gigasecond time.Duration = 1000000000000000000
