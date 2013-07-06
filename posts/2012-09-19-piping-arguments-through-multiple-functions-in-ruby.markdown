---
layout: post
title: "Piping Arguments Through Multiple Functions in Ruby"
date: 2012-09-19 16:25
comments: true
categories: [ruby, snippets]
---

After asking `#ruby` what the equivalent of Clojure's [-> macro](http://clojuredocs.org/clojure_core/clojure.core/-%3E) could look like, I compiled the collective solution into a gist. You might find this useful somewhere, especially when you have multiple transformation functions operating on the same basic data structures.

{% gist 3752271 piping_example.rb %}