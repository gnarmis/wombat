Title: Colby: Small Wrapper and Functions for Persistent, Immutable Data Structures
Date: 2013-01-11 17:52
Tags: projects, ruby

Today, I cleaned up an earlier project I'd left hanging around called
[Colby][1]. It's a little wrapper around the data structures that the
Hamster gem provides, and it adds some functions to make working with
those data structures a little similar to the Clojure-way.

At this point, Colby is very experimental and is only at a `0.0.1`
release to reflect its brittleness. However, all specs pass currently
and it's useable as-is. I've pushed the initial release to RubyGems,
so you can start using Colby by just doing `gem install colby`.

Comments welcome! I realize this may be a bit simple compared to
[rouge][2], which is an awesome project, but I'll keep this around for
my own edification.

[1]: http://github.com/gnarmis/colby

[2]: http://github.com/rouge-lang/rouge
