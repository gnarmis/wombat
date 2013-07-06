(ns wombat.core
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [html5]]
            [garden.core :refer [css]])
  (:use markdown.core))


(defn list-of-posts
  "A stand-in for producing a list of posts."
  []
  (list
   [:style (css [:li.post-item
                 {:list-style "none"}])]
   [:ul#list-posts
    [:li.post-item "Post 1"]
    [:li.post-item "Post 2"]]))

(defn index-body
  "The body of the index page."
  [& {:keys [list-posts]}]
  (list
   [:style (css [:div#main-content
                 {:margin "0 auto 0"
                  :padding "0"
                  :clear "both"}])]
   [:div#main-content
    [:h1 "Wombat"]
    list-posts]))

(defn index-page
  "The main page of the static website. Takes keyword args: body."
  [& {:keys [body]}]
  (list
   [:head
    [:title "Wombat"]
    [:style ""]]
   [:body
    body]))

(comment

  ;; Writing to file
  
  (->> (list-of-posts)
     (index-body :list-posts)
     (index-page :body)
     (html5)
     (spit "public/index.html"))

  ;; markdown to html
  
  (md-to-html-string "# heading\n")

  )
