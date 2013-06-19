(ns wombat.core
  (:require [hiccup.core :as h]
            [clojure.java.io :as io]))

(defn html-rendering-example []
  (def target
    "Describes the output file locations"
    {:index "public/index.html"})

  (def eg-html (h/html [:div "hello!"]))

  (defn write-index
    "Spits given string into the index file"
    [target content]
    (spit (:index target)
          content))

  (write-index target eg-html))