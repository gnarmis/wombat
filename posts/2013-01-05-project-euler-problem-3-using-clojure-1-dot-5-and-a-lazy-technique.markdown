---
layout: post
title: Project Euler Problem 3 using Clojure 1.5 and a lazy technique
date: 2013-01-05 12:36
tags: clojure, euler
---

The problem: find the largest prime factor of 600851475143.

I used the Sieve of Eratosthenes and Ruby to solve it
[last time](http://kilotau.com/blog/2011/06/28/primes-and-sieves/).

This time, I tried a lazy, functional approach. The result was an
efficient, straightfoward solution that involved no sieve or any
static/full-realized data structure at all! I make a recipe for the
kind of numbers I want and then take just as many as I need in order
to finally output the answer.

Here's my lazy, functional implementation using Clojure 1.5 RC1
(mostly because I wanted to play with the new reducers library). It's
pretty efficient: less than a quarter of a second on my 2011 13" base
MBP!

```clojure
(ns euler.three
 (require [clojure.core.reducers :as r]))

(declare largest-prime-factor-for)
(declare factors-of)
(declare source-factors)
(declare source-naturals)
(declare factor?)
(declare prime?)
(declare certainty)

(defn answer []
  (time (largest-prime-factor-for 600851475143)))

(defn largest-prime-factor-for [n]
  (let [prime-factors (r/filter prime?
                                (factors-of n))]
    (last (into [] prime-factors))))

(defn factors-of [n]
  (r/filter #(factor? n %)
            (source-factors n)))

(defn source-factors [n]
  (r/take-while #(< % (int (Math/sqrt n)))
                (source-naturals)))

(defn source-naturals []
  (r/map #(+ % 2) (range)))

(defn factor? [n possib]
  (zero? (mod n possib)))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) certainty))

(def certainty 10)
```
