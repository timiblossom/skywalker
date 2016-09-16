package main

import "flag"
import "fmt"
import "math/rand"
import "time"
import "sort"


type BySize []int
func (a BySize) Len() int           { return len(a) }
func (a BySize) Less(i, j int) bool { return a[i] < a[j] }
func (a BySize) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }


func main() {
  numBin := flag.Int("numBin", 1, "number of bins")
  binCapacity := flag.Int("binCapacity", 10, "bin capacity")  
  numItems := flag.Int("numItems", 10, "number of items")
 
  flag.Parse() 
  rand.Seed(time.Now().UTC().UnixNano())

  fmt.Println("Number of bins", *numBin)  
  fmt.Println("Bin capacity", *binCapacity)

  items := make([]int, *numItems)
  
  fmt.Print("Items: ")
  for i:=0; i<len(items); i++ {
    items[i] = rand.Intn(*binCapacity - 1) + 1
    fmt.Print(" ")
    fmt.Print(items[i])   
  }
  fmt.Println()

  //sort.Sort(BySize(items))
  //fmt.Println(items)

  //first fit
  firstFitBins, method := firstFit(items, *binCapacity, *numBin)
  fmt.Println(method, firstFitBins)

  //best fit
  bestFitBins, method := bestFit(items, *binCapacity, *numBin)
  fmt.Println(method, bestFitBins)
}

func firstFit(items []int, binCapacity int, numBin int) ([]int, string) {
  bins := make([]int, numBin)
  for i:=0; i<numBin; i++  {
    bins[i] = binCapacity
  }

  for i:=0; i<len(items); i++ {
     item := items[i]
     isSearching := true
     for binIndex:=0; isSearching && binIndex < len(bins); binIndex++ {
         if bins[binIndex] >= item {
            bins[binIndex] -= item
            isSearching = false
         }
     }

     if isSearching {
       //add a new bin
       bins = append(bins, binCapacity)
       i -= 1
     }
  }
  
  return bins, "First-fit" 
}


func bestFit(items []int, binCapacity int, numBin int) ([]int, string) {
  bins := make([]int, numBin)
  for i:=0; i<numBin; i++  {
    bins[i] = binCapacity
  }

  for i:=0; i<len(items); i++ {
     sort.Sort(BySize(bins))
     item := items[i]
     isSearching := true
     for binIndex := 0; isSearching && binIndex < len(bins); binIndex++ {
         if bins[binIndex] >= item {
            bins[binIndex] -= item
            isSearching = false
         }
     }
    
     if isSearching {
       //add a new bin
       bins = append(bins, binCapacity)
       i -= 1
     }
  }
  
  return bins, "Best-fit"
}


