#!/bin/sh

OutDir="output/"

java \
 -jar    "lib/invar-1.0.1.jar" \
 -rule   "res/example/rule/" \
 -xsd    $OutDir."xsd/" \
 -cpp    $OutDir."cpp/" \
 -java   $OutDir."java/" \
 -csharp $OutDir."csharp/" \
 -php    $OutDir."php/" \
 -flash  $OutDir."flash/" \

exit 0
