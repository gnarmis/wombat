Title: Korma-Lobos-Tpl: Experimenting with persistence using Korma and Lobos
Date: 2012/07/03 20:47:00 -0700
Tags: clojure, projects


[Noir][1] is an excellent, Sinatra-like framework in Clojure, and
[Korma][2] is a great companion. But in a lot of database-backed
services, you often need migrations to make sane changes to the
database and have the abilitiy to roll back your various schema
changes. Lobos is a little library (among a few) that tries to do
this, but seeing only a few examples [here][3] and [there][4], I
decided to make my own little template that explores this.

So, here's the
repo: [http://github.com/gnarmis/korma-lobos-tpl](http://github.com/gnarmis/korma-lobos-tpl).

I did run into an issue trying to find out how to do the classic
"alter" SQL command to add a column using Lobos. Turns out, just try
`(doc alter)` after first typing in that first long `(use ...)`
command in the repo's readme. But I just documented the bug for now.

Also, there is a very simple entity definition to demonstrate Korma,
and I've tested the setup and confirmed that the migration executed,
and the entity got added.

I'll maybe explore Drift in the future, although there's already
[this excellent template][5] I could build on.



[1]: http://webnoir.org

[2]: http://sqlkorma.com

[3]: http://www.vijaykiran.com/2012/01/17/web-application-development-with-clojure-part-2/

[4]: http://pupeno.com/2011/08/20/how-to-use-lobos-with-heroku/

[5]: https://github.com/pjlegato/korma-drift-template
