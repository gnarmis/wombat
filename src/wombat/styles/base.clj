(ns wombat.styles.base
  (:require [garden.core :refer [css]]))

(def base-rules
  "A map from ruleset name to set of rules"
  {"Reset and basic rules"
   #{[:html :body :div :span :applet :object :iframe :h1 :h2 :h3 :h4 :h5 :h6
      :p :blockquote :pre :a :abbr :acronym :address :big :cite :code :del
      :dfn :em :img :ins :kbd :q :s :samp :small :strike :strong :sub :sup
      :tt :var :b :u :i :center :dl :dt :dd :ol :ul :li :fieldset :form :label
      :legen :table :caption :tbody :tfoot :thead :tr :th :td :article :aside
      :canvas :details :embed :figure :figcaption :footer :header :hgroup
      :menu :nav :output :ruby :section :summary :time :mark :audio :video
      {:margin 0
       :padding 0
       :border 0
       :font-size "100%"
       :font "inherit"
       :vertical-align "baseline"
       }]
     
     [:article :aside :details :figcaption :figure :footer :header :hgroup
      :menu :nav :section
      {:display "block"}]

     [:body
      {:line-height 1}]

     [:ol :ul
      {:list-style "none"}]

     [:blockquote :q
      {:quotes "none"}
      [:&:before :&:after
       {:content "none"}]]

     [:table
      {:border-collapse "collapse"
       :border-spacing 0}]}

   "Basic style rules"
   #{[:body
      {:background "#fff"
       :font "14px/21px \"HelveticaNeue\", \"HelveticaNeue\", Helvetica, Arial, sans-serif"
       :color "#444"
       :-webkit-font-smoothing "antialised"
       :-webkit-text-size-adjust "100%"}]}


   "Typography rules"
   #{[:h1 :h2 :h3 :h4 :h5 :h6
      {:color "#181818"
       :font-family "\"Georgia\", \"Times New Roman\", serif"
       :font-weight "normal"}
      [:a
       {:font-weight "inherit"}]]

     [:h1
      {:font-size "46px"
       :line-height "50px"
       :margin-bottom "14px"}]

     [:h2
      {:font-size "35px"
       :line-height "40px"
       :margin-bottom "10px"}]

     [:h3
      {:font-size "28px"
       :line-height "34px"
       :margin-bottom "8px"}]

     [:h4
      {:font-size "21px"
       :line-height "30px"
       :margin-bottom "4px"}]

     [:h5
      {:font-size "17px"
       :line-height "24px"}]

     [:h6
      {:font-size "14px"
       :line-height "21px"}]

     [:.subheader {:color "#777"}]

     [:p {:margin "0 0 20px 0"}
      [:&.lead
       {:font-size "21px"
        :line-height "27px"
        :color "#777"}]
      [:img {:margin "0"}]]

     [:em {:font-style "italic"}]

     [:strong
      {:font-weight "bold"
       :color "#333"}]

     [:small {:font-size "80%"}]

     [:blockquote
      {:font-size "17px"
       :line-height "24px"
       :color "#777"
       :font-style "italic"}
      [:p
       {:font-size "17px"
        :line-height "24px"
        :color "#777"
        :font-style "italic"}]]

     [:blockquote
      {:margin "0 0 20px"
       :padding "9px 20px 0 19px"
       :border-left "1px solid #ddd"}
      [:cite
       {:display "block"
        :font-size "12px"
        :color "#555"}
       [:&:before {:content "\2014 \0020"}]
       [:a :a:visited {:color "#555"}]]]

     [:hr
      {:border "solid #ddd"
       :border-width "1px 0 0"
       :clear "both"
       :margin "10px 0 30px"
       :height "0"}]
     }


   "Links rules"
   #{[:a :a:visited
      {:color "#333"
       :text-decoration "underline"
       :outline "0"}]

     [:a:hover :a:focus
      {:color "#000"}]

     [:p
      [:a :a:visited
       {:line-height "inherit"}]]}



   "Lists rules"
   #{[:ul :ol {:margin-bottom "20px"}]

     [:ul {:list-style "none outside"}]

     [:ol {:list-style "decimal"}]

     [:ol :ul.square :ul.circle :ul.disc
      {:margin-left "30px"}]

     [:ul
      [:&:square {:list-style "square outside"}]
      [:&:circle {:list-style "circle outside"}]
      [:&.disc {:list-style "disc outside"}]]

     [:ul :ol
      [:ul :ol
       {:margin "4px 0 5px 30px"
        :font-size "90%"}
       [:li {:margin-bottom "12px"}]]]

     [:li
      {:line-height "18px"
       :margin-bottom "12px"}
      [:p {:line-height "21px"}]]

     [:ul.large
      [:li {:line-height "21px"}]]
     }


   "Images rules"
   #{[:img.scale-with-grid
      {:max-width "100%"
       :height "auto"}]}


   "Buttons rules"
   #{[:.button :button "input[type=\"submit\"]" "input[type=\"reset\"]"
      "input[type=\"button\""
      {:background "#eee"
       :border "1px solid #aaa"
       :border-top "1px solid #ccc"
       :border-left "1px solid #ccc"
       :-moz-border-radius "3px"
       :-webkit-border-radius "3px"
       :border-radius "3px"
       :color "#444"
       :display "inline-block"
       :font-size "11px"
       :font-weight "bold"
       :text-decoration "none"
       :text-shadow "0 1px rgba(255, 255, 255, .75)"
       :cursor "pointer"
       :margin-bottom "20px"
       :line-height "normal"
       :padding "8px 10px"
       :font-family "\"HelveticaNeue\", \"HelveticaNeue\", Helvetica, Arial, sans-serif"}
      [:&:hover
       {:color "#222"
        :background "#ddd"
        :border "1px solid #888"
        :border-top "1px solid #aaa"
        :border-left "1px solid #aaa"}]
      [:&:active
       {:border "1px solid #666"
        :background "#ccc"}]
      [:&.full-width
       {:width "100%"
        :padding-left "0 !important"
        :padding-right "0 !important"
        :text-align "center"}]]

     ["button::-moz-focus-inner" "input::-moz-focus-inner"
      {:border "0"
       :padding "0"
       }]
     }


   "Forms rules"
   #{[:form :fieldset {:margin-bottom "20px"}]
     ["input[type=\"text\"]" "input[type=\"password\"]" "input[type=\"email\"]"
      :textarea :select
      {:border "1px solid #ccc"
       :padding "6px 4px"
       :outline "none"
       :-mox-border-radius "2px"
       :-webkit-border-radius "2px"
       :border-radius "2px"
       :font "13px \"HelveticaNeue\", \"HelveticaNeue\", Helvetica, Arial, sans-serif"
       :color "#777"
       :margin "0"
       :width "210px"
       :max-width "100%"
       :display "block"
       :margin-bottom "20px"
       :background "#fff"}]

     [:select
      {:padding "0"
       :width "220px"}]

     ["input[type=\"text\"]" "input[type=\"password\"]" "input[type=\"email\"]"
      :textarea
      [:&:focus
       {:border "1px solid #aaa"
        :color "#444"
        :-moz-box-shadow "0 0 3px rgba(0,0,0,.2)"
        :-webkit-box-shadow "0 0 3px rgba(0,0,0,.2)"
        :box-shadow "0 0 3px rgba(0,0,0,.2)"}]]

     [:textarea {:min-height "60px"}]

     [:label :legend
      {:display "block"
       :font-weight "bold"
       :font-size "13px"}
      [:span
       {:font-weight "normal"
        :font-size "13px"
        :color "#444"}]]

     ["input[type=\"checkbox\"]" {:display "inline"}]}



   "Miscellaneous rules"
   #{[:.remove-bottom {:margin-bottom "0 !important"}]

     [:.half-bottom {:margin-bottom "10px !important"}]

     [:.add-bottom {:margin-bottom "20px !important"}]}})