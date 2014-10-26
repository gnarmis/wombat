Title: Piping Arguments Through Multiple Functions in Ruby
Date: 2012-09-19 16:25
Tags: ruby, snippets

After asking `#ruby` what the equivalent of Clojure's
[-> macro](http://clojuredocs.org/clojure_core/clojure.core/-%3E)
could look like, I compiled the collective solution into a gist. You
might find this useful somewhere, especially when you have multiple
transformation functions operating on the same basic data structures.


    # piping example in Ruby

    def foo(data)
      data[:a] += 1
      data
    end

    def bar(data)
      data[:b] += 10
      data
    end

    def pipe args, *methods
     methods.reduce(args) { |a, m| send(m, a) }
    end

    hash = {:a => 0, :b => 0}
    pipe hash, :foo, :bar
    #=> {:a=>1, :b=>10}

