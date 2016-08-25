#!/bin/sh

DirOut="example/out/"
DirIn="example/rule/"

java \
 -cp      ".:lib/*" \
 invar.Invar \
 -snippet "custom/" \
 -rule    ${DirIn} \
 -xsd     ${DirOut}"xsd/" \
 -cpp     ${DirOut}"cpp/" \
 -java    ${DirOut}"java/" \
 -csharp  ${DirOut}"csharp/" \
 -python  ${DirOut}"python/" \
 -php     ${DirOut}"php/" \
 -flash   ${DirOut}"flash/" \

exit 0
