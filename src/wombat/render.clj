(ns wombat.render
  (:require [wombat.utils :refer :all]))

(defn- render-style
  "Spits out CSS to file"
  [css]
  (spit "public/stylesheets/app.css"
        css))

(defn render-all-styles
  "Renders all the styles to CSS file"
  []
  (->> [(base-css) (skeleton-css) (layout-css)]
      (reduce str)
      (render-style)))

