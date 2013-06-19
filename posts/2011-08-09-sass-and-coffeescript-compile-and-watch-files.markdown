---
layout: post
title: "Sass and CoffeeScript - Compile and Watch Files with One Command"
date: 2011/08/09 14:30:00 -0700
comments: false
external-url:
categories:
---


Do you use Sass and CoffeeScript? Tired of remembering and typing out the compile 
and watch commands on both of those command-line utilities? I used to do:

  
[code] compass watch   
 coffee -o scripts/ -cw coffee/ [/code]

...on all of my projects, in separate tabs on the terminal. There had to be 
an easier way.

Do them both, with the standard configuration, using the script below. Download 
it into your project, do

[code]chmod +x sassycoffee.sh[/code]

to make it executable, and forget about it! I'm planning on some edits in the 
future, but it works well enough and gets the job done. Now, all you need to 
do is:

[code]./sassycoffee.sh[/code]

This was a quick little hack in bash but pretty helpful for my workflow.

Tips? Improvements? I'd be glad to hear 'em.



