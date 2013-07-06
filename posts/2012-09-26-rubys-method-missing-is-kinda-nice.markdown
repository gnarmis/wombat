---
layout: post
title: "Ruby's `method_missing` is cool / hashes as functions of their keys"
date: 2012-09-26 11:59
comments: true
categories: ruby
---

I had an idea to try and bring a tiny bit of Clojure's ideas of hash-maps to Ruby's hashes. I came up with a simple monkey-patch that allows you to truly use hashes as functions of their keys. In the process, I've come to really dig `method_missing`, although debugging it can be a chore. Word of advice: always implement `respond_to?` with your `method_missing`. Principle of Least Surprise, people.

{% gist 3789174 functional_hash.rb %}