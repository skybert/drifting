package main

import (
  "fmt"
  "strings"
  "time"
)

const (
  max_age = 10
)

func now() {
  fmt.Printf("\n%v", time.Now())
}

func main() {
  // var str string =  "hello world";
  str := "hello"
  str += " world"
  n := len(str)

  _, err := fmt.Printf("Length of %s is %d\n", str, n)

  if err != nil {
    fmt.Printf(":-( %v\n", err)
  }

  // declare and assigne multiple values
  a, b := 2, "three"
  fmt.Printf("%d %s\n", a, b)

  switch {
  case a == 2:
    fmt.Printf("2 is two!")
  case a > 1:
    // no fall through
    fmt.Printf("2 greater than 1!")
  default:
    return
  }

  // loops
  for i := 0; i < 10; i++ {
    fmt.Printf("%d ", i)
  }

  // while loop
  j := 0
  for j < 5 {
    fmt.Printf("%d ", j)
    j++
  }

  // slice
  pi := []int{3, 1, 4, 1, 5}

  first := pi[0:3]

  // pass by val
  wee(pi[0:3])

  fmt.Printf("\n%v ", pi[0:4])

  // first is just a pointer, here's the proof
  pi[0] = 5
  fmt.Printf("\n%v ", first)

  copySlice()
  testStrings()
  testMap()
  testUnicode()
}

func testUnicode() {
  s := "👻"
  b := []byte(s)
  for i, v := range b {
    fmt.Printf("\nByte #d=%d is=%v", i, v)
  }

}

func testMap() {
  m := make(map[string]int)
  m["Jan"] = 1
  m["Feb"] = 2

  for i, v := range m {
    fmt.Printf("\ni=%s v=%d ", i, v)
  }

  _, ok := m["not there"]
  fmt.Printf("\nNon existant=%v ", ok)

  now()
}

func testStrings() {
  s := "hello"

  fmt.Println("\n" + strings.ToUpper(s))
}

func copySlice() {
  pi := []int{3, 1, 4, 1, 5}
  newpi := append(pi, 200)

  fmt.Printf("\nold %v new %v \n", len(pi), len(newpi))

  for i, v := range pi {
    fmt.Printf("i=%d n=%d ", i, v)
  }
}

// Parameter is passed by reference
func wee(s []int) {
  s[0] = 13
  fmt.Printf("\ninside wee %v ", s)
}
