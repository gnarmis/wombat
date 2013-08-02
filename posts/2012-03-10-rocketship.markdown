---
layout: post
title: "Rocketship: A Multi-App Sinatra Template"
date: 2012/03/10 18:07:00 -0800
comments: false
external-url:
categories: [ruby, webdev, devops, projects]
---


Introducing Rocketship: a Rack based template that integrates multiple micro-frameworks. 

[**github.com/gnarmis/rocketship**][1]

I recently came across some useful Sinatra templates and ended up having to 
integrate several things together in a service I'm currently working on. So, 
I extracted the basic stuff out and it's turned out to be useful for spinning 
up a quick web service. Best thing is that it doesn't impose a strict structure 
and you can follow best-practices of your micro-framework of choice.

Currently, Rocketship integrates Grape and Sinatra, along with a bevy of testing 
facilities.

Comments/improvements welcome!

Update: Some significant changes, including one that makes apps able to handle 
more requests concurrently.


[1]: https://github.com/gnarmis/rocketship
