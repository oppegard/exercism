// Package space implements space-age calculations!
package space

const secondsInEarthOrbitalPeriod = 31557600

// Planet is one of the planets in the Solar System
type Planet string

var orbitalPeriodsRelativeToEarth = map[Planet]float64{
	"Mercury": 0.2408467,
	"Venus":   0.61519726,
	"Earth":   1.0,
	"Mars":    1.8808158,
	"Jupiter": 11.862615,
	"Saturn":  29.447498,
	"Uranus":  84.016846,
	"Neptune": 164.79132,
}

// Age calculates age in years on a given planet's orbital period
func Age(ageInSeconds float64, planet Planet) float64 {
	return ageInSeconds / (orbitalPeriodsRelativeToEarth[planet] * secondsInEarthOrbitalPeriod)
}
