package main

import (
  "fmt"
  "net/http"
  "time"
  // "months"
)

func worker(c chan string) {
  for url := range c {
    start := time.Now()
    resp, err := http.Get(url)
    if err != nil {
      fmt.Printf("err %s\n", err)
    }
    fmt.Printf("got it %v in %v", resp, start)
  }
}

func main() {
  c := make(chan string)
  for i := 0; i < 10; i++ {
    fmt.Printf("Creating working #%d\n", i)
    go worker(c)
  }

  urls := []string{"http://vg.no", "http://google.com"}

  for _, url := range urls {
    fmt.Printf("url %s\n", url)
    c <- url
  }

  close(c)

}

// type Month struct {
//   name  string
//   count int
// }

// func newMonth(name string, count int) *Month {
//   m := new(Month)
//   m.name = name
//   m.count = count
//   return m
// }

// func (m *Month) setName(name string) {
//   m.name = name
// }

// func (m *Month) getName() string {
//   return m.name
// }

// func main2() {
//   name := "world"
//   fmt.Printf("hello %s ", name)

//   m := newMonth("Dec", 12)
//   fmt.Printf("hello %v\n", m)

//   m.setName("Jan")
//   fmt.Printf("hello %v ", m)

//   m.setName("Feb")
//   fmt.Printf("hello %v ", m.getName())
//   // could also do
//   fmt.Printf("hello %v ", m.name)
// }

// func counter(c chan int) {
//   for i := 0; i < 10; i++ {
//     c <- i
//   }
//   close(c)
// }

// func reader(c chan int) {
//   for i := range c {
//     time.Sleep(1 * time.Second)
//     fmt.Printf("%d ", i)
//   }
// }

// func main() {
//   c := make(chan int)
//   for i := 0; i < 1000; i++ {
//     go counter(c)
//   }
//   // for i := range c {
//   //   time.Sleep(1 * time.Second)
//   //   fmt.Printf("%d ", i)
//   // }
//   go reader(c)

// }

// func TestThis(t *testing.T) {
//   i := 1

//   if i == 1 {
//     t.Fatalf("eek")
//   }

// }
