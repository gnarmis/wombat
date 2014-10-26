Title: Ruby's `method_missing` is cool / hashes as functions of their keys
Date: 2012-09-26 11:59
Tags: ruby

I had an idea to try and bring a tiny bit of Clojure's ideas of hash-maps to Ruby's hashes. I came up with a simple monkey-patch that allows you to truly use hashes as functions of their keys. In the process, I've come to really dig `method_missing`, although debugging it can be a chore. Word of advice: always implement `respond_to?` with your `method_missing`. Principle of Least Surprise, people.


    # In Clojure, hash-maps are truly functions of keys to values.
    # So you can do `(:a {:a 1})` and get `1` as the result
    # Why not put this in Ruby?

    # access keys of a hash like a function

    class Object
      def respond_to?(method)
        if (method.to_s =~ /^_.*/) == 0
          true
        else
          super
        end
      end
      def method_missing(name, *args, &b)
        if (args.count==1) && b.nil? && name[0]=="_" &&
           args[0].has_key?(name[1..-1].to_sym)
          args[0][name[1..-1].to_sym]
        else
          super
        end
      end
    end


    hash = {:a => 1}
    (_a hash) == 1 #=> true
    (_a hash) == (hash [:a]) #=> true

    # the underscore serves to prevent naming conflicts to a degree

