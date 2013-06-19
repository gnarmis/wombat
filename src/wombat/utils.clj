(ns wombat.utils
  (:require [wombat.styles.base :refer :all]
            [wombat.styles.layout :refer :all]
            [wombat.styles.skeleton :refer :all]
            [garden.core :refer [css]]
            [clojure.string :as string]))


(defn- rule-name-to-css-map
  "Helper function that computes the CSS and produces a
   map with rule name as key and a seq of CSS strings as
  the value"
  [rule-map]
  (apply
   merge
   (for [[name ruleset] rule-map]
     {name (map #(css %) ruleset)})))

(defn- stringify-rules
  "Produces string that represents an entire ruleset, with
   name as a comment"
  [rule-map]
  (for [[name rules] rule-map]
    (str "/* " name " */\n\n"
         (string/join "\n" rules))))

(defn generate-css
  "Produces CSS string fit for output, takes a rule-map"
  [rule-map]
  (->> (rule-name-to-css-map rule-map)
       (stringify-rules)
       (string/join "\n\n/*-----------*/\n\n")))

(defn base-css
  []
  (generate-css base-rules))

(defn layout-css
  []
  (generate-css layout-rules))

(defn skeleton-css
  []
  (generate-css skeleton-rules))