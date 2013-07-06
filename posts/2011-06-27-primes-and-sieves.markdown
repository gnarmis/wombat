---
layout: post
title: "Primes and Sieves"
date: 2011/06/27 22:39:00 -0700
comments: false
external-url:
categories:
---


[Project Euler][1] is one of the best things I have discovered in a while. 
It's simply a huge open list of problems in numeric order that you can solve 
using any math or code you want, provided that any code you write runs under 
one minute.

The problems get interesting from the very start and are actually entertaining! 
After reading [Lokhart's Lament][2], I'd say these problems would definitely 
fit the category of challenging and yet stimulating. Math truly is an art, 
and code is a cool way to access a subset of it.

 

Anyway, primes! Here's the problem itself:

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

And here's my solution (skip if you want to try this yourself!):

The code should be pretty much clear, at least except for that initial part 
where I restrict the range. It was hard getting my super-easy-to-write-yet-inefficient 
prime numbered array generator to solve for 600851475143 quickly. I was too 
lazy to try to implement Sieve of Atkin so I just decided to try limiting the 
range as much as I could. Apparently, if you take the root of the number of 
digits in the given composite number, and then raise the upper limit of your 
range to the inverse of that number, you get a much more limited range that 
still gives you the right highest prime factor of the original number. I tried 
this out down to two-digit composites and it seems to work.

Also, if I tried using a quick prime test on each element and deleting non-primes 
that way (instead of a sieve), the performance was actually worse somehow. 
And while trying to do this exact thing, I discovered a freaking [regular expression 
that detects primes][3]! Yeah.

I literally spent close to three hours just researching a number of tangential 
topics, such as [Sieve of Eratothenes][4], [Sieve of Atkin][5], [Sieve theory][6], 
[GNFS][7], and [RSA][8]. While the problem itself wasn't too challenging (I 
ended up learning much more about Ruby, though), the whole experience was amazing. 
And of course, there's a lot of room for gains in efficiency too.

I highly recommend you sign up for an account on [Project Euler][1] and work 
your way through some of those problems! It's a great way to try out new languages, 
learn more efficient techniques, or just have some fun. No, really, it's actually 
fun.

 

 

 



[1]: http://projecteuler.net/
[2]: https://www.facebook.com/l.php?u=http%3A%2F%2Fwww.maa.org%2Fdevlin%2FLockhartsLament.pdf&h=dba0d
[3]: http://www.noulakaz.net/weblog/2007/03/18/a-regular-expression-to-check-for-prime-numbers/
[4]: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
[5]: http://en.wikipedia.org/wiki/Sieve_of_Atkin
[6]: http://en.wikipedia.org/wiki/Sieve_theory
[7]: http://en.wikipedia.org/wiki/GNFS
[8]: http://en.wikipedia.org/wiki/RSA