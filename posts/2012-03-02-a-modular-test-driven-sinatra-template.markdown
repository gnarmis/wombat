---
layout: post
title: "A modular, test-driven Sinatra template"
date: 2012/03/02 17:28:00 -0800
comments: false
external-url:
categories: [ruby, webdev, projects]
---


I recently found a (somewhat old) but great repository: https://github.com/daddz/sinatra-rspec-bundler-template. 
The structure really helps you build modular Sinatra apps and has the basics 
needed for you to jump in and start building.

However, after discovering the joys of the [SimpleCov][1] gem, which generates 
code coverage reports in HTML, I wanted to tweak this already-awesome repository. 
Also, I wanted a few more Rake tasks to help with everyday development.

So, [here's my fork][2] with some improvements.

To begin, just define your own app like the one defined in lib/foo.rb. You 
can create multiple such apps and route requests to each one separately. To 
do that, just add those mappings to config.ru (foo and bar have been configured 
in this manner).

This template also uses Bundler to manage its dependencies, so if you need 
a new gem just add it to the Gemfile and run `bundle install`. I also recommend 
using RVM to manage your gems (create a new gemset for each app).

Also, use RSpec to test your app, and run the specs with the defined Rake tasks. 
Run `rake` or `rake help` to see available tasks. Run `rake spec` to run your 
specs defined under spec/.

You can generate code coverage reports by running `rake coverage`.

You can also run a console with your app's environment by running `rake console`. 

So, there you have it: a simple template with enough structure to support your 
Sinatra development.



[1]: https://www.ruby-toolbox.com/projects/simplecov
[2]: https://github.com/gnarmis/sinatra-rspec-bundler-template
