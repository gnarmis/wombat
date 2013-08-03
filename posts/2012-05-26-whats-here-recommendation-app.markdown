---
layout: post
title: What's Here?: A Mobile App for Local, Personal Recommendations
date: 2012/05/26 18:05:00 -0800
tags: mobile, projects, ruby, javascript, html5
---

Introducing [What's Here?][1], an app to help you explore your local
people, places, and tweets.

This mobile app was an exploration of a project idea about searching
and making sense of locally relevant data. It was explored in the
context of my [Journalism & Tech project class][2].

You can use this app on any modern smartphone, though it was tested
only on the iPhone 4. Also, you can try the app on a tablet or regular
computer's browser as well.

The premise was this: a person walking around in a downtown area wants
to find out what the buzz is about their current location. Perhaps
they want a super quick way to find out the most interesting places
nearby. They could launch Google Maps and search for things, and then
perhaps switch to other apps such as FourSquare that similarly provide
information about places nearby. They could also launch several other
apps, or drill down to the comments in the Yelp app, to find out what
people are saying about places. There isn't currently a single app or
a single experience which meshes all these various information-finding
activities together. Another thing to consider is recommendations
based on that person's Twitter activity, and how that should affect
their search.

Using Hunch and Twitter's API, we built a mobile experience that was
designed to solve the problem of providing local and personally
relevant information in one application. All that is required from the
user is their Twitter username. Using this and the geolocation
provided by the phone, we derive a lot of useful information, such as
a grouped list of the most relevant places, tweets about those places,
people near those places, and related places of interest. There are
three types of such inter-linked areas of information: places, people,
and tweets. These are provided as part of the tabbed navigation.

This project is currently a functioning prototype that shows enough
promise to be worth iterating on or reexamining from the ground up.

Collaborators: Kavya Chandrasekaran, Taylor Culbertson, Gursimran
Singh, Long Yu

[1]: http://whatshere.herokuapp.com

[2]: http://www.eecs.northwestern.edu/course-descriptions/eecs-395495-special-topics-innovation-in-journalism-a-technology.html
