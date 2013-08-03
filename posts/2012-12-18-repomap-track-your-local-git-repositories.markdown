---
layout: post
title: RepoMap: track your local git repositories
date: 2012-12-18 16:09
tags: ruby, projects
---

Github link: [RepoMap](http://github.com/gnarmis/repomap)

There are hundreds of git repositories stored at various folder depths
all over my computer. Organizing them, remembering where they are or
determining whether I still have a working copy cloned from a remote
repository is a chore.

So, why not have a map of where all my repositories are? Should be
simple enough to keep a YAML file with a map from paths to repository
names.

After some hacking on a flight (after having finished finals and an
interview), I made a little Ruby CLI program and found it to be useful
enough to expand into a tiny little gem. It's still very basic, and
specs aren't where they should be, but the essentials are there.

It's called RepoMap, and you can find it here:
[http://github.com/gnarmis/repomap](http://github.com/gnarmis/repomap).

You can also install it by typing `gem install repomap`.

Check out the above link for details about how it works. Pull requests
are welcome! I'm thinking there's a number of cool additions possible,
such as mining all that useful meta data about git repositories, and
making use of the map in interesting ways.
