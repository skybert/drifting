# Will extract the documentation from BASH source:
#
#  ## This documents this function. It will return the ID of the
#  ## customer with the given name.
#  ## $1 :: the name
#  function get_id_by_name() {
/^## /,/^function/{
  s/^##[ ]*//
  p
}
