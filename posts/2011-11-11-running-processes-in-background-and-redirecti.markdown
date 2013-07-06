---
layout: post
title: "Running processes in background and redirecting to file"
date: 2011/11/11 12:15:00 -0800
comments: false
external-url:
categories:
---


When developing locally, I find it useful to have the full development server 
logs available. Luckily, Rails 3.1 does this for you in the file ./log/development.log. 
However, if you want something similar for other frameworks/commands that run 
continuously and post any errors, etc, directly to the terminal, something 
like this is useful:

[code]rails s >> console.out 2>&1 &[/code]

(Replace `rails s` with any similar command)

Also, you can easily send signals (like ctrl-c) to background processes with 
`kill`.

List of signals:

[code]kill -l[/code]

Closing a background process with id 1:

[code]kill -s SIGKILL %1[/code]

 



