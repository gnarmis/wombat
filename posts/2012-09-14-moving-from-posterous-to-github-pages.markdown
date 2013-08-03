---
layout: post
title: Moving From Posterous to Github Pages
date: 2012-09-14 02:27
tags: updates
---

Ever since Posterous was acquired by Twitter, I'd been meaning to
ditch the service for something better. While it was convenient to
post by email and enjoyable to forget about hosting, I missed
controlling the structure of my raw posts and the site's design.

So when I discovered [Octopress](http://octopress.org), I was quickly
won over. Finally, a hacker's workflow: compose post in Markdown,
generate static content, push content to Github Pages. And since all
posts are in Markdown, you truly have portable, human-readable
content!

Once I had a repository on Github setup with my Octopress-powered
blog, I needed to import posts from Posterous. Unfortunately, it
wasn't a straightforward process, but I decided to automate away the
drudgery and share some code with you in the process.

After consulting [Posterous's API](http://posterous.com/api), I
realized I only really needed my "site_id" to pull all my posts in a
single JSON request. The following URLs were helpful for this:

```ruby
# http://posterous.com/api/2/users/me => authenticated user's info, including ID
# http://posterous.com/api/2/sites?id=1021298 => sites of user; figure out site_id
# http://posterous.com/api/2/sites/2464344/posts => all of kilotau's posts in JSON; using site_id
```

After I had my posts downloaded in `posts.json`, I transformed each
post to Markdown and manually formatted them for Octopress. I used the
simple [HTML2Markdown](https://github.com/singpolyma/HTML2Markdown)
script and the following code:

```ruby
# this uses ruby-1.9.3
require 'json'
require 'fileutils'
require './html2markdown.rb'
require 'date'

json = JSON.parse(File.read('./posts.json'))

json.map do |j|
  d = DateTime.parse(j['display_date'])
  filename = "./md/" + d.strftime('%Y-%m-%d') + "-" + j['slug'] + ".markdown"
  file = File.new(filename, "w")
  file.write "---\n"
  file.write "layout: post\n"
  file.write "title: " + "\"" + j['title'] + "\"" + "\n"
  file.write "date: " + j['display_date'] + "\n"
  file.write "comments: false\n"
  file.write "external-url:\n"
  file.write "categories:\n"
  file.write "---\n"
  file.write HTML2Markdown.new(j['body_cleaned'])
  file.close
end
```

In a moment, I had all my posts converted.

Now that I have my past posts, it's time to play with the design!
