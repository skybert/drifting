#! /usr/bin/env bash

# by torstein.k.johansen@gmail.com

function one() {
  local el="hello from one"
}

function manipulate_the_global_scope() {
  el="hello from manipulate_the_global_scope"
}

function functions_bleed_variables() {
  local el="hello from functions_bleed_variables"
  manipulate_the_global_scope
  echo el=$el
}

el='hello from global'
one
echo $el

manipulate_the_global_scope
echo $el

functions_bleed_variables
