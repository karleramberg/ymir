package main

import (
	"image"
	"math/rand"
	"time"
)

type World struct {
	Grid [][][]float64
	Map  image.RGBA
	Name string
}

func newWorld(width, height int) (w *World) {
	w = new(World)
	w.Grid = make([][][]float64, width)
	for i := range w.Grid {
		w.Grid[i] = make([][]float64, height)
		for j := range w.Grid[i] {
			w.Grid[i][j] = make([]float64, 4)
		}
	}
	w.generate()
	w.updateMap(ELEVATION)
	w.updateName()
	return
}

func (w *World) generate() {
	rand.Seed(time.Now().UnixNano())
	for i := range w.Grid {
		for j := range w.Grid[i] {
			for k := range w.Grid[i][j] {
				w.Grid[i][j][k] += rand.Float64()
			}
		}
	}
}

func (w *World) updateName() {
	w.Name = "New World"
}