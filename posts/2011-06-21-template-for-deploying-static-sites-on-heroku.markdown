---
layout: post
title: staticRack: Template for Deploying Static Sites on Heroku
date: 2011/06/21 21:20:00 -0700
comments: false
tags: webdev, projects
---


Have you ever looked for a way to quickly build a live prototype as a static 
site that nevertheless had some sensible version control and had potential 
for future extension? Well, I have a template (complete with very minimal HTML5 
boilerplate) for you [right here][1]! Read on for details.

After recently experimenting with CoffeeScript (and loving it), I felt the 
need to stage some code quickly somewhere. I already had my computer setup 
for deployment to Heroku so that was the obvious choice, and a quick search 
on the interwebz meant that my static sites could now run on Heroku easily. 
The upside was that I could add a lot of complexity to such a website down 
the road with minimal hassle. Basically, in the future I could build on it 
as a Rack-based app or use one of the many easy Ruby frameworks that are Rack-based 
(like Sinatra). Also, it would mean that I would use Git from the very start 
of the process, adding some much needed version control to the early stages 
of prototypes.

So, I basically extracted the basic code into a template, and even added a 
branch for Sass and Coffeescript enthusiasts to have a base to build on. I 
included some simple commands that free you up from the terminal so you can 
still have the familiar edit/refresh development cycle with the convenience 
of Coffee/Sass.

Here's the main branch: https://github.com/gnarmis/staticRack

Here's the sassycoffee branch: https://github.com/gnarmis/staticRack/tree/sassycoffee 

Clone the branch you want, customize, and push to Heroku. Enjoy!



[1]: https://github.com/gnarmis/staticRack
