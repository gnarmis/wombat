---
layout: post
title: Sentimental: A Simple Sentiment Analyzer in Clojure
date: 2012/07/06 17:49:00 -0700
tags: clojure, projects
---


TL;DR [https://github.com/gnarmis/sentimental][1]

Sentiment analysis is the hot thing to do these days. One example is
ViralHeat, a social media monitoring platform that uses sentiment
analysis to provide a picture about how the conversation is trending
about certain keywords (or combinations of keywords, which they call
profiles). There's a lot of such products, and for developers there's
a lot of high-quality and extensive libraries and toolkits that
provide for this among other solutions, such Java's WEKA or OpenNLP,
or Python's NLTK. There's even many third-party solutions that provide
an API you can use to get sentiment analysis, such as AlchemyAPI.

After deciding to create my very own sentiment analysis tool using
Clojure, I began researching libraries in both Java and Clojure
(because Clojure's interop means that I can easily use Java
libraries). There's a lot of powerful tools out there, but my goal was
to find something simple that could allow me to make a good enough
sentiment analyzer without breaking the technical bank, so to speak.

At first, I was looking for facilities to stem words, for which
someone had already provided a Clojure-wrapper around the Java library
Snowball. [I forked this and deployed it to Clojars][2]. This, and a
simple list of stop words to ignore, would allow me to reduce
redundancies and get a "bag of words" representation of the target
document.

Next, I wanted a nice and simple NLP library. [Clojure-OpenNLP][3] fit
the bill perfectly. It even had a document categorizer I could train!

Now, I should briefly explain the overall process. At the heart of the
sentiment analyzer is a naive-Bayesian classifier. This classifier is
provided with a labelled list as training material ("sad" is
"negative", "happy" is "positive"). The various categories are the
sentiments, such as "positive", "negative", "neutral" (I used 6
categories, for strong/weak sentiment). The classifier then learns to
associate categories with words, based on training information that is
supplied to it. Given a new sentence, the classifier then calculates
the probabilities of each word belonging to each category, and the
category with the best probability of covering the sentence is
returned. Learn more about how to build naive-Bayes classifiers
[here][4].

So, the next step was to get the actual training data. I found the
[subjectivity lexicon][5] to fit my needs perfectly. After parsing the
document into a vector of hash-maps, I was able to create a
[training document][6] for my very own opennlp model, which was to be
the classifier. The other step was to create a function that would
remove stop words and also stem each word. This was pretty easy to do
using the [snowball-stemmer][7] library and a few lines of Clojure.

Granted, I didn't build my own naive-Bayes classifier, but that's a
project for another time :)

And here's the project: https://github.com/gnarmis/sentimental

You do need to install Leiningen and have JDK 1.6 on your machine.
After these two steps, simply `cd` into the project and type `lein
repl`, following the example in the readme.



[1]: https://github.com/gnarmis/sentimental

[2]: http://kilotau.com/a-brief-foray-into-deploying-clojure-librarie

[3]: https://github.com/dakrone/clojure-opennlp

[4]: http://bionicspirit.com/blog/2012/02/09/howto-build-naive-bayes-classifier.html

[5]: http://www.cs.pitt.edu/mpqa/

[6]: https://github.com/gnarmis/sentimental/blob/master/src/models/sentiment.train

[7]: https://github.com/gnarmis/snowball-stemmer
