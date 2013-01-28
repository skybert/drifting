# SED scrip which finds everything inside ='s and escapes all
# underscore inside them. Once done, it replaces the ='s with *'s

/=.*=/{
   s/_/\\_/g
   s/=/*/g
}
