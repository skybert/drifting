# delete empty lines after a confluence h1 (troff uses .H1)
/^\.h1/{
  n
  /^$/d
}
