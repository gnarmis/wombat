(ns wombat.styles.skeleton
  (:require [garden.core :refer [css]]
            [garden.stylesheet :refer [at-media]]
            [garden.units :refer [px pt]]))

(def skeleton-rules
  "All rules pertaining to Skeleton CSS"
  {"Base 960 Grid Rules"
   #{[:.container
      {:position "relative"
       :width "960px"
       :margin "0 auto"
       :padding "0"}
      [:.column :.columns
       {:float "left"
        :display "inline"
        :margin-left "10px"
        :margin-right "10px"}]]

     [:.row {:margin-bottom "20px"}]

     [:.column
      [:&.alpha :&.omega
       {:margin-left 0
        :margin-right 0}]]

     [:.container
      [:.one
       [:.columns :.columns {:width "40px"}]]
      [:.two
       [:.columns :.columns {:width "100px"}]]
      [:.three
       [:.columns :.columns {:width "160px"}]]
      [:.four
       [:.columns :.columns {:width "220px"}]]
      [:.five
       [:.columns :.columns {:width "280px"}]]
      [:.six
       [:.columns :.columns {:width "340px"}]]
      [:.seven
       [:.columns :.columns {:width "400px"}]]
      [:.eight
       [:.columns :.columns {:width "460px"}]]
      [:.nine
       [:.columns :.columns {:width "520px"}]]
      [:.ten
       [:.columns :.columns {:width "580px"}]]
      [:.eleven
       [:.columns :.columns {:width "640px"}]]
      [:.twelve
       [:.columns :.columns {:width "700px"}]]
      [:.thirteen
       [:.columns :.columns {:width "760px"}]]
      [:.fourteen
       [:.columns :.columns {:width "820px"}]]
      [:.fifteen
       [:.columns :.columns {:width "880px"}]]
      [:.sixteen
       [:.columns :.columns {:width "940px"}]]
      [:.one-third
       [:.columns :.columns {:width "300px"}]]
      [:.two-thirds
       [:.columns :.columns {:width "620px"}]]

      [:.offset-by-one {:padding-left "60px"}]
      [:.offset-by-two {:padding-left "120px"}]
      [:.offset-by-three {:padding-left "180px"}]
      [:.offset-by-four {:padding-left "240px"}]
      [:.offset-by-five {:padding-left "300px"}]
      [:.offset-by-six {:padding-left "360px"}]
      [:.offset-by-seven {:padding-left "420px"}]
      [:.offset-by-eight {:padding-left "480px"}]
      [:.offset-by-nine {:padding-left "540px"}]
      [:.offset-by-ten {:padding-left "600px"}]
      [:.offset-by-eleven {:padding-left "660px"}]
      [:.offset-by-twelve {:padding-left "720px"}]
      [:.offset-by-thirteen {:padding-left "780px"}]
      [:.offset-by-fourteen {:padding-left "840px"}]
      [:.offset-by-fifteen {:padding-left "900px"}]]
     }

   "Tablet (Portait)"
   #{(at-media {:min-width "767px" :screen true}
               [:.container {:width "768px"}]

               [:.container
                [:.column :.columns
                 {:margin 0}]]

               [:.container
                [:.one
                 [:.columns :.columns {:width "300px"}]]
                [:.two
                 [:.columns :.columns {:width "300px"}]]
                [:.three
                 [:.columns :.columns {:width "300px"}]]
                [:.four
                 [:.columns :.columns {:width "300px"}]]
                [:.five
                 [:.columns :.columns {:width "300px"}]]
                [:.six
                 [:.columns :.columns {:width "300px"}]]
                [:.seven
                 [:.columns :.columns {:width "300px"}]]
                [:.eight
                 [:.columns :.columns {:width "300px"}]]
                [:.nine
                 [:.columns :.columns {:width "300px"}]]
                [:.ten
                 [:.columns :.columns {:width "300px"}]]
                [:.eleven
                 [:.columns :.columns {:width "300px"}]]
                [:.twelve
                 [:.columns :.columns {:width "300px"}]]
                [:.thirteen
                 [:.columns :.columns {:width "300px"}]]
                [:.fourteen
                 [:.columns :.columns {:width "300px"}]]
                [:.fifteen
                 [:.columns :.columns {:width "300px"}]]
                [:.sixteen
                 [:.columns :.columns {:width "300px"}]]
                [:.one-third
                 [:.columns :.columns {:width "300px"}]]
                [:.two-thirds
                 [:.columns :.columns {:width "300px"}]]

                [:.offset-by-one {:padding-left 0}]
                [:.offset-by-two {:padding-left 0}]
                [:.offset-by-three {:padding-left 0}]
                [:.offset-by-four {:padding-left 0}]
                [:.offset-by-five {:padding-left 0}]
                [:.offset-by-six {:padding-left 0}]
                [:.offset-by-seven {:padding-left 0}]
                [:.offset-by-eight {:padding-left 0}]
                [:.offset-by-nine {:padding-left 0}]
                [:.offset-by-ten {:padding-left 0}]
                [:.offset-by-eleven {:padding-left 0}]
                [:.offset-by-twelve {:padding-left 0}]
                [:.offset-by-thirteen {:padding-left 0}]
                [:.offset-by-fourteen {:padding-left 0}]
                [:.offset-by-fifteen {:padding-left 0}]])}

   "Mobile (Landscape)"
   #{(at-media {:min-width "480px" :screen true :max-width "767px"}
               [:.container {:width "768px"}]

               [:.container
                {:width "420px"}
                [:.column :.columns
                 {:margin 0}]]

               [:.container
                [:.one
                 [:.columns :.columns {:width "420px"}]]
                [:.two
                 [:.columns :.columns {:width "420px"}]]
                [:.three
                 [:.columns :.columns {:width "420px"}]]
                [:.four
                 [:.columns :.columns {:width "420px"}]]
                [:.five
                 [:.columns :.columns {:width "420px"}]]
                [:.six
                 [:.columns :.columns {:width "420px"}]]
                [:.seven
                 [:.columns :.columns {:width "420px"}]]
                [:.eight
                 [:.columns :.columns {:width "420px"}]]
                [:.nine
                 [:.columns :.columns {:width "420px"}]]
                [:.ten
                 [:.columns :.columns {:width "420px"}]]
                [:.eleven
                 [:.columns :.columns {:width "420px"}]]
                [:.twelve
                 [:.columns :.columns {:width "420px"}]]
                [:.thirteen
                 [:.columns :.columns {:width "420px"}]]
                [:.fourteen
                 [:.columns :.columns {:width "420px"}]]
                [:.fifteen
                 [:.columns :.columns {:width "420px"}]]
                [:.sixteen
                 [:.columns :.columns {:width "420px"}]]
                [:.one-third
                 [:.columns :.columns {:width "420px"}]]
                [:.two-thirds
                 [:.columns :.columns {:width "420px"}]]])}

   "Clearing rules"
   #{[:.container
      [:&:after
       {:content "\0020"
        :display "block"
        :height 0
        :clear "both"
        :visibility "hidden"}]]

     [:.clearfix :.row
      [:&:before :&:after
       {:content "\0020"
        :display "block"
        :overflow "hidden"
        :visibility "hidden"
        :width 0
        :height 0}]
      [:&:after
       {:clear "both"}]]

     [:.clearfix {:zoom 1}]

     [:.clear
      {:clear "both"
       :display "block"
       :overflow "hidden"
       :visibility "hidden"
       :width 0
       :height 0}]}
   })