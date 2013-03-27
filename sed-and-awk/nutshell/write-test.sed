#! write everyone who lives in the same country to the same file
/Norway$/{
  s///
  s/[,]//
  w norway.list
}

/Scotland$/{
  s///
  w scotland scotland.list
}
