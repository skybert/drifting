# convert header format, pre and postpend an empty line.
/^\.Ah/{
  s/\.Ah */\
@A HEAD = /
  s/"//g
  s/$/\
/
}
