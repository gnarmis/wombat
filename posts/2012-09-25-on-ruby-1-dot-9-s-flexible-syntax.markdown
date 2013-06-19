---
layout: post
title: "On Ruby 1.9's Flexible Syntax"
date: 2012-09-25 13:57
comments: true
categories: ruby
---

Over the past day or so, I've been playing around with small bits of Ruby after spending most of the summer in Clojure-land. There's great similarities in both Ruby and Clojure (functional style, dynamic, etc), and both are very practical choices. Clojure gives you amazing access to JVM land while not forcing you to pull your hair out, and Ruby grants you a good selection of libraries and amazing tools for web development.

But here I want to highlight a few experiments I did to try and brighten up my Ruby-writing experience. The things here could be unneccessarily divergent, but what the hell. It made me realize you can bend Ruby in a lot of ways I hadn't thought of before

## define methods on the fly

```ruby
def defn name, &b
  Object.send :define_method, name, &b
end
```

`:define_method` is an amazing little method that allows you define methods (on any object too, so you could define class/module methods). That's all there is to it. Now you can do this:

```ruby
defn(:a) {|x, *y| print x; print y}
# and if you want to superficially lispy
(defn (:a) {|x, *y| print x; print y})

(a 1, 2, 3, 4) #-> 1[2,3,4]

# for multiline methods, this seems easier:
defn (:sum_of_squares) do |x, y| 
  x*x + y*y
end
```

This also works for associating any name with any kind of lambda.

```ruby
(defn (:foo) {23})
foo == 23 #=> true
```

## let / with

In Lispy languages, there's something like a function called `let` which lets you define some names in a new lexical scope and operate with them. An example in Clojure:

```clojure
(let [x 1] x) ;-> 1
x ;-> error, x is not defined outside the above form
```

In Ruby, we have something kind of like that called `#tap`, which Zach Hobson covered [here](http://www.opensourcery.com/blog/zack-hobson/objectlet-ruby-0). He suggested a simple way to define `#let`:

```ruby
class Object
  def let
    yield self
  end
end

# Now you can do this:

((2).let {|x| puts x+1}) == 3 #=> true
```

But I think an even more beautiful way to do it is like this:

```ruby
def with coll, &b
 coll.map &b
end

with [[1,2]] {|x,y| puts x+y} #=> 3
```

For more on destructuring and everything's that's possible there, check out [this post](http://po-ru.com/diary/destructuring-assignment-in-ruby/).

## map, reduce, filter, pipe, call, body

There's a lot more craziness to explore. I'll let the code, comments, and examples from my [gist](https://gist.github.com/3760519) explain. This is just bits of code here and there, honestly. [Tweet at me](http://twitter.com/gnarmis) to discuss! Also, the [gist](https://gist.github.com/3760519) will be the most up-to-date version of this.

```ruby
# execute an array of lambdas one after another?

def body *args
  args.each {|e| e.call}
end

(body (lambda {print 1}), (lambda {print 2})) #=> output: 12

# map as a "top-level" function. This maps some lambda to an array, 
# passing each element to the lambda to call.
# (also, who doesn't like stabby lambdas?)

def map fun, coll
  coll.to_a.collect {|i| fun.call(i)}
end

(map ->(x){x+1}, [1,2,3]) #=> [2, 3, 4]

# reduce as a "top-level" function

def reduce fun, val=nil, coll
  return coll.to_a.reduce(fun.to_sym) unless val
  return coll.to_a.reduce(val) {|sum, i| sum.send fun.to_sym, i} if val
end

(reduce :+, [1,2,3]) #=> 6
(reduce :+, 3, [1,2,3]) #=> 9


# piping a single input through a bunch of functions
# (yay, composable functions!)

def pipe args, *methods
 methods.reduce(args) { |a, m| send(m, a) }
end

def foo(data)
  data[:a] += 1
  data
end

def bar(data)
  data[:b] += 10
  data
end

hash = {:a => 0, :b => 0}
(pipe hash, :foo, :bar) #=> {:a=>1, :b=>10}

# good old filter is also pretty easy to define

def filter pred, coll
  coll.to_a.select &pred
end

(filter ->(x){x.even?}, [1,2,3]) == [2] #=> true

# a function to call a lambda (forcing it to execute)

def call b; b.call; end

saved = lambda {puts "did I get called?"}
#=> #<Proc:blahblahblah (lambda)>

(call (lambda {puts "I got called!"; reduce :+, [1,2,3]})) 
#=> output: I got called!\n => 6
```


