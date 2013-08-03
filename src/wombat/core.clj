(ns wombat.core
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [html5]]
            [garden.core :refer [css]]
            [clojure.java.io :as io]
            [clojure.string :as str])
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

(defn get-lines
  "given a file name, get the contents as a seq of lines"
  [file-name]
  (with-open [r (io/reader file-name)]
    (doall (line-seq r))))

(defn remove-front-matter
  [content-str]
  (let [splits (str/split content-str
                          #"---")]
    ;(println (last splits))
    (->> splits
         last
         str/triml)))

(defn post-name-clean
  [md-name]
  (str/replace (str/replace md-name
                            #"\.markdown"
                            "")
               #"posts\/"
               ""))

(defn write-shit
  [name content]
  (with-open [w (io/writer (io/file (str "public/"
                                         (post-name-clean name)
                                         ".html")))]
         (.write w content)))

(defn post-content
  "given a blog post's name, get the content and write it"
  [name]
  (->> name
       slurp
       str
       remove-front-matter
       md-to-html-string
       (write-shit name)))

(defn post-source
  []
  (filter #(not (.isDirectory %))
          (file-seq (io/file "posts"))))

(defn post-transformer
  []
  (->> (post-source)
       (map post-content)))



(comment

  (post-dest post-source)

  ;; post-source
  (post-source)

  ;; post transformer
  (post-transformer)
  
  ;; Writing to file
  
  (->> (list-of-posts)
     (index-body :list-posts)
     (index-page :body)
     (html5)
     (spit "public/index.html"))

  ;; markdown to html
  
  (md-to-html-string "# heading\n")

  
  ;; converting a post to html
  (post-content "2012-09-25-on-ruby-1-dot-9-s-flexible-syntax.markdown")


  
  )
