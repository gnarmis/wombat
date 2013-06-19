(ns wombat.pages.base
  (:require [hiccup.core :as hc]
            [hiccup.page :as hp]))

(defn generate-base
  "Very basic html template generator. Can take :head-content
  and :body-content keyword arguments"
  [& {:keys [head-content body-content]}]
  (hc/html
   (hp/html5
    [:head
     head-content]
    [:body
     body-content])))
