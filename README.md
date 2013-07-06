# Wombat

Yet another static blog generator, in the spirit of Jekyll, Hakyll,
etc, with Markdown post creation,
[Hiccup](https://github.com/weavejester/hiccup)
powered HTML rendering, and
[garden](https://github.com/noprompt/garden)
powered styling.

## Goals

- A clean and text-focused design.
- As completely Clojure-ified as possible.
- Don't overengineer!
  
## Motivation

**Clojure for most things**

A static website is one where all the relevant assets are available
without computation, meaning the HTML, CSS, and JavaScript are all
rendered into files, and any other media is also similarly available.
But I don't want to deal with these separate and restrictive
languages. Clojure and ClojureScript have a well designed set of data
structures and core functions, and a pleasant literal syntax as well.
So, let's use Clojure for representing as much of the data as
possible! This affords us all of the great interfaces and powers that
Clojure provides.

**Markdown only for content**

However, for natural language, Markdown is a better choice. There's
little need for the affordances of a computation friendly format. This
suggests that Markdown be used for content production, and that
content be separated from presentation. Additional, using the
conventional YAML front matter format for meta information is a good
option, or we could literally put a Clojure form up at the top.
Perhaps it'll be better to just pick Pandoc's style of doing meta tags.

**Rendering**

We also have intermediate steps between content and presentation and
the actual HTML, CSS, and JavaScript files. All of them together can
be called 'rendering.' This collection of steps is just a function
that takes certain file names and strings to be written, and outputs
those strings to those files.

**Node-based, data-oriented approach**

A document based approach, which a static website ends up having,
involves thinking in terms of discrete HTML pages. However, many pages
end up sharing similar content, styling, and functionality. As such,
there is a big need for reusable 'templates,' which are really just
forms with substitutable symbols (`defn` or `def` for binding
different content to symbols and Clojure's own symbol resolution
takes care of this).


Also, it might be good idea to combine styling and content into the
same data structure. Consider a page with the following division:

```html
<div class="box">
    I'm a box!
</div>
```


If we style this box, those CSS rules would normally go in a separate
file and separate context. Here's an example:

```css
.box { color: red; }
```


The shared reference in the HTML and the CSS is the class `box`.
However, imagine a combined data structure which represents all of the
above data:

```clojure
{:content [:div.box "I'm a box"]
 :style   [:.box {:color "red"}]}
```

This representation uses Hiccup for the HTML and Garden for the CSS.
What we have is a valid Clojure map which entirely represents the box
we set out to define. To compute this simply requires passing the
respective things to the macros defined in Hiccup and Garden.


Some advantages of this approach:

- Useful for defining the overall look and structure of a DOM node all
  at once.
- Can be used as a data-structure to define a template more completely.
  It's not something like just handlebars, it's full Clojure and it
  also defines styles.
- Easy to read (and manipulate) everything about a template. No need
  to jump files or semantic contexts (everything is in Clojure).
- Able to reduce the scope of construction to a much smaller unit.


Building on that last advantage (reducing scope from a file or large
template to even a single DOM node), it would be nice to be able to
reference other such nodes inside a specific node. In other words,
it'd be nice to make these nodes nestable. One way is to use plain
symbols and define them beforehand using `def`. An example is:

```clojure
(def red-box
    {:content [:div.box "I'm a box"]
     :style   [:.box {:color "red"}]})
(def body
    {:content [:body red-box]
     :style   [:p {:color "blue"}]})
```


Then, we get an overall map which has all the information needed for
compilation into the body tag of some HTML page.

There's not much need for special records given such a format, but
perhaps one will suggest itself. Another thing to consider would be
ClojureScript as another key in this data structure, to define
node-specific behavior.

I could imagine being able to arbitrarily mix, match and compose such
small units of functionality. I could also imagine compiling them such
that there is a separate styles file to include, and a separate
javascript file, or I could see having inline style and script tags.
Imagine being able to define a library of functions and having
object-specific behavior attached to the object's data structure. At
any point, you would have access to a node's content, style and
behavior.


As such, this method of organization seems compelling enough to explore.

**A different take...**

Actually, we don't need to define the above data structure. We could
simply use Hiccup all the way, and sprinkle in the `style` tag with
the appopriate CSS at the beginning of the given node. So, this
approach would only involve be a sort of convention of organization.
Maybe we could extract common functionality into a macro.

An example of this is provided in the commit in which this text was
added.

## Usage

FIXME

## License

Copyright © 2013 Gursimran Singh

Distributed under the Eclipse Public License, the same as Clojure.
