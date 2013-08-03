---
layout: post
title: Some Steps Into Clojure Land
date: 2012/06/30 23:32:00 -0700
tags: clojure
---


I'm really digging this wonderful little language called Clojure. It's a modern 
Lisp, meaning it has all the functional goodness I have been craving after 
using Racket. It's awesome being able to build things like interpreters and 
type checkers, which I didn't think I'd be able to approach so easily (this 
was part of an awesome programming languages class taught by Robbie Findler). 
But Clojure is also a JVM language and can be compiled ahead of time, so it's 
exceedingly practical and efficient. You can use any Java library and interop 
with other JVM languages pretty well.

Clojure is a young language, but has a very energetic community. It's also 
seeing use both in industry and startups. Check out [this talk][1] for more 
on that.

There's a lot of resources out there too. I've gone through parts of [Clojure 
Programming][2], done some challenges on [4Clojure][3], played around
with [Light 
Table Playground][4], and keep finding more things to explore. One book I definitely 
want to explore is [The Joy of Clojure][5]. Also, I've decided to go through 
SICP using clojure, and ran across [this gem][6].

As for tools, I've tried [CounterClockwise][7] and [La Clojure][8], but for 
now I've settled for my usual lightweight editor: Sublime Text 2, with SublimeREPL. 
Having a syntax-highlighted REPL that behaves like my editor is pretty
nice. [Leiningen][9] has 
been brilliant as a dependency-management tool, which also supports a host 
of other things like building, testing, running, or launching a REPL with your 
project. Honestly, Leiningen is the best dependency manager I've ever used. 
I wish there was something this good in Ruby-land.

A great place to find links to all sorts of tools for Clojure
development is [Clojure 
Toolbox][10]. It shows how practical Clojure is today.

I have to mention [Noir][11] and [Korma][12]. If you're into web dev, you might 
find yourself loving the simplicity of Noir and the interesting functional 
approach to persistence in Korma. I find it awesome that [Chris Granger][13], 
the guy behind Light Table, wrote both of them.

Btw, #clojure on irc.freenode.net is friendly!


[1]: http://www.infoq.com/presentations/Clojure-powered-Startups

[2]: http://www.clojurebook.com/

[3]: http://www.4clojure.com/

[4]: http://www.chris-granger.com/2012/06/24/its-playtime/

[5]: http://joyofclojure.com/

[6]: http://sicpinclojure.com/

[7]: http://code.google.com/p/counterclockwise/

[8]: http://devnet.jetbrains.net/community/idea/clojure

[9]: https://github.com/technomancy/leiningen/

[10]: http://www.clojure-toolbox.com/

[11]: http://webnoir.org/

[12]: http://sqlkorma.com/

[13]: http://chris-granger.com/
