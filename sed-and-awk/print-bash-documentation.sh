#! /usr/bin/env bash

# by torstein.k.johansen@gmail.com

file=/tmp/$(basename $0).org
echo '*' BASH functions in $(dirname $1 | sed "s#${HOME}/##") > $file
for el in $@; do
  echo '**' "Functions in" $(basename $el) >> $file
  sed -n -e "/^###/,/^function/{
/^function/!s/_/\\\_/g

/^###/{
  s/###/***/
}

s/^##[ ]*//
s/^\([$][1-9@n]\) \(.*\)$/- \1 \2/
s/^function \(.*\)().*/#+BEGIN_SRC text\n\1\n#+END_SRC/
p
}" $el >> $file
  echo "created doc of $el in $file"

done

  # s/^\([$][1-9]\) \(.*\)$/- \1 :: \2/
  # s/^function \(.*\)()[ ]*{/<h2>${el%.sh}::\1<\/h2>\n/
  # /^$/,/<li>/s/<li>/<ul><li>/
  # /<\li>/,/<h2>/s/<\/li>/<\/li><\/ul>/
  # /^[a-z]*/,/<ul>/
