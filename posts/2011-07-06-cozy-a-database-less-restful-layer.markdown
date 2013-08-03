---
layout: post
title: Cozy: a Database-less RESTful Layer
date: 2011/07/06 16:35:00 -0700
comments: false
tags: ruby, projects
---


After exploring some static site recipes in my [staticRack][1] project, I wanted 
to explore the world of simple, static Content Management Systems. There is 
a PHP implementation of that sort of idea in [Pulse CMS][2], and Ruby has something 
a bit different called [Nesta][3]. The latter, in particular, is a great solution 
if you love managing static sites with a desktop text editor and want a simple 
way to customize or build completely new designs. I decided to explore a custom 
CMS based on Sinatra to learn building apps with Rack and Sinatra.

The idea was to have a general-purpose layer that can be easily deployed using 
pretty much any web server and that allows flexible management and development 
of content. Imagine a RESTful API that abstracts away the messy local filesystem 
and lets you create objects that are stored as static files. If you're working 
on a simple JavaScript client and want local filesystem access, such a layer 
would be immensely helpful. There is also some separation of concerns between 
the client and server and the whole thing starts looking like a general mini-framework 
that can be used to target a wide range of problems. Also, after initial deployment, 
such a project could allow continued development through a REST client on any 
browser or even mobile device. And with the possibility of [standalone deployment 
with Passenger][4] and even simpler deployment with [Heroku][5], such a project 
can actually have widespread, general use.

I worked out some initial functionality and pushed it [here][6]. I'm calling 
it **Cozy**, and hopefully it evolves into a good way to make basic prototypes, 
to have database-less dynamic web apps, or to manage static websites. For now, 
Cozy can create, read, update, and delete "nodes," which can be any kind of 
file. There is also some authentication to protect the create, update, and 
delete actions. The code is a little brittle right now, but you get the idea. 

While the true capabilities and drawbacks are not clear yet, this idea of a 
static REST backend is turning out to be a great educational project. If anything, 
it can help inform a future attempt to create a light framework. In the meantime, 
I'm absolutely loving Sinatra's simplicity and will have some followups exploring 
the specifics of Cozy.

Cheers!


[1]: https://github.com/gnarmis/staticRack

[2]: http://pulsecms.com/

[3]: http://nestacms.com/

[4]: http://www.modrails.com/documentation/Users%20guide%20Standalone.html

[5]: http://www.heroku.com/

[6]: https://github.com/gnarmis/cozy
